package com.pluralsight.courseinfo.cli;


/*
slf4j: a dependency that helps with console logging during coding. Add this dependency to the pom file
 then import it to the file using.
*/

import com.pluralsight.courseinfo.cli.service.CourseRetrieverService;
import com.pluralsight.courseinfo.cli.service.PluralsightCourse;

import java.util.List;

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

        List<PluralsightCourse> coursesToStore = courseRetrieverService.getCoursesFor(authorId)
                        .stream()
                        .filter(course -> !course.isRetired()) //only return the courses that isRetired = false
                        .toList();
        System.out.println("Retrieve the following courses " + coursesToStore);
    }
}
