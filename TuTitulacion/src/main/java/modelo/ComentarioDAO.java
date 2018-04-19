/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author miguel
 */
public class ComentarioDAO {
    private SessionFactory sessionFactory;
    Session session;

    public ComentarioDAO() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }
   
    public void guarda(Comentario c){
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.persist(c);
            tx.commit();
        }catch (Exception e){
            if(tx != null){
                tx.rollback();
            }
            e.printStackTrace();         
        }finally{
            session.close();
        }        
    }
    
    public List<Comentario> getComentarios() {
        List<Comentario> comentarios = null;
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Comentario");
            comentarios = (List<Comentario>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return comentarios;
    }
    

}
