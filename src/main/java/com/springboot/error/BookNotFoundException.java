package com.springboot.error;

public class BookNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 6770834811590503771L;
	public BookNotFoundException(Long id) {
        super("Book id not found : " + id);
    }

}
