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
 * @author Administrador
 */
public class PreguntaDAO {
    private SessionFactory sessionFactory;
    
    public PreguntaDAO(){
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }
    
    public void guarda(Pregunta p){
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.persist(p);
            tx.commit();
     
        }catch (Exception e){
            if (tx != null){
                tx.rollback();
            }
            e.printStackTrace();
        }finally{
            session.close();
        }
    }
    /**
    public Pregunta buscar(Pregunta p){
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.createQuery(string)
            tx.commit();
     
        }catch (Exception e){
            if (tx != null){
                tx.rollback();
            }
            e.printStackTrace();
        }finally{
            session.close();
        }
    }**/
}
