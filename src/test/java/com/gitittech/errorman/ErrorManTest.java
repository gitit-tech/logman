/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gitittech.errorman;

import com.gitittech.syswriter.LogMan;
import com.gitittech.syswriter.Level;
import com.gitittech.syswriter.builders.LogBuilder;
import com.gitittech.syswriter.config.ConfigurationManager;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author USER
 */
public class ErrorManTest {

    static EntityManager em;

    public ErrorManTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        
        em 
            = ConfigurationManager.getInstance("test").getEntityManager();
    }

    @AfterClass
    public static void tearDownClass() {
        if (em != null) {
            em.close();
        }
       
    }

    @Before
    public void setUp() {
        em.getTransaction().begin();
        em.createNativeQuery("delete from log").executeUpdate();
        em.getTransaction().commit();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of respond method, of class LogMan.
     */
    @Test
    public void testRespond() {
        System.out.println("respond");
        LogMan instance = LogMan.getInstance();
        int expResult = 1;       
        
        instance.respond(new LogBuilder().setController("appcontroller")
                .setDescription("description")
                .setLevel(Level.DEBUG).build());
        List list = em.createNamedQuery("Log.findAll").getResultList();
        assertEquals(list.size(), expResult);
    }
}
