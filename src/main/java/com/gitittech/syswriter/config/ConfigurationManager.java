/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gitittech.syswriter.config;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ambrose Ariagiegbe
 */
public class ConfigurationManager {

    private final EntityManagerFactory EMF;
    static private ConfigurationManager instance;

    private ConfigurationManager(String dbName) {
        Map<String, String> map = new HashMap<>();
        map.put("javax.persistence.jdbc.url", "jdbc:h2:~/"+dbName);
        map.put("javax.persistence.jdbc.user", "-user");
        map.put("javax.persistence.jdbc.driver", "org.h2.Driver");
        map.put("javax.persistence.jdbc.password", "");
        map.put("javax.persistence.schema-generation.database.action", "create");
        EMF
                = Persistence.createEntityManagerFactory("com.gitittech_errorman", map);
    }

    public EntityManager getEntityManager(){
        return EMF.createEntityManager();
    }
    static public ConfigurationManager getInstance(String dbName) {
        if (instance == null) {
            instance = new ConfigurationManager(dbName);
        }
        return instance;
    }
}
