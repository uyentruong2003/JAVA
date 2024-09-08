package com.pluralsight.courseinfo.cli.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.Duration;
import java.time.LocalTime;

// Jackson dependency is added to parse the Http response json file into a java object
@JsonIgnoreProperties(ignoreUnknown = true) //annotation allows jackson to ignore unneeded fields of the JSON file
public record PluralsightCourse(String id,
                                String title,
                                String duration,
                                String contentUrl,
                                boolean isRetired) {

    //method to get rounded-to-min duration:
    public long durationInMinutes(){
        return Duration.between(
                LocalTime.MIN,
                LocalTime.parse(duration()) //get the duration from 00:00 (LocalTime.MIN) to the duration of the vid then convert toMinutes only
        ).toMinutes();
    }
    //duration = "00:05:37"
}
