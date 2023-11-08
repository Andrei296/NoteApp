package com.example.noteapp_back.service;

import com.example.noteapp_back.entity.Type;

import java.util.List;

public interface TypeService {
    Type createType(Type type);

    Type getTypeById(Long typeId);

    List<Type> getAllTypes();

    Type updateType(Type type);

    void deleteType(Long typeId);
}