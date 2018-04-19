package controlador;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import modelo.ComentarioEn;
import modelo.ComentarioEnDAO;

@ManagedBean
@SessionScoped
public class ControladorComentarioEn implements Serializable{

    private List<ComentarioEn> comentarios;
    private int identificadorP; //almacenar el identificador de la Pregunta 
                                //de la que se mostraran sus comentarios
    /*
    @PostConstruct
    public void verComentarios() {
        ComentarioEnDAO ced = new ComentarioEnDAO();
        comentarios = ced.mostrarComentariosDe(1);
        //comentarios = ced.mostrarComentariosDe(identificadorP);
    }*/
    public String verComentariosEn(int id){
        if(!"".equals(id)){    
            ComentarioEnDAO cdao = new ComentarioEnDAO();
            //mostramos los comentarios del id de la pregunta 
            comentarios = cdao.mostrarComentariosDe(id);
            return "vistaPregunta?faces-redirect=true";
        }
        return "";
        
    }

    public List<ComentarioEn> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<ComentarioEn> comentarios) {
        this.comentarios = comentarios;
    }

}
