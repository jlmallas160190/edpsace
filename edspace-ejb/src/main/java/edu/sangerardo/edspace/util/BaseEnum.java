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
public enum BaseEnum {
    PIE_CHART("pie"),
    BAR_CHART("bar");
    private String tipo;

    private BaseEnum(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
