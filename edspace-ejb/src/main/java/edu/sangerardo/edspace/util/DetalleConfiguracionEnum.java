/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sangerardo.edspace.util;

/**
 *
 * @author jorgemalla
 */
public enum DetalleConfiguracionEnum {
    IP("IP"),
    CHARSET("CHARSET"),
    URL_STATISTICS("URL_STATISTICS"),
    RANGE_NUMBER_MONTH("RANGE_NUMBER_MONTH"),
    RANGE_END_MONTH("RANGE_END_MONTH"),
    DATE_FORMAT1("DATE_FORMAT1"),
    DATE_FORMAT2("DATE_FORMAT2"),
    DATE_FORMAT3("DATE_FORMAT3"),
    PUERTO("PUERTO");
    private String tipo;

    private DetalleConfiguracionEnum(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
