package com.pluralsight.courseinfo.cli.service;

import com.pluralsight.courseinfo.domain.Course;
import com.pluralsight.courseinfo.repository.CourseRepository;

import java.util.List;

public class CourseStorageService {
    private static final String PS_BASE_URL = "https://app.pluralsight.com";
    private final CourseRepository courseRepository;

    //constructor
    public CourseStorageService(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    // CourseRetrieverService -> get PS courses from PS website & stored as PluralsightCourse
    // CourseStorageService -> convert the PS courses to the Course to be stored to the DB through CourseRepository

    public void storePluralsightCourses(List<PluralsightCourse> psCourses){
        for (PluralsightCourse ps: psCourses){
            Course course = new Course(ps.id(),ps.title(),ps.durationInMinutes(),PS_BASE_URL + ps.contentUrl());
            courseRepository.saveCourse(course);
        }
    }
}
