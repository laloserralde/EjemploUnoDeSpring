package mx.com.prosa.ejemplouno.service;

import mx.com.prosa.ejemplouno.model.Person;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service // lo hace en un bean. ya tiene un formato singleton.
public class WelcomeService implements IWelcomeService {


    @Override
    public String saludar() {
        return "Hola, que onda";
    }

    @Override
    public List<String> primerlista(String nombre) {
        List<String>lista = new ArrayList<>();
        lista.add("Hola");
        lista.add("xd");
        lista.add("123");
        return lista;
    }

    @Override
    public Person person1() {
        Person person = new Person("Eduardo","5574223418",1995,06,19,3);
        return person;
    }

    @Override
    public Person mensaje(Person person2) {
        System.out.println(person2);
        return person2;
    }
}
