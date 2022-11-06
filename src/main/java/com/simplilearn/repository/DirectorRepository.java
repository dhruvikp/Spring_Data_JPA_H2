package com.simplilearn.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.simplilearn.entity.Director;

public interface DirectorRepository extends CrudRepository<Director, Integer> {

	public Optional<Director> findByDirectorName(String directorName);
}
