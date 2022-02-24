package mx.com.prosa.ejemplouno.service;

import mx.com.prosa.ejemplouno.model.Person;

import java.util.List;

//Una interfaz es abstracta y no se pueden instanciar

public interface IWelcomeService {

    String saludar();

    List<String>primerlista(String nombre);

    Person person1();

    Person mensaje(Person person2);




}
