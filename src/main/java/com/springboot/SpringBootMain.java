package com.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springboot.repository.BookRepository;

import java.math.BigDecimal;
import com.springboot.entity.Book;

@SpringBootApplication
public class SpringBootMain {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMain.class, args);
	}
	
	@Bean
    CommandLineRunner initDatabase(BookRepository repository) {
        return args -> {
            repository.save(new Book("A Guide to the Bodhisattva Way of Life", "Santideva", new BigDecimal("15.41")));
            repository.save(new Book("The Life-Changing Magic of Tidying Up", "Marie Kondo", new BigDecimal("9.69")));
            repository.save(new Book("Refactoring: Improving the Design of Existing Code", "Martin Fowler", new BigDecimal("47.99")));
        };
    }
}
