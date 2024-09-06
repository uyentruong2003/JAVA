package com.spring_boot_fundamentals.tickets.events;

public record Organizer(
        int id,
        String name,
        String description) {
}
