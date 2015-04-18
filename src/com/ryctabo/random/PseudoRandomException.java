/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ryctabo.random;

/**
 * 
 * @author Gustavo Pacheco Gómez
 * @version 1.0
 */
public class PseudoRandomException extends RuntimeException {

    public enum ErrorTypes {
        GENERAL, LIMIT_EXCEEDED, INDEX_OUT_OF_RANGE
    }
    
    private ErrorTypes type;
    
    public PseudoRandomException(String message) {
        super(message);
        this.type = ErrorTypes.GENERAL;
    }

    public PseudoRandomException(ErrorTypes type, String message) {
        super(message);
        this.type = type;
    }
    
    public PseudoRandomException(int type, String message) {
        super(message);
        if (type >= 0 && type < ErrorTypes.values().length)
            this.type = ErrorTypes.values()[type];
        else
            this.type = ErrorTypes.GENERAL;
    }
    
}
