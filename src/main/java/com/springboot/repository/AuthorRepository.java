package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}