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
public enum AcctionEnum {
    READ("0"),
    WRITE("1"),
    DELETE("2"),
    ADD("3"),
    REMOVE("4");
    private String tipo;

    private AcctionEnum(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
