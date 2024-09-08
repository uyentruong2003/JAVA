package com.pluralsight.courseinfo.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {
    // for cases where input is empty string
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void id(String inputId) {
        assertThrows(IllegalArgumentException.class, () -> new Course(inputId, "name", 123, "url"));
    }
    // for cases where input is null
    @Test
    void nullName() {
        assertThrows(IllegalArgumentException.class, () -> new Course(null, "name", 123, "url"));
    }
}