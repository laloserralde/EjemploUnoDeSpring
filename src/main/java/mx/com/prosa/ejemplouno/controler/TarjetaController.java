package mx.com.prosa.ejemplouno.controler;
import mx.com.prosa.ejemplouno.Response;
import mx.com.prosa.ejemplouno.exception.TarjetaException;
import mx.com.prosa.ejemplouno.exception.UtilsException;
import mx.com.prosa.ejemplouno.model.Tarjeta;
import mx.com.prosa.ejemplouno.service.ITarjetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/tarjeta")
public class TarjetaController {

    @Autowired
    ITarjetaService service;

    @PutMapping
    @ResponseBody
    public Response insertar(@RequestBody Tarjeta tarjeta) {
        try {
            Response response = service.insertar(tarjeta);
            return response;
        } catch (TarjetaException  | UtilsException e) {
            return new Response<>(null,e.getMessage());
        }
    }


    @GetMapping
    public Response<List<Tarjeta>> listaTarjetas() {
        Response response = service.listaTarjetas();
        return response;
    }

    @DeleteMapping
    @ResponseBody
    public Response eliminarTarjeta(@RequestBody Tarjeta tarjeta) {
        Response eliminarRegistro = service.eliminarTarjeta(tarjeta.getIdTarjeta());
        return eliminarRegistro;
    }


    @PostMapping
    @ResponseBody
    public Response actualizarDato(@RequestBody Tarjeta tarjeta) {
        Response actualizar = service.actualizar(tarjeta);
        return actualizar;
    }


    @GetMapping("/bb/{idTarjeta:.+}")
    public Response<Tarjeta> consultaID(@PathVariable int idTarjeta) {
        try {
            Response response = service.consultaPorID(idTarjeta);
            return response;
        } catch (TarjetaException e) {
            return new Response<>(null, e.getMessage());
        }
    }
}







