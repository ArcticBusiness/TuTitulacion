/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author miguel
 */
public class CodigoVerificacionDeDAO {
    
     private SessionFactory sessionFactory;

    /**
     *
     */
    public CodigoVerificacionDeDAO() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }
    
    
     public void guarda(CodigoVerificacionDe u) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.persist(u);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
