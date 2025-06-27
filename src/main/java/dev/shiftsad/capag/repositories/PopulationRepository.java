package dev.shiftsad.capag.repositories;

import dev.shiftsad.capag.entities.Population;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
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

    @Query("SELECT p FROM Population p WHERE p.ano IN :anos AND p.municipio IN :municipios AND p.uf IN :ufs")
    List<Population> findByAnoInAndMunicipioInAndUfIn(
            @Param("anos") List<Integer> anos,
            @Param("municipios") List<String> municipios,
            @Param("ufs") List<String> ufs
    );
}