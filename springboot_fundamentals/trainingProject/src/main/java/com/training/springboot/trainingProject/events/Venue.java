package com.training.springboot.trainingProject.events;

public record Venue(
        int id,
        String name,
        String street,
        String city,
        String country) {
}
