package mx.com.prosa.ejemplouno.repository;

import mx.com.prosa.ejemplouno.entity.TarjetaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarjetaRepository extends JpaRepository<TarjetaEntity,Integer> {

}
