package com.example.noteapp_back.repository;

import com.example.noteapp_back.entity.Note;
import com.example.noteapp_back.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {

}