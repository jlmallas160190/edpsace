/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sangerardo.edspace.controller;

import edu.sangerardo.edspace.master.modelo.Menu;
import edu.sangerardo.edspace.proyecto.service.MenuService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
/**
 *
 * @author jorgemalla
 */
@Named
@ViewScoped
public class MenuController implements Serializable {

    @EJB
    private MenuService menuService;

    private List<Menu> menus;

    public MenuController() {
    }

    @PostConstruct
    public void init() {
        this.menus = new ArrayList();
    }

    public List<Menu> getMenus() {
        if (this.menus.isEmpty()) {
            this.menus = this.menuService.findAll();
        }
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

}
