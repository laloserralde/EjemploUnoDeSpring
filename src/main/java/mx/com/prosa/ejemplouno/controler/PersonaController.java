package mx.com.prosa.ejemplouno.controler;

import mx.com.prosa.ejemplouno.Response;
import mx.com.prosa.ejemplouno.model.Person;
import mx.com.prosa.ejemplouno.service.IPersonaService;
import mx.com.prosa.ejemplouno.service.ITarjetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/person")
public class PersonaController {

    @Autowired
    IPersonaService service;
    @Autowired
    ITarjetaService service2;

    @GetMapping("/name/{nombre:.+}")
    public Person info (@PathVariable String nombre){
        Person person = service.informacion("Angel");
        return person;
    }

    //@PostMapping("/elangel")
    //@ResponseBody
    //public Person info2(@RequestBody Person p2){
      //  Person p = service2.registro(p2);
        //return p;
    //}

    @PutMapping //El create es insertar. es put la anotacion. recordarlo.
    @ResponseBody
    public Response insertar(@RequestBody Person p3){
        Response response = service.insertar(p3);
        return response;
    }

    //Para consultar por ID.
    @GetMapping("/base/{idPerson:.+}")
    public Response<Person> consulta(@PathVariable int idPerson){
        Response response = service.consulta(idPerson);
        return response;
    }

    //PARA CONSULTAR TODA LA BASE.
    @GetMapping
    public Response<List<Person>>listaBase() {
        Response response = service.listaBase();
        return response;
    }

        @DeleteMapping
        @ResponseBody
        public Response eliminar (@RequestBody Person person){
        Response eliminaRegistro = service.eliminar(person.getIdPerson());
        return eliminaRegistro;
        }

        @PostMapping
        @ResponseBody
        public Response actualizar(@RequestBody Person person){
        Response response = service.actualizar(person);
        return response;
        }
    }










