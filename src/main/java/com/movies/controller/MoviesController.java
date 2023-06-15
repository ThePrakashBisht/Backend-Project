package com.movies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movies.model.Movies;
import com.movies.repository.MovieRepository;

@RestController
@RequestMapping("/api/v1")
public class MoviesController {
	
	@Autowired
	MovieRepository repo;
	
	
	@GetMapping("/longest-duration-movies")
	public List<Movies> longest10() {
		return repo.findLogestTen();
	}
	
	@PostMapping("/new-movie")
	public String save(@RequestBody Movies movie) {
		
		Movies m = new Movies();
		
		m.setTconst(movie.getTconst());
		m.setTitletype(movie.getTitletype());
		m.setPrimarytitle(movie.getPrimarytitle());
		m.setRuntimeminutes(movie.getRuntimeminutes());
		m.setGenres(movie.getGenres());
		
		 repo.save(m);
		 return "success";
	}
	
	
	@GetMapping("/top-rated-movies")
	public List<Object> topRatedMovies() {
		return repo.topRatedMovies();
	}
	
	@GetMapping("/genre-movies-with-subtotals")
	public List<Object> moviesWithSubtotals() {
		List<Object> li = repo.moviesWithSubtotals();
		li.addAll(repo.countSubtotals());
		return li;
	}
	
	@PostMapping("/update-runtime-minutes")
	public String updateRuntimeMinutes() {
		repo.updateRuntimeMinutes();
		return "updated";
	}
	
	
}
