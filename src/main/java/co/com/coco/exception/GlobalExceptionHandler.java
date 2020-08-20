package co.com.coco.exception;

import co.com.coco.dto.core.Respuesta;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler extends DefaultErrorAttributes {


    @ExceptionHandler({ServiceException.class})
    public Respuesta handleServiceException(Exception e, HttpServletResponse response) {

        response.setStatus(400);
        Respuesta respuesta = new Respuesta();
        respuesta.setMensaje(e.getMessage());
        return respuesta;
    }


    @ExceptionHandler({DaoException.class})
    public Respuesta handleDaoException(Exception e, HttpServletResponse response) {

        response.setStatus(400);
        Respuesta respuesta = new Respuesta();
        respuesta.setMensaje(e.getMessage());
        return respuesta;
    }


    @ExceptionHandler({Exception.class})
    public Respuesta handleExceptions(Exception e, HttpServletResponse response, WebRequest webRequest) {

        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest,
                ErrorAttributeOptions.defaults().including(ErrorAttributeOptions.Include.EXCEPTION, ErrorAttributeOptions.Include.BINDING_ERRORS, ErrorAttributeOptions.Include.MESSAGE));

        System.out.println(errorAttributes);
        response.setStatus(500);
        e.printStackTrace();
        Respuesta respuesta = new Respuesta();
        respuesta.setMensaje("Ocurrió un error durante el proceso: " + errorAttributes.get("message").toString());
        respuesta.setException(errorAttributes.get("exception").toString());
        return respuesta;
    }

    @ExceptionHandler({RuntimeException.class})
    public Respuesta runtimeException(RuntimeException e, HttpServletResponse response, WebRequest webRequest) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest,
                ErrorAttributeOptions.defaults().including(ErrorAttributeOptions.Include.EXCEPTION, ErrorAttributeOptions.Include.BINDING_ERRORS, ErrorAttributeOptions.Include.MESSAGE));

        System.out.println(errorAttributes);
        response.setStatus(500);
        e.printStackTrace();
        Respuesta respuesta = new Respuesta();
        respuesta.setMensaje("Ocurrió un error durante el proceso: " + errorAttributes.get("message").toString());
        respuesta.setException(errorAttributes.get("exception").toString());
        return respuesta;
    }
}
