package com.pluralsight.courseinfo.cli.service;

import com.pluralsight.courseinfo.domain.Course;
import com.pluralsight.courseinfo.repository.CourseJdbcRepository;
import com.pluralsight.courseinfo.repository.CourseRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourseStorageServiceTest {

    @Test
    void storePluralsightCourses() {

        CourseRepository repos = new InMemoryCourseRepository();
        CourseStorageService courseStorageService = new CourseStorageService(repos);

        //example course:
        PluralsightCourse testPsCourse = new PluralsightCourse("1","Title","01:40:00","/url-1",false);
        courseStorageService.storePluralsightCourses(List.of(testPsCourse)); //convert from PsCourse to Course class

        // My expected value returned:
        Course expected = new Course("1","Title",100,"https://app.pluralsight.com/url-1");

        //check:
        assertEquals(List.of(expected), repos.getAllCourses());
    }

    static class InMemoryCourseRepository implements CourseRepository {

        private final List<Course> courses = new ArrayList<>();

        @Override
        public void saveCourse(Course course) {
            courses.add(course);
        }

        @Override
        public List<Course> getAllCourses() {
            return courses;
        }

    }
}