package com.driver;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieReposiotry {
    HashMap<String , Movie> listOfMovies  = new HashMap<>();
    HashMap<String , Director> listOfDirectors = new HashMap<>();
    HashMap<String , List<String>> directorMoviePair = new HashMap<>();

    public void addMovietoDB(Movie m){
        listOfMovies.put(m.getName() , m);
    }

    public Movie findMovieByName(String s){
        Movie m;
        m = listOfMovies.get(s);
        return m;
    }

    public List<String> getAllMoviesNameFromDB(){
        List<String> list = new ArrayList<>();

        for(Movie m: listOfMovies.values()){
            list.add(m.getName());
        }

        return list;
    }

    public void addDirectorToDB(Director d){
        System.out.println(d.getName());
        listOfDirectors.put(d.getName() , d);
        System.out.println(listOfDirectors);
    }

    public void saveMovieDirectorPair(String movie , String director){

       // System.out.println("saveMovieDirectorPair" + movie + director);
      //  System.out.println(listOfMovies.containsKey(movie) && listOfDirectors.containsKey(director));

            if(listOfMovies.containsKey(movie) && listOfDirectors.containsKey(director)){
                List<String> current = new ArrayList<>();

                if(directorMoviePair.containsKey(director)){
                    System.out.println("---------" + directorMoviePair.get(director));
                    current = directorMoviePair.get(director);
                }

               // System.out.println("saveMovieDirectorPair " + current);

                current.add(movie);


                directorMoviePair.put(director , current);
               // System.out.println(directorMoviePair.toString());


            }
    }

    public List<String> getMovieNameByDname(String d){
        List<String> curr = new ArrayList<>();

        if(directorMoviePair.containsKey(d))
             curr = directorMoviePair.get(d);

       // System.out.println(" in getMovieNameByDname  " +curr.toString());

        return curr;

    }

    public Director getDirectorByName(String director){
        System.out.println(listOfDirectors.get(director).toString() + "-----------");
        return listOfDirectors.get(director);

    }



}
