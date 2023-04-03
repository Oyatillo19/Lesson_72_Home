package com.example.Lesson_72_HOMEWORK.controller;

import com.example.Lesson_72_HOMEWORK.exception.AppBadRequestExp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class AdviceController {
    @ExceptionHandler({AppBadRequestExp.class})
    public ResponseEntity<String> handleException(RuntimeException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
