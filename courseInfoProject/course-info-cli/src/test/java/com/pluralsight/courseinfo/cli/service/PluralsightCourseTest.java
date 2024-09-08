package com.pluralsight.courseinfo.cli.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PluralsightCourseTest {

    @Test
    void durationInMinutes() {
        PluralsightCourse course = new PluralsightCourse("id","title","00:05:37","url",false);
        assertEquals(5,course.durationInMinutes());
    }

//    @Test
//    void durationInMinutesOverHour() {
//        PluralsightCourse course = new PluralsightCourse("id","title","01:08:54.961330","url",false);
//        assertEquals(68,course.durationInMinutes());
//    }
//
//    @Test
//    void durationInMinutesZero() {
//        PluralsightCourse course = new PluralsightCourse("id","title","00:00:00","url",false);
//        assertEquals(0,course.durationInMinutes());
//    }

    @ParameterizedTest
    //textBlock """ --> allow input a series of multiple parameter sets, separated by entering a new line
    @CsvSource(textBlock= """
            01:08:54.961330, 68
            00:05:37, 5
            00:00:00, 0
            """)
    void durationInMinutesParameterized(String input, long expected){
        PluralsightCourse course = new PluralsightCourse("id","title",input,"url",false);
        assertEquals(expected,course.durationInMinutes());
    }
}