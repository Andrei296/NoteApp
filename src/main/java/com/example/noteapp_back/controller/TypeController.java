package com.example.noteapp_back.controller;

import com.example.noteapp_back.entity.Type;
import com.example.noteapp_back.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/types")
public class TypeController {
    private final TypeService typeService;

    @Autowired
    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @PostMapping
    public ResponseEntity<Type> createType(@RequestBody Type type) {
        Type savedUser = typeService.createType(type);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    // http://localhost:8080/api/types/1
    @GetMapping("{id}")
    public ResponseEntity<Type> getTypeById(@PathVariable("id") Long typeId) {
        Type user = typeService.getTypeById(typeId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // http://localhost:8080/api/types
    @GetMapping
    public ResponseEntity<List<Type>> getAllTypes() {
        List<Type> users = typeService.getAllTypes();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // http://localhost:8080/api/types/1
    @PutMapping("{id}")
    public ResponseEntity<Type> updateNote(@PathVariable("id") Long noteId,
                                           @RequestBody Type type) {
        type.setId(noteId);
        Type updatedUser = typeService.updateType(type);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    // Build Delete User REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteNote(@PathVariable("id") Long typeId) {
        typeService.deleteType(typeId);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }
}
