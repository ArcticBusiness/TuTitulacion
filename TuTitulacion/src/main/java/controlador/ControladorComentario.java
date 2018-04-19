/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import modelo.Comentario;
import modelo.ComentarioDAO;
import modelo.ComentarioEn;
import modelo.ComentarioEnDAO;
import modelo.Pregunta;
import modelo.PreguntaDAO;
import modelo.PreguntaDe;
import modelo.PreguntaDeDAO;
import modelo.Usuario;
import modelo.UsuarioDAO;
import util.SessionUtils;

/**
 *
 * @author miguel
 */
@Named(value = "controladorComentario")
@SessionScoped
public class ControladorComentario implements Serializable {
    
    Pregunta pregunta;
    Comentario comentario;
    ComentarioDAO comentarioDao;
    List<Comentario> comentarios;

    /**
     * Creates a new instance of ControladorComentario
     */
    public ControladorComentario() {
        comentarioDao = new ComentarioDAO();
    }
    
    public Comentario getComentario() {
        return comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }

    public ComentarioDAO getComentarioDao() {
        return comentarioDao;
    }

    public void setComentarioDao(ComentarioDAO comentarioDao) {
        this.comentarioDao = comentarioDao;
    }
    
    public List<Comentario> getComentarios(){
        return comentarios;
    }
     /**
     * peticion que guarda un comentario
     */
    public String comentar(){
        Comentario c = new Comentario();
        c.setContenidoComentario(comentario.getContenidoComentario());
        c.setFecha(new Date());
        ComentarioDAO cd = new ComentarioDAO();
        cd.guarda(c);
        
        UsuarioDAO udao = new UsuarioDAO();
        Usuario u = udao.getUsuarioByEmail((String)SessionUtils.getSession().getAttribute("username"));
        
        PreguntaDAO pdao = new PreguntaDAO();
        Pregunta p = pdao.getPreguntaById(pregunta.getIdPregunta());
        
        ComentarioEn cEn = new ComentarioEn(c ,p ,u);     
        ComentarioEnDAO cendao = new ComentarioEnDAO();
        cendao.guarda(cEn);
        return "/vistaPregunta";
    }
    @PostConstruct
    public void ver(){
        ComentarioDAO cd = new ComentarioDAO();
        comentarios = cd.getComentarios();
    }

}
