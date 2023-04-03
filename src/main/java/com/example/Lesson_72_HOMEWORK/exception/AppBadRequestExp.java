package com.example.Lesson_72_HOMEWORK.exception;

public class AppBadRequestExp extends RuntimeException{
    public AppBadRequestExp(String message) {
        super(message);
    }
}
