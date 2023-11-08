package com.example.noteapp_back.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Type implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column
    private String description;

    @ManyToMany(mappedBy = "types")
    private Set<Note> notes = new HashSet<>();

    public Type(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Type(String title) {
        this.title = title;
    }
}
