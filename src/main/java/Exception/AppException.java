/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exception;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Javier Morcillo
 */
public class AppException extends Exception{
        private static final int COMMAND = 0;
    private static final int NUM_ARGS = 1;
    private static final int PROPIETARIO_EXISTS = 2;
    private static final int PROPIETARIO_NO_EXISTS = 3;
    private static final int FORMATO_FECHA = 4;
    private static final int MASCOTA_NO_EXISTS = 5;
    private static final int NO_PROPIETARIOS = 6;
    private static final int EXISTE_TAREA=7;
    
    private final List<String> mensajes = Arrays.asList(
            "Error 01: Comando incorrecto.",
            "Error 02: Número de argumentos incorrecto.",
            "Error 03: El propietario indicado ya existe.",
            "Error 04: El propietario indicado no está registrado.",
            "Error 05: La fecha debe estar en formato dd/mm/yyyy",
            "Error 06: La mascota no está registrada.",
            "Error 07: No hay propietarios registrados.",
            "Error 08: El usuario tiene una o mas tareas."
    );

    private final int code;
    
    public AppException(int code) {
        this.code = code;
    }
    
    @Override
    public String getMessage() {
        return mensajes.get(code);
    }
}

