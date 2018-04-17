/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import modelo.Usuario;
import modelo.UsuarioDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author miguel
 */
@ManagedBean
@ViewScoped
public class ControladorUsuario implements Serializable {

    //@NotNull
    private String nombreUsuario;
    //@NotNull
    //@Min(8)
    private String contrasenia;
    //@NotNull
    //@Min(8)
    private String confirmacionContrasenia;
    //@NotNull
    private String correoElectronico;
    private String urlImagen;
    
    private String usuarioBorrar;
    /**
     * Creates a new instance of ControladorUsuario
     */
    public ControladorUsuario() {
    }

    public String registra() {
        System.out.println("Usuario: "+ nombreUsuario+","+contrasenia+","+correoElectronico+","+urlImagen);
        Usuario u = new Usuario(nombreUsuario, contrasenia, correoElectronico, urlImagen);
        UsuarioDAO uDao = new UsuarioDAO();
        uDao.guarda(u);
        return "index";
    }

    public String elimina(String a) {
        UsuarioDAO uDao = new UsuarioDAO();
        Usuario user = new Usuario();
        user.setNombreUsuario(a);
        user.setIdUsuario(3);
        System.out.print(a);
        uDao.elimina(user);
        return user.getNombreUsuario();
    }
    
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public void setUsuarioBorrar(String usuario) {
        this.usuarioBorrar = usuario;
    }

    
    public String getUsuarioBorrar() {
        return usuarioBorrar;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public String getConfirmacionContrasenia() {
        return confirmacionContrasenia;
    }

    public void setConfirmacionContrasenia(String confirmacionContrasenia) {
        this.confirmacionContrasenia = confirmacionContrasenia;
    }

}
