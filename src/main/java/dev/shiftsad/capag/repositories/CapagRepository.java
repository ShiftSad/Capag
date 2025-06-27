package dev.shiftsad.capag.repositories;

import dev.shiftsad.capag.entities.Capag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CapagRepository
        extends JpaRepository<Capag, Long>,
        QueryByExampleExecutor<Capag> {

    @Query("SELECT c FROM Capag c WHERE c.nomeMunicipio IN :municipios AND c.uf IN :ufs")
    List<Capag> findByNomeMunicipioInAndUfIn(
            @Param("municipios") List<String> municipios,
            @Param("ufs") List<String> ufs
    );
}
