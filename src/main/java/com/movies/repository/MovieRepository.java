package com.movies.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.movies.model.Movies;

import jakarta.transaction.Transactional;

public interface MovieRepository extends CrudRepository<Movies, String>{

	@Query(value = "SELECT * FROM movies order by runtimeMinutes desc limit 10", nativeQuery = true)
    List<Movies> findLogestTen();
	
	
	@Query(value = "SELECT movies.tconst, primarytitle, genres, ratings.averageRating\r\n"
			+ "	FROM movies\r\n"
			+ "	INNER JOIN  ratings\r\n"
			+ "	ON movies.tconst = ratings.tconst\r\n"
			+ "	where averageRating>6.0;", nativeQuery = true)
    List<Object> topRatedMovies();
	
	
	@Query(value = "SELECT  genres, primarytitle, ratings.numVotes\r\n"
			+ "FROM movies\r\n"
			+ "INNER JOIN ratings\r\n"
			+ "ON movies.tconst = ratings.tconst\r\n"
			+ "order by genres", nativeQuery = true)
    List<Object> moviesWithSubtotals();
	
	@Query(value = "SELECT  genres, sum(numVotes) \r\n"
			+ "FROM  movies\r\n"
			+ "INNER JOIN ratings\r\n"
			+ "ON movies.tconst = ratings.tconst\r\n"
			+ "group by genres", nativeQuery = true)
    List<Object> countSubtotals();
	
	
	
	@Modifying
	@Query(value = "UPDATE movies\r\n"
			+ "SET runtimeMinutes = \r\n"
			+ "    CASE\r\n"
			+ "        WHEN genres = 'Documentary' THEN runtimeMinutes + 15\r\n"
			+ "        WHEN genres = 'Animation' THEN runtimeMinutes + 30\r\n"
			+ "        ELSE runtimeMinutes + 45\r\n"
			+ "    END\r\n"
			+ "WHERE genres = 'Documentary' OR genres = 'Animation' OR genres NOT IN ('Animation', 'Documentary')", nativeQuery = true)
	@Transactional
	void updateRuntimeMinutes();
	
	
	
	
	
	
}
