package com.pluralsight.courseinfo.domain;

public record Course(String id, String name, long length, String url) {

    public Course{
       filled(id);
       filled(name);
       filled(url);
    }

    //throw exception if the string input is null/blank
    private static  void filled (String s){
        if (s == null || s.isBlank()){
            throw new IllegalArgumentException("No value present!");
        }
    }
}
