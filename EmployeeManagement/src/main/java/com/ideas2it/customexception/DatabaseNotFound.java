package com.ideas2it.customexception;

import java.lang.Exception;
/**
 * custom exception
 *
 * @version 1.0 01-09-2022
 *
 * @author Rohit A P
 */
@SuppressWarnings("serial")
public class DatabaseNotFound extends Exception  {
    
    public DatabaseNotFound(String messege) {
        super(messege);
    }
}
