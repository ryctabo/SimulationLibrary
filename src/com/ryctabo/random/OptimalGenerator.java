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
 * Esta interfaz te da la estructura básica para poder optimizar los parametros 
 * necesarios para la generación de numeros aleatorios por medio de diferentes
 * metodos existentes.
 * 
 * @author Gustavo Pacheco Gómez
 * @version 1.0
 */
public interface OptimalGenerator {
    
    /**
     * Este metodo es el encargado de decir si un generador es optimo o no.
     * 
     * @return true, si el generador es optimo.
     */
    boolean isOptimum();
    
    /**
     * Este metodo es el encargado de seleccionar cada una de las sugerencias 
     * que deben tener los parametros para que el generador de numeros 
     * aleatorios tenga un estado optimo y pueda alcanzar su periodo maximo.
     * 
     * @return una cadena en formato HTML que dice todas las sugerencias
     */
    String getSuggestions();
    
}
