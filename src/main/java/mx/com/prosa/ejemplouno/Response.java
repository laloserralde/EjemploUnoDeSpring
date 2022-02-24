package mx.com.prosa.ejemplouno;

import mx.com.prosa.ejemplouno.model.Tarjeta;


public class Response<T>{
    private T object;
    private String mensaje;

    public Response(T object, String mensaje) {
        this.object = object;
        this.mensaje = mensaje;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
