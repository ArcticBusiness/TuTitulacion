/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import modelo.PreguntaDe;
import modelo.PreguntaDeDAO;

/**
 *
 * @author miguel
 */
@ManagedBean
@ViewScoped
@SessionScoped
public class ControladorPreguntaDe implements Serializable{

    private List<PreguntaDe> preguntas;

    @PostConstruct
    public void verPreguntas() {
        PreguntaDeDAO pd = new PreguntaDeDAO();
        preguntas = pd.mostrarPreguntas();
    }

    public List<PreguntaDe> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<PreguntaDe> preguntas) {
        this.preguntas = preguntas;
    }

}
