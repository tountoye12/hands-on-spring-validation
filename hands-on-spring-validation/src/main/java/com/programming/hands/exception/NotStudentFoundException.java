package com.programming.hands.exception;
public class NotStudentFoundException extends Exception{
    private String s;
    public  NotStudentFoundException(String s){
        super(s);
    }

}
