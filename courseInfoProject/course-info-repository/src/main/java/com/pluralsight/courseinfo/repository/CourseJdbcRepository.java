package com.pluralsight.courseinfo.repository;

import com.pluralsight.courseinfo.domain.Course;
import org.h2.jdbcx.JdbcDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//implementation of the CourseRepository interface
public class CourseJdbcRepository implements CourseRepository {

    //%s: wildcard to pass the database file later.
    private static final String H2_DATABASE_URL =
            "jdbc:h2:file:%s;AUTO_SERVER=TRUE;INIT=RUNSCRIPT FROM './db_init.sql'";

    private static final String INSERT_COURSE = """
            MERGE INTO Courses (id, name, length, url)
            VALUES (?,?,?,?)
            """; //prevent SQL injection attack

    private final DataSource dataSource;

    public CourseJdbcRepository(String databaseFile){
        JdbcDataSource jdbcDataSource = new JdbcDataSource();
        jdbcDataSource.setURL(H2_DATABASE_URL.formatted(databaseFile));
        this.dataSource = jdbcDataSource;
    }

    //save PS course to the DB
    @Override
    public void saveCourse(Course course) {
        try (Connection connection = dataSource.getConnection()){ //auto close the connection
            PreparedStatement statement = connection.prepareStatement(INSERT_COURSE);
            statement.setString(1, course.id());
            statement.setString(2, course.name());
            statement.setLong(3, course.length());
            statement.setString(4, course.url());
            statement.execute();
        } catch (SQLException e) {
            throw new RepositoryException("Failed to save " + course, e); //create a new Exception class
        }
    }

    //get courses from the database
    @Override
    public List<Course> getAllCourses() {
        try (Connection connection = dataSource.getConnection()) {
            //statement
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM COURSES");
            //loop through and append all courses to the list
            List<Course> courses = new ArrayList<>();
            while (resultSet.next()){
                Course course = new Course(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getLong(3),
                        resultSet.getString(4));
                courses.add(course);
            }
            return Collections.unmodifiableList(courses);
        } catch (SQLException e){
            throw new RepositoryException("Failed to retrieve the courses",e);
        }
    }
}
