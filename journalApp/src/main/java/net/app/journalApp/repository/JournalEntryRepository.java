package net.app.journalApp.repository;

import net.app.journalApp.entity.JournalEntry;
import net.app.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntryRepository extends MongoRepository<JournalEntry, ObjectId> {

}
