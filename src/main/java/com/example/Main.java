package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Runs multiple filtering and analysis functions on data file of movies released from 1910-2018.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();
        AmericanMovies movie = new AmericanMovies();
        try {
            File file = new File("src/main/resources/movies.json");
            movie = gson.fromJson(new FileReader(file), AmericanMovies.class);
        } catch (Exception e) {
            e.getStackTrace();
        }
        movie.countByGenre("Comedy");
        movie.countMoviesReleasedBetween(2017, 2018);
        movie.findMoviesAtGivenYear(2000);
        movie.findMoviesGivenActor("Emma Stone");
        movie.findActorWithMostFilms();
        movie.findCostars("Brad Pitt");
        movie.findYearsActive("Brad Pitt");
        movie.findMostPopularGenre();
    }
}