package com.example.noteapp_back.service;

import com.example.noteapp_back.entity.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.noteapp_back.repository.NoteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    @Autowired
    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public Note getNoteById(Long noteId) {
        Optional<Note> optionalUser = noteRepository.findById(noteId);
        return optionalUser.get();
    }

    @Override
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    public Note updateNote(Note note) {
        Note existingNote = noteRepository.findById(note.getId()).get();
        existingNote.setTitle(note.getTitle());
        existingNote.setDescription(note.getDescription());
        return noteRepository.save(existingNote);
    }

    @Override
    public void deleteNote(Long noteId) {
        noteRepository.deleteById(noteId);
    }
}