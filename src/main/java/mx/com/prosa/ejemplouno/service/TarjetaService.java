package mx.com.prosa.ejemplouno.service;
import mx.com.prosa.ejemplouno.Response;
import mx.com.prosa.ejemplouno.entity.TarjetaEntity;
import mx.com.prosa.ejemplouno.exception.TarjetaException;
import mx.com.prosa.ejemplouno.exception.UtilsException;
import mx.com.prosa.ejemplouno.model.Tarjeta;
import mx.com.prosa.ejemplouno.repository.TarjetaRepository;
import mx.com.prosa.ejemplouno.util.Utils;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class TarjetaService implements ITarjetaService {

    private final ModelMapper mapper = new ModelMapper(); //Se hicieron constantes.
    private final Logger logger = LoggerFactory.getLogger(TarjetaService.class);

    @Autowired
    private TarjetaRepository repository;

    @Override
    public String infTarjeta() {
        Tarjeta t1 = new Tarjeta("123456");
        return "Tu numero de cuenta es " + t1;
    }

    @Override
    public Response<Tarjeta> insertar(Tarjeta tarjeta) throws TarjetaException, UtilsException {
        Utils.rechazarNCuenta(tarjeta.getnCuenta());
        Utils.rechazarCvv(tarjeta.getCvv());
        if (tarjeta.getnCuenta().length() != 20 || tarjeta.getCvv().length() != 3){
            throw new TarjetaException(0,"La longitud del numero de cuenta y/o el cvv estan mal escritos");
        }
        TarjetaEntity tarjetaEntity = mapper.map(tarjeta, TarjetaEntity.class);
        repository.save(tarjetaEntity);
        Tarjeta tarjeta1 = mapper.map(tarjetaEntity, Tarjeta.class);
        return new Response<>(tarjeta1, " OK ");
    }

    @Override
    public Response consultaPorID(int idTarjeta) throws TarjetaException{

        Optional<TarjetaEntity> consultaPorId = repository.findById(idTarjeta);
        if (consultaPorId.isPresent()) {
            TarjetaEntity tarjetaEntity = consultaPorId.get();
            Tarjeta tarjeta = mapper.map(tarjetaEntity, Tarjeta.class);

            if( tarjeta.getnCuenta().length() !=16 && tarjeta.getCvv().length() != 3 ) {
                throw new TarjetaException(1, "El numero de cuenta y el cvv estan mal");
            }
            return new Response( tarjeta, "OK ");
        }
        throw new TarjetaException(0,"Tarjeta no encontrada");
    }

    @Override
    public Response<List<Tarjeta>>listaTarjetas(){
        List<Tarjeta> tarjetaList = new ArrayList<>();
        List<TarjetaEntity> tarjetaEntityList = repository.findAll();
        for (TarjetaEntity e : tarjetaEntityList){
            Tarjeta tarjeta = mapper.map(e,Tarjeta.class);
            tarjetaList.add(tarjeta);
            Response response = new Response(tarjetaEntityList,"Lista de tarjetas");
           return response;
        }
        return new Response<>(tarjetaList,"No hay lista");
    }

    @Override
    public Response eliminarTarjeta (int idTarjeta){
        Optional<TarjetaEntity> eliminarDato = repository.findById(idTarjeta);
        if (eliminarDato.isPresent()){
            TarjetaEntity tarjetaEntity = eliminarDato.get();
            repository.delete(tarjetaEntity);
            Response response = new Response<>(tarjetaEntity,"Tarjete eliminada");
            return response;
        }
        return new Response(new Tarjeta(),"No existe tarjeta a eliminar");
    }

    @Override
    public Response<Tarjeta> actualizar (Tarjeta tarjeta){
        Optional<TarjetaEntity> actualizarDato = repository.findById(tarjeta.getIdTarjeta());
        if (actualizarDato.isPresent()){
            //TarjetaEntity tarjetaEntity = actualizarDato.get();
            TarjetaEntity tarjetaEntity = mapper.map(tarjeta,TarjetaEntity.class);
           //Tarjeta tarjeta1 = mapper.map(tarjetaEntity,Tarjeta.class);
           repository.save(tarjetaEntity);
           Tarjeta tarjeta1 = mapper.map(tarjetaEntity,Tarjeta.class);
           Response<Tarjeta> response = new Response<Tarjeta>(tarjeta1,"Registro actualizado");
            return response;
        }
        return new Response(new Tarjeta(),"No existe registro a actualizar");
    }

}
