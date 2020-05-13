package com.springboot.error;

import java.util.Set;

public class BookUnSupportedFieldPatchException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3283642443607441982L;

	public BookUnSupportedFieldPatchException(Set<String> keys) {
        super("Field " + keys.toString() + " update is not allow.");
    }

}