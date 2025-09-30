package com.smc.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Map;

@Data
@AllArgsConstructor
public class RecordDto {
    private String recordId;
    private Map<String, Object> fields; // map fieldName -> value
}