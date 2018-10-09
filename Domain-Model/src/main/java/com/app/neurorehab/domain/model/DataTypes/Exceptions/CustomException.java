package com.app.neurorehab.domain.model.DataTypes.Exceptions;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException{

    private HttpStatus code;
    private String message;

    public CustomException(final HttpStatus code, final String message){

        this.code = code;
        this.message = message;
    }


    /**
     * Gets message.
     *
     * @return Value of message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets new code.
     *
     * @param code
     *         New value of code.
     */
    public void setCode(HttpStatus code) {
        this.code = code;
    }

    /**
     * Sets new message.
     *
     * @param message
     *         New value of message.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets code.
     *
     * @return Value of code.
     */
    public HttpStatus getCode() {
        return code;
    }
}
