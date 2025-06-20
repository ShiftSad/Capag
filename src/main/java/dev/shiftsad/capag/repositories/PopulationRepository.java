package dev.shiftsad.capag.repositories;

import dev.shiftsad.capag.entities.Population;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.StreamSupport;

@Repository
public interface PopulationRepository extends CrudRepository<Population, Long> {
    Population findByCodMunicipioAndAno(String codMunicipio, Integer ano);

    default Integer getMostRecentYear() {
        return StreamSupport.stream(findAll().spliterator(), false)
                .map(Population::getAno)
                .max(Integer::compareTo)
                .orElse(null);
    }
}