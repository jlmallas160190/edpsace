/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sangerardo.edspace.proyecto.dto;

import edu.sangerardo.edspace.proyecto.modelo.Item;
import java.io.Serializable;

/**
 *
 * @author jorgemalla
 */
public class ItemDTO implements Serializable {

    private Item item;
    private String title;

    public ItemDTO() {
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
