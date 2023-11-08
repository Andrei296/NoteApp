package com.example.noteapp_back.service;

import com.example.noteapp_back.entity.Note;

import java.util.List;

public interface NoteService {
    Note createNote(Note note);

    Note getNoteById(Long noteId);

    List<Note> getAllNotes();

    Note updateNote(Note note);

    void deleteNote(Long noteId);
}