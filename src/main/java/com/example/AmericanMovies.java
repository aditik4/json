package com.example;

import java.util.*;

/**
 * Stores a list of movies released from 1910-2018
 */
public class AmericanMovies {
    private List<Movie> movies;
    public List<Movie> getMovies() { return movies; }

    /**
     * Constructs a new AmericanMovies object that stores a list of movies.
     */
    public AmericanMovies() {
        movies = new ArrayList<>();
    }

    /**
     * Obtains a list of movies that were released at given year.
     * @param year the year to search for
     * @return a list of movie titles
     */
    public List<String> findMoviesAtGivenYear(int year)  {
        if(year < 1910 || year > 2018) {
            throw new IllegalArgumentException("invalid input");
        }
        List<String> titlesAtYear = new ArrayList<String>();
        for (Movie m : movies) {
            if (m.getYear() == year) {
                titlesAtYear.add(m.getTitle());
            }
        }
        return titlesAtYear;
    }

    /**
     * Obtains a list of movies that a particular actor has been in.
     * @param name the name of the actor to look for.
     * @return the list of titles the actor has been in.
     */
    public List<String> findMoviesGivenActor(String name) {
        if(name == null || name == "") {
            throw new NullPointerException("Name cannot be null or empty");
        }
        List<String> actors = new ArrayList<String>();
        for (Movie m : movies) {
            for (String actor : m.getCast()) {
                if (actor.equals(name)) {
                    actors.add(m.getTitle());
                }
            }
        }
        return actors;
    }

    /**
     * Obtains a list of costars that have worked with given actor.
     * @param name the name of the actor
     * @return the list of costars
     */
    public List<String> findCostars(String name) {
        if(name == null || name == "") {
            throw new NullPointerException("Name cannot be empty or null");
        }
        List<String> costars = new ArrayList<String>();
        for (Movie m : movies) {
            for (String actor: m.getCast()) {
                if (actor.equals(name)) {
                    for (String star : m.getCast()) {
                        if (!star.equals(name))
                        costars.add(star);
                    }
                }
            }
        }
        return costars;
    }

    /**
     * Given the name of an actor, finds the years they were active.
     * @param name the name of the actor to find
     * @return a list of years the actor appeared in films.
     */
    public List<Integer> findYearsActive(String name) {
        if(name == null || name == "") {
            throw new NullPointerException("Name cannot be empty or null");
        }
        List<Integer> years = new ArrayList<>();
        for (Movie m : movies) {
            for (String actor: m.getCast()) {
                if (actor.equals(name)) {
                    years.add(m.getYear());
                }
            }
        }
        return years;
    }

    /**
     * Calculates the number of movies with given genre.
     * @param genre the genre to count.
     * @return the number movies with genre.
     */
    public int countByGenre(String genre) {
        if (genre == null || genre == "") {
            throw new NullPointerException("Genre cannot be empty or null");
        }
        int count = 0;
        for (Movie m : movies) {
            for (String filmType : m.getGenres()) {
                if (filmType.equals(genre)) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Calculates how many movies were released between two given years.
     * @param firstYear the first year to search between
     * @param secondYear the last year to search within
     * @return the count of movies released during the time period.
     */
    public int countMoviesReleasedBetween(int firstYear, int secondYear) {
        if (firstYear < 1910 || firstYear > 2018 && (secondYear < 1910 || secondYear > 2018)) {
            throw new IllegalArgumentException("invalid input");
        }
        int count = 0;
        for (Movie m : movies) {
            if (m.getYear() >= firstYear && m.getYear() <= secondYear) {
                count++;
            }
        }
        return count;
    }

    /**
     * Finds the most popular genre in data.
     * @return the name of the most popular genre.
     */
    public String findMostPopularGenre() {
        Map<String, Integer> genreMap = new HashMap<String, Integer>();
        String mostPopular = "";
        int max = 0;
        for (Movie m : movies) {
            for (String genre : m.getGenres()) {
                if (genreMap.containsKey(genre)) {
                    genreMap.replace(genre, genreMap.get(genre) + 1);
                } else {
                    genreMap.put(genre, 1);
                }
                if (genreMap.get(genre) > max) {
                    max = genreMap.get(genre);
                    mostPopular = genre;
                }
            }
        }
        return mostPopular;
    }

    /**
     * Finds the actor that has been in the most number of films.
     * @return the name of the actor with the most film titles.
     */
    public String findActorWithMostFilms() {
        Map<String, Integer> actorMap = new HashMap<String, Integer>();
        String mostPopular = "";
        int max = 0;
        for (Movie m : movies) {
            for (String actor : m.getCast()) {
                if (actorMap.containsKey(actor)) {
                    actorMap.replace(actor, actorMap.get(actor) + 1);
                } else {
                    actorMap.put(actor, 1);
                }
                if (actorMap.get(actor) > max) {
                    max = actorMap.get(actor);
                    mostPopular = actor;
                }
            }
        }
        return mostPopular;
    }

}
