package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.springboot.entity.Author;
import com.springboot.entity.Book;
import com.springboot.error.BookNotFoundException;
import com.springboot.error.BookUnSupportedFieldPatchException;
import com.springboot.repository.AuthorRepository;
import com.springboot.repository.BookRepository;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import java.util.List;
import java.util.Map;

@RestController
@Validated
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

	@Autowired
	private AuthorRepository repository;

	// Find
	@GetMapping("/authors")
	List<Author> findAll() {
		return repository.findAll();
	}
	
	@GetMapping("/author/{id}")
	Author findOne(@PathVariable Long id) {
		System.out.println("**************Get book " + id + "********" + repository.getOne(id));
		return repository.findById(id).get();
		/*throw new BookNotFoundException(id);*/
	}

/*	// Save
	@PostMapping("/books")
	Book newBook(@Valid @RequestBody Book newBook) {
		return repository.save(newBook);
	}

	// Find
	@GetMapping("/books/{id}")
	Book findOne(@PathVariable @Min(1) Long id) {
		throw new BookNotFoundException(id);
	}

	// Save or update
	@PutMapping("/books/{id}")
	Book saveOrUpdate(@RequestBody Book newBook, @PathVariable Long id) {

		return repository.findById(id).map(x -> {
			x.setName(newBook.getName());
			x.setAuthor(newBook.getAuthor());
			x.setPrice(newBook.getPrice());
			return repository.save(x);
		}).orElseGet(() -> {
			newBook.setId(id);
			return repository.save(newBook);
		});
	}

	// Update author only
	@PatchMapping("/books/{id}")
	Book patch(@RequestBody Map<String, String> update, @PathVariable Long id) {
		return repository.findById(id).map(x -> {
			String author = update.get("author");
			if (!StringUtils.isEmpty(author)) {
				x.setAuthor(author);
				return repository.save(x);
			} else {
				throw new BookUnSupportedFieldPatchException(update.keySet());
			}
		}).orElseGet(() -> {
			throw new BookNotFoundException(id);
		});
	}

	@DeleteMapping("/books/{id}")
	void deleteBook(@PathVariable Long id) {
		repository.deleteById(id);
	}*/
}