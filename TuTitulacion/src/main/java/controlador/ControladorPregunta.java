
package controlador;

import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Pregunta;
import modelo.PreguntaDAO;

@ManagedBean
@ViewScoped
public class ControladorPregunta {
    
    private List<Pregunta> preguntas;
    private String contenidoPregunta;
    private Date fechaPregunta;
    
    public List<Pregunta> getPregunta(){
        return preguntas;
    }
    public String getContenidoPregunta(){
        return contenidoPregunta;
    }
    public void setContenidoPregunta(String contenido){
        contenidoPregunta=contenido;
    }

    public Date getFechaPregunta() {
        return fechaPregunta;
    }

    public void setFechaPregunta(Date fechaPregunta) {
        this.fechaPregunta = fechaPregunta;
    }
    
    
    /**
     * peticion que guarda una pregunta
     */
    public void guardaProyecto(){
        Pregunta p = new Pregunta();
        p.setContenidoPregunta(contenidoPregunta);
        p.setFechaPregunta(new Date());
        PreguntaDAO pd = new PreguntaDAO();
        pd.guarda(p);
    }
    @PostConstruct
    public void verPreguntas(){
        PreguntaDAO pd = new PreguntaDAO();
        preguntas = pd.mostrarPreguntas();
    }
    
}
