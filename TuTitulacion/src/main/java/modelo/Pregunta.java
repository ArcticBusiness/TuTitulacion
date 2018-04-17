package modelo;
// Generated 9/04/2018 11:24:07 PM by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Pregunta generated by hbm2java
 */
public class Pregunta  implements java.io.Serializable {

     private int idPregunta;
     private String contenidoPregunta;
     private Date fechaPregunta;
     private Set preguntaDes = new HashSet(0);
     private Set comentarioEns = new HashSet(0);
     private LinkedList<Comentario> comentarios;

    public Pregunta() {
    }
    
    public Pregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }
    public Pregunta(int idPregunta, String contenidoPregunta, Date fechaPregunta, Set preguntaDes, Set comentarioEns) {
       this.idPregunta = idPregunta;
       this.contenidoPregunta = contenidoPregunta;
       this.fechaPregunta = fechaPregunta;
       this.preguntaDes = preguntaDes;
       this.comentarioEns = comentarioEns;
    }
   
    public int getIdPregunta() {
        return this.idPregunta;
    }

    public LinkedList<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(LinkedList<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
    
    public void agregaComentario(Comentario c) {
        comentarios.add(c);
    }
    
    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }
    public String getContenidoPregunta() {
        return this.contenidoPregunta;
    }
    
    public void setContenidoPregunta(String contenidoPregunta) {
        this.contenidoPregunta = contenidoPregunta;
    }
    public Date getFechaPregunta() {
        return this.fechaPregunta;
    }
    
    public void setFechaPregunta(Date fechaPregunta) {
        this.fechaPregunta = fechaPregunta;
    }
    public Set getPreguntaDes() {
        return this.preguntaDes;
    }
    
    public void setPreguntaDes(Set preguntaDes) {
        this.preguntaDes = preguntaDes;
    }
    public Set getComentarioEns() {
        return this.comentarioEns;
    }
    
    public void setComentarioEns(Set comentarioEns) {
        this.comentarioEns = comentarioEns;
    }




}
