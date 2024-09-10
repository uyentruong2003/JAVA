package com.pluralsight.courseinfo.cli;


/*
slf4j: a dependency that helps with console logging during coding. Add this dependency to the pom file
 then import it to the file using.
*/

import com.pluralsight.courseinfo.cli.service.CourseRetrieverService;
import com.pluralsight.courseinfo.cli.service.CourseStorageService;
import com.pluralsight.courseinfo.cli.service.PluralsightCourse;
import com.pluralsight.courseinfo.repository.CourseRepository;

import java.util.List;

import static java.util.function.Predicate.not;

public class CourseRetriever {
//    private static final Logger LOG = LoggerFactory.getLogger(CourseRetriever.class);

    public static void main(String... args){
//        LOG.info("Course Retriever started");
        System.out.println("Course Retriever started.");
        if(args.length == 0){
//          LOG.warn("Please provide an author name as first argument");
            System.out.println("Please provide an author name as first argument");
            return;
        }

        //exception handling
        try {
            retrieveCourses(args[0]);
        } catch (Exception e) {
//            LOG.error("Unexpected error", e);
            System.out.println("Unexpected error");
            e.printStackTrace();
        }
    }

    // method that use the courseRetrieverService & make the Http GET API call
    private static void retrieveCourses(String authorId) {
//        LOG.info("Retrieve courses for author '{}'",authorId);
        System.out.println("Retrieve courses for author " + authorId);
        CourseRetrieverService courseRetrieverService = new CourseRetrieverService();
        CourseRepository courseRepository = CourseRepository.openCourseRepository("./courses.db");
        CourseStorageService courseStorageService = new CourseStorageService(courseRepository);


        // print out a list of PluralsightCourse from the GET API call
        List<PluralsightCourse> coursesToStore = courseRetrieverService.getCoursesFor(authorId)
                        .stream()
//                        .filter(course -> !course.isRetired())//lambda expression: only return the courses that isRetired = false
                        .filter(not(PluralsightCourse::isRetired))//method reference: achieve the same purpose
                        .toList();
        System.out.println("Retrieve the following courses " + coursesToStore);
        courseStorageService.storePluralsightCourses(coursesToStore);
        System.out.println("Courses successfully stored");
    }
}
