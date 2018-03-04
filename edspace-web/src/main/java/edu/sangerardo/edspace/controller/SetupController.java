/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sangerardo.edspace.controller;

import edu.sangerardo.edspace.database.SetupService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

/**
 *
 * @author jorgemalla
 */
@Startup
@Singleton
@TransactionManagement(TransactionManagementType.BEAN)
public class SetupController {

    @EJB
    private SetupService setupService;

    @PostConstruct
    public void init() {

        try {
            this.setupService.init();
        } catch (Exception e) {
            try {
                throw e;
            } catch (Exception ex) {
                Logger.getLogger(SetupController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public SetupService getSetupService() {
        return setupService;
    }

    public void setSetupService(SetupService setupService) {
        this.setupService = setupService;
    }

}
