/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import org.hibernate.Query;
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

    /**
     * 
     * @param u 
     */
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

    /**
     * 
     * @param idUsuario
     * @return 
     */
    public Usuario getUsuarioById(int idUsuario) {
        Usuario u = null;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "from Usuario where id_usuario = " + idUsuario;
            Query query = session.createQuery(hql);
            u = (Usuario) query.uniqueResult();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return u;
    }

    /**
     * 
     * @param u 
     */
    public void actualiza(Usuario u) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(u);
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
