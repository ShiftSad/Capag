package dev.shiftsad.capag.repositories;

import dev.shiftsad.capag.entities.Capag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CapagRepository
        extends JpaRepository<Capag, Long>,
        QueryByExampleExecutor<Capag> {
    Capag findByNomeMunicipio(String nomeMunicipio);
    Capag findByCodigoMunicipioCompleto(String codigoMunicipioCompleto);
}
