package org.example.exception;

public class CommonFuntion {


    public String Common(String a)
    {
        throw new ResourceNotFoundException(a);
    }
}
