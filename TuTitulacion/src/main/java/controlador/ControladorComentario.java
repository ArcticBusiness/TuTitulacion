/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import modelo.Comentario;
import modelo.ComentarioDAO;

/**
 *
 * @author miguel
 */
@Named(value = "controladorComentario")
@SessionScoped
public class ControladorComentario implements Serializable {

    ComentarioDAO comentarioDao;
    List<Comentario> comentarios;

    /**
     * Creates a new instance of ControladorComentario
     */
    public ControladorComentario() {
        comentarioDao = new ComentarioDAO();
    }
    
    public List<Comentario> getComentarios(){
        return comentarios;
    }
    
    @PostConstruct
    public void ver(){
        comentarios = comentarioDao.getComentarios();
    }

}
