package mx.com.prosa.ejemplouno.repository;

import mx.com.prosa.ejemplouno.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //Hace queries.
public interface PersonRepository extends JpaRepository <PersonEntity,Integer> {
    List<PersonEntity>findAllByName(String nombre);
}
