package com.example.noteapp_back.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.*;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Note implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column
    private String description;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "note_type",
    joinColumns = @JoinColumn(name = "note_id"),
    inverseJoinColumns = @JoinColumn(name = "type_id"))
    private Set<Type> types = new HashSet<>();

    //Bidirectional operations for many to many
    public void addType(Type type){
        types.add(type);
        type.getNotes().add(this);
    }

    public void removeType(Type type){
        types.remove(type);
        type.getNotes().remove(this);
    }

    public Note(String title, String description) {
        this.title = title;
        this.description = description;
    }
}