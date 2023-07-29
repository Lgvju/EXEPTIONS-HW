package ru.netology.javaqa63;

public class AlreadyExistsException extends RuntimeException{
    public AlreadyExistsException(String s) {
        super(s);
    }
}
