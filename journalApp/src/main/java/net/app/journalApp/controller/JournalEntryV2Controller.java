package net.app.journalApp.controller;

import net.app.journalApp.entity.JournalEntry;
import net.app.journalApp.service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalEntryV2Controller {

    @Autowired
    private JournalEntryService journalEntryService;

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry) {
        journalEntryService.saveEntry(myEntry);
        return true;
    }


    @GetMapping
    public List<JournalEntry> getAllEntry() {
        return  null;
    }



    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable Long myId){
        return null;
    }

    @DeleteMapping("id/{myId}")
    public JournalEntry deleteJournalEntryById(@PathVariable Long myId){
        return null;
    }
    @PutMapping("update/{myId}")
    public boolean updateJournalEntryById(@PathVariable Long myId,@RequestBody JournalEntry myEntry){

        return true;
    }
}
