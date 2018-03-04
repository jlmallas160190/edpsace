/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sangerardo.edspace.database;

import edu.sangerardo.edspace.master.modelo.Configuracion;
import edu.sangerardo.edspace.master.modelo.DetalleConfiguracion;
import edu.sangerardo.edspace.master.modelo.Menu;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jorgemalla
 */
@Stateful
public class SetupService implements Serializable {
    
    @PersistenceContext
    private EntityManager em;
    
    public void init() {
        String filenameMenus = "menus.csv";
        String filenameConfiguracion = "configuraciones.csv";
        String filenamDetalleConfiguracion = "detalle_configuraciones.csv";
        try {
            this.loadMenu(SetupService.class.getClassLoader().getResourceAsStream(filenameMenus));
            this.loadConfiguracion(SetupService.class.getClassLoader().getResourceAsStream(filenameConfiguracion));
            this.loadDetalleConfiguracion(SetupService.class.getClassLoader().getResourceAsStream(filenamDetalleConfiguracion));
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    private void loadMenu(InputStream archivo) throws Exception {
        BufferedReader br = null;
        String linea = "";
        String separador = ";";
        try {
            br = new BufferedReader(new InputStreamReader(archivo));
            while ((linea = br.readLine()) != null) {
                String[] menu = linea.split(separador);
                getMenu(menu);
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                }
            }
        }
    }
    
    private Menu getMenu(String[] menuStr) throws Exception {
        Menu singleResult = null;
        try {
            Query query = getEm().createQuery("SELECT m FROM Menu m WHERE" + ""
                    + " (m.code=:code)");
            query.setParameter("code", menuStr[0]);
            singleResult = (Menu) query.getSingleResult();
        } catch (NoResultException e) {
            this.createMenu(menuStr);
        }
        return singleResult;
    }
    
    private void createMenu(String[] menuStr) throws Exception {
        try {
            
            Menu menu = new Menu();
            menu.setCode(menuStr[0]);
            menu.setName(menuStr[2]);
            menu.setDescription(menuStr[3]);
            menu.setForm(menuStr[1]);
            menu.setIcon(menuStr[4]);
            getEm().persist(menu);
        } catch (Exception e) {
            throw e;
        }
    }
    
    private void loadConfiguracion(InputStream archivo) throws Exception {
        BufferedReader br = null;
        String linea = "";
        String separador = ";";
        try {
            br = new BufferedReader(new InputStreamReader(archivo));
            while ((linea = br.readLine()) != null) {
                String[] configuracion = linea.split(separador);
                getConfiguracion(configuracion);
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                }
            }
        }
    }
    
    private Configuracion getConfiguracion(String[] menuStr) throws Exception {
        Configuracion singleResult = null;
        try {
            Query query = getEm().createQuery("SELECT m FROM Configuracion m WHERE" + ""
                    + " (m.codigo=:code)");
            query.setParameter("code", menuStr[0]);
            singleResult = (Configuracion) query.getSingleResult();
        } catch (NoResultException e) {
            this.createConfiguracion(menuStr);
        }
        return singleResult;
    }
    
    private void createConfiguracion(String[] configStr) throws Exception {
        try {
            Configuracion configuracion = new Configuracion();
            configuracion.setCodigo(configStr[0]);
            configuracion.setNombre(configStr[1]);
            getEm().persist(configuracion);
        } catch (Exception e) {
            throw e;
        }
    }
    
    private void loadDetalleConfiguracion(InputStream archivo) throws Exception {
        BufferedReader br = null;
        String linea = "";
        String separador = ";";
        try {
            br = new BufferedReader(new InputStreamReader(archivo));
            while ((linea = br.readLine()) != null) {
                String[] detalleConfiguracion = linea.split(separador);
                getDetalleConfiguracion(detalleConfiguracion);
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                }
            }
        }
    }
    
    private DetalleConfiguracion getDetalleConfiguracion(String[] menuStr) throws Exception {
        DetalleConfiguracion singleResult = null;
        try {
            Query query = getEm().createQuery("SELECT m FROM DetalleConfiguracion m WHERE" + ""
                    + " (m.codigo=:code)");
            query.setParameter("code", menuStr[0]);
            singleResult = (DetalleConfiguracion) query.getSingleResult();
        } catch (NoResultException e) {
            this.createDetalleConfiguracion(menuStr);
        }
        return singleResult;
    }
    
    private void createDetalleConfiguracion(String[] configStr) throws Exception {
        try {
            Configuracion configuracion = getConfiguracionPorCodigo(configStr[3]);
            if (configuracion != null) {
                DetalleConfiguracion detalleConfiguracion = new DetalleConfiguracion();
                detalleConfiguracion.setCodigo(configStr[0]);
                detalleConfiguracion.setNombre(configStr[1]);
                detalleConfiguracion.setValor(configStr[2]);
                detalleConfiguracion.setConfiguracion(configuracion);
                getEm().persist(detalleConfiguracion);
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private Configuracion getConfiguracionPorCodigo(String code) throws Exception {
        Configuracion singleResult = null;
        try {
            Query query = getEm().createQuery("SELECT m FROM Configuracion m WHERE" + ""
                    + " (m.codigo=:code)");
            query.setParameter("code", code);
            singleResult = (Configuracion) query.getSingleResult();
        } catch (NoResultException e) {
        }
        return singleResult;
    }

    public EntityManager getEm() {
        return em;
    }
    
    public void setEm(EntityManager em) {
        this.em = em;
    }
    
}
