package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MovieService {
    @Autowired
    MovieReposiotry movieReposiotry;

    public void addMovie(Movie m){
        movieReposiotry.addMovietoDB(m);
    }

    public Movie findMovieByName(String name){
      return  movieReposiotry.findMovieByName(name);
    }

    public List<String> findAllMovies(){
        return movieReposiotry.getAllMoviesNameFromDB();
    }

    public void addDirector(Director director){
        movieReposiotry.addDirectorToDB(director);
    }

    public  void addDirectorMoviePair(String m , String d){
        movieReposiotry.saveMovieDirectorPair(m , d);
    }

    public List<String> getMovieNameByDname(String d){
        return  movieReposiotry.getMovieNameByDname(d);
    }

    public Director getDirectorByName(String d){
        return movieReposiotry.getDirectorByName(d);
    }


    public void deleteDirector(String director){
        movieReposiotry.deleteDirector(director);
    }

    public void deleteAllDirectors(){
        movieReposiotry.deleteAllDirector();
    }

}
