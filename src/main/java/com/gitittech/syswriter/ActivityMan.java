package com.gitittech.syswriter;

import com.gitittech.syswriter.config.ConfigurationManager;
import com.gitittech.syswriter.models.Activity;
import javax.persistence.EntityManager;

/**
 *
 * @author Ambrose Ariagiegbe
 */
public class ActivityMan {
    
    private static ActivityMan instance;
    
    EntityManager em;
    
    private ActivityMan(){
        
    }
    public void logActivity(Activity activity){
         try {            
            em = ConfigurationManager.getInstance("logman").getEntityManager();
            em.getTransaction().begin();
            em.persist(activity);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
     public static ActivityMan getInstance() {
        if (instance == null) {
            instance = new ActivityMan();
        }
        return instance;
    }
}
