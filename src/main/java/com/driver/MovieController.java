package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class MovieController {

    @Autowired
    MovieService movieService;
     @PostMapping("/movies/add-movie")
    public ResponseEntity addMovie(@RequestBody(required = true) Movie m){
        movieService.addMovie(m);
        return new ResponseEntity<>("New movie added success" , HttpStatus.CREATED);
    }

    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name){
        Movie movie = movieService.findMovieByName(name);

        return new ResponseEntity<>(movie , HttpStatus.CREATED);
    }

    @GetMapping("/movies/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){

        List<String> list =  movieService.findAllMovies();

        return new ResponseEntity<>(list , HttpStatus.CREATED);

    }

    @PostMapping("/movies/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director d){
       // System.out.println("mcontorllt  " + d.getName() + d.getNumberOfMovies()  + d.getImdbRating()) ;
        movieService.addDirector(d);

        return new ResponseEntity<>("New Director Added success" , HttpStatus.CREATED);
    }

    @PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam String mName , @RequestParam String dName){
         movieService.addDirectorMoviePair(mName , dName);
         return new ResponseEntity<>("New pair added" , HttpStatus.CREATED);
    }

    @GetMapping("/movies/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String director){

         List<String> list =  movieService.getMovieNameByDname(director);
         return new ResponseEntity<>(list , HttpStatus.CREATED);
    }

    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name){
         Director d = movieService.getDirectorByName(name);
        System.out.println("in controller " + d.toString());
         return new ResponseEntity<Director>(d , HttpStatus.CREATED);
    }


}
