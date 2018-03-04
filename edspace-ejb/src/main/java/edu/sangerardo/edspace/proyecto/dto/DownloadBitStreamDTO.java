/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sangerardo.edspace.proyecto.dto;

/**
 *
 * @author jorgemalla
 */
public class DownloadBitStreamDTO extends ResourceSolrDTO {

    private BitStreamDTO bitStreamDTO;

    public DownloadBitStreamDTO() {
    }

    public BitStreamDTO getBitStreamDTO() {
        return bitStreamDTO;
    }

    public void setBitStreamDTO(BitStreamDTO bitStreamDTO) {
        this.bitStreamDTO = bitStreamDTO;
    }

}
