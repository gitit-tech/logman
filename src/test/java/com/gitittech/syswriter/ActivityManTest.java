/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gitittech.syswriter;

import com.gitittech.syswriter.builders.ActivityBuilder;
import com.gitittech.syswriter.config.ConfigurationManager;
import com.gitittech.syswriter.models.Activity;
import com.gitittech.syswriter.models.Log;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Ambrose Ariagiegbe
 */
public class ActivityManTest {

    static EntityManager em;

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
        em.createNativeQuery("delete from activity").executeUpdate();
        em.getTransaction().commit();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of logActivity method, of class ActivityMan.
     */
    @Test
    public void testLogActivity() {
        System.out.println("logActivity");
        int expResult = 1;  
        Activity activity = new ActivityBuilder()
                .setActor("ambagape")
                .setClassName(Log.class.getName())
                .setProperty("controller")
                .setVal("the new value")
                .build();
        ActivityMan instance = ActivityMan.getInstance();
        instance.logActivity(activity);
        List list = em.createNamedQuery("Activity.findAll").getResultList();
        assertEquals(list.size(), expResult);
    }


}
