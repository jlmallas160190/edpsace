/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sangerardo.edspace.proyecto.dto;

import edu.sangerardo.edspace.proyecto.modelo.Bitstream;
import java.io.Serializable;

/**
 *
 * @author jorgemalla
 */
public class BitStreamDTO implements Serializable {

    private Bitstream bitstream;
    private String title;

    public BitStreamDTO() {

    }

    public Bitstream getBitstream() {
        return bitstream;
    }

    public void setBitstream(Bitstream bitstream) {
        this.bitstream = bitstream;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
