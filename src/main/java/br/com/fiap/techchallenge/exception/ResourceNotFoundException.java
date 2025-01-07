package br.com.fiap.TechChallenge.exception;

public class ResourceNotFoundException extends RuntimeException  {

    public ResourceNotFoundException(String message) {
        super(message);
    }

}
