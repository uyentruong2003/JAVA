package com.training.springboot.trainingProject.events;

import java.util.List;
import java.util.Optional;

public class VenueRepository {
    //field "venues": List of venues
    private final List<Venue> venues = List.of(
            new Venue(201,"Globomatics Main Office","Test Street 325", "New York","USA"),
            new Venue(202, "Sea View Hotel","Beach Boulevard 863","Los Angeles","USA"));
    // method "findById": return an Optional (?) of venues that have the id being looked for
    public Optional<Venue> findById(int id) {
        return venues.stream().filter(venue -> venue.id() == id).findAny();
    }
}
