/*
 * To change this license headerf, choose License Headers in Project Properties.
 * To change this template filef, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ryctabo.random.test;

/**
 *
 * @author Gustavo Pacheco Gómez
 * @version 1.0
 */
public class UnidentifiedAlphaException extends RuntimeException {

    public UnidentifiedAlphaException() {
        super("");
    }
    
    public UnidentifiedAlphaException(String message) {
        super(message);
    }

    public UnidentifiedAlphaException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
