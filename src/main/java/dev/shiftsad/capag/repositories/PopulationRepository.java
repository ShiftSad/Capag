package dev.shiftsad.capag.repositories;

import dev.shiftsad.capag.entities.Population;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import java.util.stream.StreamSupport;


@Repository
public interface PopulationRepository
        extends CrudRepository<Population, Long>,
        QueryByExampleExecutor<Population> {

    default int getMostRecentYear() {
        return StreamSupport.stream(findAll().spliterator(), false)
                .mapToInt(Population::getAno)
                .max()
                .orElseThrow(() ->
                        new IllegalStateException("Nenhum dado de população disponível"));
    }

    Population findByCodMunicipioAndAno(String codMunicipio, Integer ano);
}