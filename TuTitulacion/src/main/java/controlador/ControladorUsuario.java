/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import java.util.Random;
import java.util.Set;
import modelo.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import modelo.CodigoVerificacionDe;
import modelo.CodigoVerificacionDeDAO;
import modelo.UsuarioDAO;
import org.hibernate.validator.HibernateValidator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author miguel
 */
@ManagedBean
@RequestScoped
public class ControladorUsuario implements Serializable {

    private String nombreUsuario;
    private String contrasenia;
    private String confirmacionContrasenia;
    private String correoElectronico;
    private String urlImagen;

    /**
     * Creates a new instance of ControladorUsuario
     */
    public ControladorUsuario() {
    }

    /**
     *
     * @return
     */
    public String registra() {
        System.out.println(contrasenia.length());
        Usuario u = new Usuario(nombreUsuario, contrasenia, correoElectronico, urlImagen, false);
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<Usuario>> validationErrors = validator.validate(u);
        if (!validationErrors.isEmpty()) {
            for (ConstraintViolation<Usuario> error : validationErrors) {
                System.out.println(error.getMessageTemplate() + "::" + error.getPropertyPath() + "::" + error.getMessage());
            }
        } else {
            UsuarioDAO uDao = new UsuarioDAO();
            uDao.guarda(u);
            ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
            VerificationMailSender vms = (VerificationMailSender) context.getBean("verificationMailSender");
            Random random = new Random();
            String codigo = String.format("%d%d%d%d%d%d", random.nextInt(10),random.nextInt(10),random.nextInt(10),random.nextInt(10),random.nextInt(10),random.nextInt(10));            
            CodigoVerificacionDe cvd = new CodigoVerificacionDe(codigo, u.getIdUsuario());
            CodigoVerificacionDeDAO cdvDAO = new CodigoVerificacionDeDAO();
            cdvDAO.guarda(cvd);
            vms.sendMail("tutitulacion@gmail.com", correoElectronico, "Confirmación", "Tu código de verificación es: " + codigo);
        }
        return "index";
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

    public String getCorreoElectronico() {
        return correoElectronico;
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
