package com.smc.demo.service;

import com.smc.demo.dto.RecordDto;
import com.smc.demo.model.EntityType;
import com.smc.demo.model.EntityValue;
import com.smc.demo.model.FieldDefinition;
import com.smc.demo.repository.EntityTypeRepository;
import com.smc.demo.repository.FieldDefinitionRepository;
import com.smc.demo.repository.EntityValueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EavService {
    private final EntityTypeRepository entityTypeRepository;
    private final FieldDefinitionRepository fieldDefinitionRepository;
    private final EntityValueRepository entityValueRepository;

    @Transactional(readOnly = true)
    public List<FieldDefinition> getFieldsByEntityCode(String entityCode) {
        EntityType et = entityTypeRepository.findByCode(entityCode)
                .orElseThrow(() -> new NoSuchElementException("Entity not found: " + entityCode));
        return fieldDefinitionRepository.findByEntityOrderByOrdinalAsc(et);
    }

    @Transactional(readOnly = true)
    public List<RecordDto> getAllRecordsForEntity(String entityCode) {
        EntityType et = entityTypeRepository.findByCode(entityCode)
                .orElseThrow(() -> new NoSuchElementException("Entity not found: " + entityCode));
        List<FieldDefinition> fields = fieldDefinitionRepository.findByEntityOrderByOrdinalAsc(et);
        // all values for entity (will be many)
        List<EntityValue> values = entityValueRepository.findByField_Entity_Id(et.getId());

        // group by recordId
        Map<String, List<EntityValue>> byRecord = values.stream().collect(Collectors.groupingBy(EntityValue::getRecordId));
        List<RecordDto> result = new ArrayList<>();
        for (Map.Entry<String, List<EntityValue>> e : byRecord.entrySet()) {
            String recordId = e.getKey();
            Map<String, Object> map = new LinkedHashMap<>();
            // preserve order by fields list
            for (FieldDefinition fd : fields) {
                Optional<EntityValue> ev = e.getValue().stream().filter(v -> v.getField().getId().equals(fd.getId())).findFirst();
                if (ev.isPresent()) {
                    map.put(fd.getName(), parseValue(ev.get().getValue(), fd.getDataType()));
                } else {
                    map.put(fd.getName(), null);
                }
            }
            result.add(new RecordDto(recordId, map));
        }
        return result;
    }

    @Transactional(readOnly = true)
    public RecordDto getRecord(String entityCode, String recordId) {
        EntityType et = entityTypeRepository.findByCode(entityCode)
                .orElseThrow(() -> new NoSuchElementException("Entity not found: " + entityCode));
        List<FieldDefinition> fields = fieldDefinitionRepository.findByEntityOrderByOrdinalAsc(et);
        List<EntityValue> values = entityValueRepository.findByRecordId(recordId);
        Map<String, Object> map = new LinkedHashMap<>();
        for (FieldDefinition fd : fields) {
            Optional<EntityValue> ev = values.stream().filter(v -> v.getField().getId().equals(fd.getId())).findFirst();
            map.put(fd.getName(), ev.map(entityValue -> parseValue(entityValue.getValue(), fd.getDataType())).orElse(null));
        }
        return new RecordDto(recordId, map);
    }

    // create/update record - upsert values
    @Transactional
    public void upsertRecord(String entityCode, String recordId, Map<String, Object> valuesByFieldName) {
        EntityType et = entityTypeRepository.findByCode(entityCode)
                .orElseThrow(() -> new NoSuchElementException("Entity not found: " + entityCode));
        List<FieldDefinition> fields = fieldDefinitionRepository.findByEntityOrderByOrdinalAsc(et);
        Map<String, FieldDefinition> byName = fields.stream().collect(Collectors.toMap(FieldDefinition::getName, f -> f));
        for (Map.Entry<String, Object> e : valuesByFieldName.entrySet()) {
            FieldDefinition fd = byName.get(e.getKey());
            if (fd == null) throw new IllegalArgumentException("Unknown field: " + e.getKey());
            String stringVal = serializeValue(e.getValue(), fd.getDataType());
            // find existing
            Optional<EntityValue> existing = entityValueRepository.findByField_IdAndRecordId(fd.getId(), recordId)
                    .stream().findFirst();
            if (existing.isPresent()) {
                EntityValue ev = existing.get();
                ev.setValue(stringVal);
                entityValueRepository.save(ev);
            } else {
                EntityValue ev = EntityValue.builder()
                        .field(fd)
                        .recordId(recordId)
                        .value(stringVal)
                        .build();
                entityValueRepository.save(ev);
            }
        }
    }

    private Object parseValue(String raw, String dataType) {
        if (raw == null) return null;
        try {
            switch (dataType) {
                case "integer": return Long.parseLong(raw);
                case "decimal": return Double.parseDouble(raw);
                case "boolean": return Boolean.parseBoolean(raw);
                case "json": return raw; // let front parse JSON if needed
                case "date": return raw; // ISO date string
                default: return raw;
            }
        } catch (Exception ex) {
            return raw; // fallback to raw string
        }
    }

    private String serializeValue(Object value, String dataType) {
        if (value == null) return null;
        // keep it simple: convert to string
        return String.valueOf(value);
    }
}
