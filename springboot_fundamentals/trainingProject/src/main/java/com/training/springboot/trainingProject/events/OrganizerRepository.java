package com.training.springboot.trainingProject.events;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrganizerRepository {
    //field "organizers": a List of organizers
    private final List<Organizer> organizers = List.of(
            new Organizer(101, "Globomantics", "Globomantics Technology Corporation"),
            new Organizer(102, "Carved Rock", "Carved Rock Sports Equipment"));
    //method "findAll": return all organizers
    public List<Organizer> findAll() {
        return organizers;
    }
}
