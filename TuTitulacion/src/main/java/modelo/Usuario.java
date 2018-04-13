package modelo;
// Generated 9/04/2018 11:24:07 PM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Usuario generated by hbm2java
 */
public class Usuario implements java.io.Serializable {

    private int idUsuario;
    @NotBlank(message = "Por favor, escriba su nombre")
    private String nombreUsuario;
    @Size(min = 8, max = 100, message = "La contraseña debe contener al menos 8 caracteres")
    private String contrasenia;
    @Email(message = "Por favor, ingrese un email válido")
    @NotBlank(message = "Por favor, ingrese un email")
    private String correoElectronico;
    private String urlImagen;
    private boolean correoVerificado;
    private Set comentarioEns = new HashSet(0);
    private Set preguntaDes = new HashSet(0);

    public Usuario() {
    }

    public Usuario(String nombreUsuario, String contrasenia, String correoElectronico) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.correoElectronico = correoElectronico;
    }

    public Usuario(String nombreUsuario, String contrasenia, String correoElectronico, String urlImagen, boolean correoVerificado, Set comentarioEns, Set preguntaDes) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.correoElectronico = correoElectronico;
        this.urlImagen = urlImagen;
        this.correoVerificado = correoVerificado;
        this.comentarioEns = comentarioEns;
        this.preguntaDes = preguntaDes;
    }

    public Usuario(String nombreUsuario, String contrasenia, String correoElectronico, String urlImagen, boolean correoVerificado) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.correoElectronico = correoElectronico;
        this.urlImagen = urlImagen;
        this.correoVerificado = correoVerificado;
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

    public boolean isCorreoVerificado() {
        return this.correoVerificado;
    }

    public void setCorreoVerificado(boolean correoVerificado) {
        this.correoVerificado = correoVerificado;
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
