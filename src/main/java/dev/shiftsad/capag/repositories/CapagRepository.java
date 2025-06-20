package dev.shiftsad.capag.repositories;

import dev.shiftsad.capag.entities.Capag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CapagRepository extends CrudRepository<Capag, Long> {
    Capag findByNomeMunicipio(String nomeMunicipio);
    Capag findByCodigoMunicipioCompleto(String codigoMunicipioCompleto);
}
