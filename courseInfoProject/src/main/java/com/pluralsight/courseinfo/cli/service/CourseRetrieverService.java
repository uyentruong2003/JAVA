package com.pluralsight.courseinfo.cli.service;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;


public class CourseRetrieverService {
    // %s: wildcard as a placeholder to pass in the author name later
    private static final String PS_URI = "https://app.pluralsight.com/profile/data/author/%s/all-content";
    private static final HttpClient CLIENT = HttpClient.newHttpClient();
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    // GET API call:
    public List<PluralsightCourse> getCoursesFor (String authorId) {
        // build Http request (syntax can be found at javadoc 17):
        HttpRequest request = HttpRequest
                .newBuilder(URI.create(PS_URI.formatted(authorId)))
                .GET()
                .build();
        try {
            //send the request; http response's body convert to String
            HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
            // use switch clause to handle the cases where the API call fails.
            return switch(response.statusCode()){
                case 200 -> {
                    // this returnType var hold the return type that the response body will be stored as after parsing
                    JavaType returnType = OBJECT_MAPPER.getTypeFactory()
                            .constructCollectionType(List.class, PluralsightCourse.class);
                    //yield: works like a return clause, but for a switch statement
                    yield OBJECT_MAPPER.readValue(response.body(),returnType); //pass the response body & return type in
                }
                case 404 -> List.of();
                default -> throw new RuntimeException("Pluralsight API call failed with status code " + response.statusCode());
            };
        } catch (IOException | InterruptedException e){
            throw new RuntimeException("Could not call Pluralsight API", e);
        }
    }
}
