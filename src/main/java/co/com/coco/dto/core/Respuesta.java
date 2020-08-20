package co.com.coco.dto.core;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Respuesta {

    private String mensaje;

    private Object data;

    private String exception;

    public String getMensaje() {
        return mensaje;
    }
    public Respuesta(){

    }
    public Respuesta(String mensaje){

        this.mensaje = mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }
}
