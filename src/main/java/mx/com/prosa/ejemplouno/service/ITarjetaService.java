package mx.com.prosa.ejemplouno.service;

import mx.com.prosa.ejemplouno.Response;
import mx.com.prosa.ejemplouno.exception.TarjetaException;
import mx.com.prosa.ejemplouno.exception.UtilsException;
import mx.com.prosa.ejemplouno.model.Person;
import mx.com.prosa.ejemplouno.model.Tarjeta;

import java.util.List;

public interface ITarjetaService {

    String infTarjeta();

    Response insertar(Tarjeta tarjeta) throws TarjetaException, UtilsException;

    Response<List<Tarjeta>>listaTarjetas();

    Response eliminarTarjeta (int idTarjeta);

    Response actualizar (Tarjeta tarjeta);

    Response consultaPorID(int idTarjeta) throws TarjetaException;

}
