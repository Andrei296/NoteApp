package com.example.noteapp_back.service;

import com.example.noteapp_back.entity.Type;
import com.example.noteapp_back.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeServiceImpl implements TypeService {

    private final TypeRepository typeRepository;

    @Autowired
    public TypeServiceImpl(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Override
    public Type createType(Type type) {
        return typeRepository.save(type);
    }

    @Override
    public Type getTypeById(Long typeId) {
        Optional<Type> optionalUser = typeRepository.findById(typeId);
        return optionalUser.get();
    }

    @Override
    public List<Type> getAllTypes() {
        return typeRepository.findAll();
    }

    @Override
    public Type updateType(Type type) {
        Type existingType = typeRepository.findById(type.getId()).get();
        existingType.setTitle(type.getTitle());
        existingType.setDescription(type.getDescription());
        return typeRepository.save(existingType);
    }

    @Override
    public void deleteType(Long noteId) {
        typeRepository.deleteById(noteId);
    }
}