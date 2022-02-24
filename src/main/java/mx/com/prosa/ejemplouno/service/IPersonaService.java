package mx.com.prosa.ejemplouno.service;

import mx.com.prosa.ejemplouno.Response;
import mx.com.prosa.ejemplouno.entity.PersonEntity;
import mx.com.prosa.ejemplouno.model.Person;

import java.util.List;

public interface IPersonaService {

    Person informacion(String nombre);

    Response insertar(Person person);

    Response consulta(int idPerson);

    Response<List<Person>> listaBase();

    Response eliminar (int idPersona);

    Response actualizar (Person person);


}
