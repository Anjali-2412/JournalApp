package net.app.journalApp.service;

import net.app.journalApp.entity.JournalEntry;
import net.app.journalApp.entity.User;
import net.app.journalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService  {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    private UserService userService;

    public void saveEntry(JournalEntry journalEntry){
        journalEntryRepository.save(journalEntry);
    }


    @Transactional
    public void saveEntry (JournalEntry journalEntry, String username){
        try{
            User user = userService.findByUserName(username);
            journalEntry.setDate(LocalDate.now());
            JournalEntry saved  = journalEntryRepository.save(journalEntry);
            user.getJournalEntries().add(saved);
            userService.saveUser(user);
        } catch (Exception e) {

            System.out.print(e);
            throw new RuntimeException("An error occurred with saying the entry. "+e);
        }

    }

    public List<JournalEntry> getAll(){
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> findById(ObjectId id){
        return journalEntryRepository.findById(id);
    }

    @Transactional
    public boolean deleteById(ObjectId id, String username) {
        boolean removed = false;
        try{
        User user = userService.findByUserName(username);
        removed = user.getJournalEntries().removeIf(x -> x.getId().equals(id));
        if (removed) {
            userService.saveUser(user);
            journalEntryRepository.deleteById(id);
        }

        } catch (Exception e) {
            System.out.println(e);

            throw new RuntimeException("An error occurred while deleting the entry. ",e);
        }

        return removed;
    }


}
