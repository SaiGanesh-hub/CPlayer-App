package com.stackroute.UserAuthentication.exception;


public class UserAlreadyExistsException  extends RuntimeException {
    private String msg;


    public UserAlreadyExistsException() {
    }

    public UserAlreadyExistsException(String msg, String message) {
        super(message);
        this.msg = msg;
    }
}
