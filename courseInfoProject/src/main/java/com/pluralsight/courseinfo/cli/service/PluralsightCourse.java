package com.pluralsight.courseinfo.cli.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// Jackson dependency is added to parse the Http response json file into a java object
@JsonIgnoreProperties(ignoreUnknown = true) //annotation allows jackson to ignore unneeded fields of the JSON file
public record PluralsightCourse(String id,
                                String title,
                                String duration,
                                String contentUrl,
                                boolean isRetired) {
}
