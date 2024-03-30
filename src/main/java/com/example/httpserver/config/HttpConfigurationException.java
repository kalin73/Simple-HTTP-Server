package com.example.httpserver.config;

public class HttpConfigurationException extends RuntimeException {
    public HttpConfigurationException() {
        super();
    }

    public HttpConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }

    public HttpConfigurationException(Throwable cause) {
        super(cause);
    }

    protected HttpConfigurationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public HttpConfigurationException(String message) {
        super(message);
    }
}
