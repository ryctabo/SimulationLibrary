/*
 *                    GNU GENERAL PUBLIC LICENSE
 *                       Version 2, June 1991
 *
 * Copyright (C) 1989, 1991 Free Software Foundation, Inc., <http://fsf.org/>
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA
 * Everyone is permitted to copy and distribute verbatim copies
 * of this license document, but changing it is not allowed.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
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
