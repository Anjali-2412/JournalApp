package net.app.journalApp.entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;


@Document(collection = "JournalApp_entries")
@Data // @Data contains -> @Getter @Setter and many more
public class JournalEntry {

    @Id
    private ObjectId id;

    private String title;

    private String content;

    private LocalDate date;
}