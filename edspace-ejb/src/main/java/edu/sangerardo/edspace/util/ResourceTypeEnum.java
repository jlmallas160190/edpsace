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
public enum ResourceTypeEnum {
    BITSTREAM("0"),
    BUNDLE("1"),
    ITEM("2"),
    COLLECTION("3"),
    COMMUNITY("4"),
    SITE("5"),
    GROUP("6"),
    EPERSON("7");
    private String tipo;

    private ResourceTypeEnum(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
