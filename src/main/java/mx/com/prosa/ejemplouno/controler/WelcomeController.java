package mx.com.prosa.ejemplouno.controler;
import mx.com.prosa.ejemplouno.model.Person;
import mx.com.prosa.ejemplouno.service.IWelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class WelcomeController {

    //IWelcomeService service = new WelcomeService();
    @Autowired //Para instanciar beans.
    IWelcomeService service;

    @GetMapping("/hello")
    public String saludar(){
        String saludo = service.saludar();
        return saludo;
    }

    @GetMapping("/array/{nombre:.+}")
    public List<String> primerLista(@PathVariable String nombre){
       List<String> list = service.primerlista(nombre);
       return list;
    }

    @GetMapping("/person1")
    public Person person1 (){
       Person person = service.person1();
       return person;
    }

    @PostMapping("/person2")
    @ResponseBody
    public Person mensaje (@RequestBody Person person2){
        Person mensaje = service.mensaje(person2);
        System.out.println(person2);
        return person2;
    }

}
