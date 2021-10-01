package com.example;


import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Tests each of the filtering and analysis functions to handle data set.
 * Tests invalid input, valid input, and for null pointer exceptions.
 */
public class JSONTest {
    private Gson gson;
    private AmericanMovies movies;

    /**
     * Deserializes JSON file into AmericanMovies object
     */
    @Before
    public void setUp() {
        gson = new Gson();
        movies = new AmericanMovies();
        try {
            File file = new File("src/main/resources/testSubset.json");
            movies = gson.fromJson(new FileReader(file), AmericanMovies.class);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindMoviesGivenYearInvalid() {
        List<String> test = movies.findMoviesAtGivenYear(1900);
        assertEquals(NullPointerException.class, movies.findMoviesAtGivenYear(1900));
    }

    @Test
    public void testTitlesGivenActorsInvalid() {
        List<String> test = movies.findMoviesGivenActor("Chocolate Milk");
        List<String> correct = new ArrayList<>();
        assertEquals(correct, test);
    }

    @Test
    public void testFindYearsActiveInvalid() {
        List<Integer> test = movies.findYearsActive("Chocolate Milk");
        List<Integer> correct = new ArrayList<>();
        assertEquals(correct, test);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCountMoviesReleasedBetweenInvalid() {
        assertEquals(IllegalArgumentException.class, movies.countMoviesReleasedBetween(1900, 2050));
    }

    @Test
    public void testFindCostarsInvalid() {
        List<String> test = movies.findCostars("Chocolate Milk");
        List<String> correct = new ArrayList<>();
        assertEquals(correct, test);
    }

    @Test(expected = NullPointerException.class)
    public void testFindMoviesGivenActorsNull() {
        assertEquals(NullPointerException.class, movies.findMoviesGivenActor(null));
    }

    @Test(expected = NullPointerException.class)
    public void testFindYearsActiveNull() {
        assertEquals(NullPointerException.class, movies.findYearsActive(null));
    }

    @Test(expected = NullPointerException.class)
    public void testFindCostarsNull() {
        assertEquals(NullPointerException.class, movies.findCostars(null));
    }

    @Test
    public void testFindMoviesGivenYearValid() {
        List<String> test = movies.findMoviesAtGivenYear(2016);
        List<String> correct = new ArrayList<>();
        correct.add("Zootopia");
        correct.add("Alice Through the Looking Glass");
        assertEquals(correct, test);
    }

    @Test
    public void testFindMoviesGivenActorsValid() {
        List<String> test = movies.findMoviesGivenActor("Anne Hathaway");
        List<String> correct = new ArrayList<>();
        correct.add("The Princess Diaries");
        correct.add("The Devil Wears Prada");
        correct.add("Alice Through the Looking Glass");
        assertEquals(correct, test);
    }

    @Test
    public void testFindCostarsValid() {
        List<String> test = movies.findCostars("Zendaya");
        List<String> correct = new ArrayList<>();
        correct.add("Tom Holland");
        correct.add("Michael Keaton");
        correct.add("Donald Glover");
        assertEquals(correct, test);
    }

    @Test
    public void testMostPopularGenreValid() {
        String max = movies.findMostPopularGenre();
        assertEquals(max,"Comedy");
    }

    @Test
    public void testFindYearsActiveValid() {
        List<Integer> test = movies.findYearsActive("Anne Hathaway");
        List<Integer> correct = new ArrayList<>();
        correct.add(2001);
        correct.add(2006);
        correct.add(2016);
        assertEquals(correct, test);
    }

    @Test
    public void testCountByGenreValid() {
        int count = movies.countByGenre("Comedy");
        assertEquals(count, 3);
    }

    @Test
    public void testCountMoviesReleasedBetweenValid() {
        int count = movies.countMoviesReleasedBetween(2001, 2017);
        assertEquals(count, 5);
    }

    @Test
    public void testFindActorsWithMostFilmsValid() {
        String test = movies.findActorWithMostFilms();
        assertEquals(test, "Anne Hathaway");
    }

}