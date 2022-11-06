package com.simplilearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.simplilearn.entity.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {

	public Movie findById(int id);

	public Movie findByName(String name);

	@Query("select m from Movie m left join Director d on m.director.id = d.id where d.directorName = :directorName")
	public List<Movie> findMovieByDirectorName(@Param("directorName") String directorName);
}
