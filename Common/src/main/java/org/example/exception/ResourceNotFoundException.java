package org.example.exception;

public class ResourceNotFoundException extends RuntimeException {
    private String ErrorCode;

    public ResourceNotFoundException(String errorCode) {
        ErrorCode = errorCode;
    }

    public ResourceNotFoundException(String message, String errorCode) {
        super(message);
        ErrorCode = errorCode;
    }

    public ResourceNotFoundException(String message, Throwable cause, String errorCode) {
        super(message, cause);
        ErrorCode = errorCode;
    }

    public ResourceNotFoundException(Throwable cause, String errorCode) {
        super(cause);
        ErrorCode = errorCode;
    }

    public ResourceNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String errorCode) {
        super(message, cause, enableSuppression, writableStackTrace);
        ErrorCode = errorCode;
    }

    @Override
    public String toString() {
        return "ResourceNotFoundException{" +
                "ErrorCode='" + ErrorCode + '\'' +
                '}';
    }

    public String getErrorCode() {
        return ErrorCode;
    }

    public void setErrorCode(String errorCode) {
        ErrorCode = errorCode;
    }


}
