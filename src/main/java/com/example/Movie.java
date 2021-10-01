package com.example;

/**
 * Stores title, year, cast, genre of movie from JSON file.
 */
public class Movie {
    private String title;
    private int year;
    private String[] cast;
    private String[] genres;

    /**
     * Constructs a new movie object
     */
    public Movie() { }

    public String getTitle(){ return title; }
    public int getYear() { return year;}
    public String[] getCast() { return cast; }
    public String[] getGenres() { return genres; }
}
