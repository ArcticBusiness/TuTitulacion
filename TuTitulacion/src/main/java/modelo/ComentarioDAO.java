/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author miguel
 */
public class ComentarioDAO {

    Session session;

    public ComentarioDAO() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public List getComentarios() {
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
