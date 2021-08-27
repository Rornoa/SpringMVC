package com.example.springmvc.exception_handlers;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(long id){
        super("Could not find user "+id);
    }
}
