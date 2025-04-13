package com.decode.decode.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("config_journal_app")
@Data
@AllArgsConstructor
public class ConfigJournalAppEntity {
    String key;
    String value;
}
