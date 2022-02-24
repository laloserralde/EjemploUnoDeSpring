package mx.com.prosa.ejemplouno.service;
import mx.com.prosa.ejemplouno.Response;
import mx.com.prosa.ejemplouno.entity.PersonEntity;
import mx.com.prosa.ejemplouno.entity.TarjetaEntity;
import mx.com.prosa.ejemplouno.model.Person;
import mx.com.prosa.ejemplouno.model.Tarjeta;
import mx.com.prosa.ejemplouno.repository.PersonRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaService implements IPersonaService {

    private ModelMapper mapper = new ModelMapper();
    private Logger logger = LoggerFactory.getLogger(PersonaService.class);


    @Autowired
    private PersonRepository repository;

    @Override
    public Person informacion(String nombre) {
        Person p1 = new Person("Angel", "12345", 1994, 11, 12, 34);
        Tarjeta t1 = new Tarjeta("123456");
        p1.setTarjeta(t1);
        return p1;
    }

    @Override
    public Response insertar(Person person) {
        PersonEntity personEntity = mapper.map(person, PersonEntity.class);
        logger.info("Registrando...");
        repository.save(personEntity);
        Response response = new Response(personEntity,"Se registro la persona");
        logger.info("Se registro la persona correctamente");
        return response;
    }

    @Override
    public Response consulta(int idPerson) {

        Optional<PersonEntity> consultaDePersona = repository.findById(idPerson);
        if (consultaDePersona.isPresent()) {
            PersonEntity personEntity = consultaDePersona.get();
            Person person = mapper.map(personEntity,Person.class);
            Response respuesta = new Response(person,"encontrada");
            return respuesta;
        }
        return new Response(new Person(),"Error");
    }

    @Override
    public Response<List<Person>> listaBase() {
        List<Person> personList = new ArrayList<>();
        List<PersonEntity> lista = repository.findAll();
        for (PersonEntity e : lista){
           // Person person = new Person(e.getName(),e.getCellphone(),e.getFechaNacimiento(),e.getFavoriteNumber());
            //personList.add(person);
            Person person1 = mapper.map(e,Person.class);
            personList.add(person1);
            Response response = new Response(lista,"Lista de tarjetas");
        }
        return new Response<>(personList,"No hay lista");
    }

    @Override
    public Response eliminar (int idPersona) {
        Optional<PersonEntity> eliminar = repository.findById(idPersona);
        if (eliminar.isPresent()){
            PersonEntity personEntity = eliminar.get();
            repository.delete(personEntity);
            Response response = new Response<>(personEntity,"Persona eliminada");
            return response;
        }
        return new Response(new Person(),"No existe persona a eliminar");
    }

    @Override
    public Response actualizar (Person person){
        Optional<PersonEntity> actualiza = repository.findById(person.getIdPerson());
        if (actualiza.isPresent()){
            PersonEntity personEntity = actualiza.get();
            //entity.setName(person.getName());
            //entity.setCellphone(person.getCellphone());
            //entity.setFechaNacimiento(person.getFechaNacimiento());
            //entity.setFavoriteNumber(person.getFavoriteNumber());
            PersonEntity personEntity1 = mapper.map(person,PersonEntity.class);
            repository.save(personEntity1);
            Response response = new Response<>(personEntity1,"Registro actualizado");

            return response;
        }
        return new Response(new Person(),"No existe registro a actualizar");
    }



}






