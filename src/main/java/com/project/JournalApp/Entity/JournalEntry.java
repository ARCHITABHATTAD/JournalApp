package com.project.JournalApp.Entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "journal_entries")
//@Getter
//@Setter
//@Builder
@NoArgsConstructor
@AllArgsConstructor
//@ToString
//@EqualsAndHashCode
@Data
public class JournalEntry {

    @Id
    private ObjectId id;
    private String title;
    private String content;
    private LocalDateTime date;

}