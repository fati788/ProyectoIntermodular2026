package com.jaroso.proyectointermodular2026.entities;

public enum EstadoSensor {
    ACTIVO,          // funcionando y enviando datos
    INACTIVO,        // existe pero no envía
    DESCONECTADO,    // no hay comunicación
    ERROR,           // fallo de hardware o lectura
    MANTENIMIENTO,
    ARRANCADO,
    PARADO
}