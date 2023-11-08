package com.example.noteapp_back.controller;

import com.example.noteapp_back.entity.Note;
import com.example.noteapp_back.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/notes")
public class NoteController {

    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note) {
        Note savedUser = noteService.createNote(note);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    // http://localhost:8080/api/notes/1
    @GetMapping("{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable("id") Long noteId) {
        Note user = noteService.getNoteById(noteId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // http://localhost:8080/api/users
    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes() {
        List<Note> users = noteService.getAllNotes();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // http://localhost:8080/api/users/1
    @PutMapping("{id}")
    public ResponseEntity<Note> updateNote(@PathVariable("id") Long noteId,
                                           @RequestBody Note user) {
        user.setId(noteId);
        Note updatedUser = noteService.updateNote(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    // Build Delete User REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteNote(@PathVariable("id") Long noteId) {
        noteService.deleteNote(noteId);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }
}