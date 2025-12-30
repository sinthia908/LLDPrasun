package com.interview.practice.exception;

public class RatingSystemException extends RuntimeException
{
    public RatingSystemException(String message){
        super(message);
    }

    public RatingSystemException(String message,Throwable clause){
        super(message,clause);
    }

}
