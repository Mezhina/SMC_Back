package com.smc.demo.controller;


import com.smc.demo.dto.RecordDto;
import com.smc.demo.model.FieldDefinition;
import com.smc.demo.service.EavService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/eav")
@RequiredArgsConstructor
public class EavController {
    private final EavService eavService;

    @GetMapping("/entities/{code}/fields")
    public ResponseEntity<List<FieldDefinition>> getFields(@PathVariable String code) {
        return ResponseEntity.ok(eavService.getFieldsByEntityCode(code));
    }

    @GetMapping("/entities/{code}/records")
    public ResponseEntity<List<RecordDto>> getAllRecords(@PathVariable String code) {
        return ResponseEntity.ok(eavService.getAllRecordsForEntity(code));
    }

    @GetMapping("/entities/{code}/records/{recordId}")
    public ResponseEntity<RecordDto> getRecord(@PathVariable String code, @PathVariable String recordId) {
        return ResponseEntity.ok(eavService.getRecord(code, recordId));
    }

    @PostMapping("/entities/{code}/records/{recordId}")
    public ResponseEntity<Void> upsertRecord(
            @PathVariable String code,
            @PathVariable String recordId,
            @RequestBody Map<String, Object> values // map fieldName -> value
    ) {
        eavService.upsertRecord(code, recordId, values);
        return ResponseEntity.ok().build();
    }
}