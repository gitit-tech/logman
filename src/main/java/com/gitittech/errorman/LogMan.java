/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gitittech.errorman;

import com.gitittech.errorman.config.ConfigurationManager;
import com.gitittech.errorman.models.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.persistence.EntityManager;

/**
 *
 * @author Ambrose Ariagiegbe
 */
public class LogMan implements ILogMan {

    private static LogMan instance;

    EntityManager em;

    private LogMan() {
    }

    @Override
    public void respond(Log log) {
        try {            
            em = ConfigurationManager.getInstance("logman").getEntityManager();
            em.getTransaction().begin();
            em.persist(log);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public static String getStackTrace(Throwable e) {
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw));
        return sw.toString();
    }

    public static LogMan getInstance() {
        if (instance == null) {
            instance = new LogMan();
        }
        return instance;
    }
}
