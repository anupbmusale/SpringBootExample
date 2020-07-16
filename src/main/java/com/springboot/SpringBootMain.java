package com.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springboot.repository.AuthorRepository;
import com.springboot.repository.BookRepository;

import java.math.BigDecimal;

import com.springboot.entity.Author;
import com.springboot.entity.Book;

@SpringBootApplication
public class SpringBootMain {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMain.class, args);
	}
	
	@Bean
    CommandLineRunner initDatabase(AuthorRepository repository, BookRepository bookRepository) {
		System.out.println("******* Init DB *************");
        return args -> {
        	repository.deleteAllInBatch();
        	bookRepository.deleteAllInBatch();
        	Book b1 = new Book("A Guide to the Bodhisattva Way of Life", "Santideva", new BigDecimal("15.41"));
        	Book b2 = new Book("The Life-Changing Magic of Tidying Up", "Marie Kondo", new BigDecimal("9.69"));
        	Author auth1 = new Author("Sweetu", "1111");
        	Author auth2 = new Author("Trupty", "2222");
        	auth1.setBook(b1);
        	auth2.setBook(b2);
        	
/*        	b1.setAuthObj(auth1);
        	b2.setAuthObj(auth2);*/
        	
            repository.save(auth1);
            repository.save(auth2);
            /*repository.save(new Book("Refactoring: Improving the Design of Existing Code", "Martin Fowler", new BigDecimal("47.99"), new Author(new Long(12), "Anup", "3333")));*/
            
        };
    }
}
