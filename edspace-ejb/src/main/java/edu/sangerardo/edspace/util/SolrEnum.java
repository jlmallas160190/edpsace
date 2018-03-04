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
public enum SolrEnum {
    URL("URL"),
    ROWS("ROWS"),
    INDENT("INDENT"),
    EXPLAIN_OTHER("EXPLAIN_OTHER"),
    FACET("FACET"),
    FL("FL"),
    Q("Q"),
    FACET_FIELD("FACET_FIELD"),
    HL_FL("HL.FL"),
    WT("WT"),
    RESPONSE("response"),
    DATA("docs"),
    QT("QT"),
    TIME("time"),
    ID("id"),
    REFERRER("referrer"),
    DNS("dns"),
    IP("ip"),
    USER_AGENT("userAgent"),
    OWNING_ITEM("owningItem"),
    OWNING_COLL("owningColl"),
    OWNING_COMM("owningComm"),
    EPERSON_ID("epersonid"),
    START("START");
    private String tipo;

    private SolrEnum(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
