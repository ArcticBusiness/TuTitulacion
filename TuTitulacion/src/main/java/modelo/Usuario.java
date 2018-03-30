package modelo;
// Generated 30/03/2018 01:55:12 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Usuario generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private int idUsuario;
     private String nombreUsuario;
     private String contrasenia;
     private String correoElectronico;
     private String urlImagen;
     private Set comentarioEns = new HashSet(0);
     private Set preguntaDes = new HashSet(0);

    public Usuario() {
    }

	
    public Usuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public Usuario(int idUsuario, String nombreUsuario, String contrasenia, String correoElectronico, String urlImagen, Set comentarioEns, Set preguntaDes) {
       this.idUsuario = idUsuario;
       this.nombreUsuario = nombreUsuario;
       this.contrasenia = contrasenia;
       this.correoElectronico = correoElectronico;
       this.urlImagen = urlImagen;
       this.comentarioEns = comentarioEns;
       this.preguntaDes = preguntaDes;
    }
   
    public int getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getNombreUsuario() {
        return this.nombreUsuario;
    }
    
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    public String getContrasenia() {
        return this.contrasenia;
    }
    
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    public String getCorreoElectronico() {
        return this.correoElectronico;
    }
    
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    public String getUrlImagen() {
        return this.urlImagen;
    }
    
    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }
    public Set getComentarioEns() {
        return this.comentarioEns;
    }
    
    public void setComentarioEns(Set comentarioEns) {
        this.comentarioEns = comentarioEns;
    }
    public Set getPreguntaDes() {
        return this.preguntaDes;
    }
    
    public void setPreguntaDes(Set preguntaDes) {
        this.preguntaDes = preguntaDes;
    }




}


