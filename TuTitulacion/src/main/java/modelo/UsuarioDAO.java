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
public class UsuarioDAO {

    private SessionFactory sessionFactory;

    /**
     *
     */
    public UsuarioDAO() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    public void guarda(Usuario u) {
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
    
        public void elimina(Usuario p){
        //System.out.println("aposdjaspodjaspodjaspodjaspodjaposjdpaosjdpaosjdpaos");
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
           tx = session.beginTransaction();

           session.delete(p);
           
               tx.commit();

        }
        catch (Exception e) {
           if (tx!=null){ 
               tx.rollback();
           }
           e.printStackTrace(); 
        }finally {
           session.close();
        }    

        }
        
}
