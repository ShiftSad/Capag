package dev.shiftsad.capag.controller;

import dev.shiftsad.capag.entities.Capag;
import dev.shiftsad.capag.repositories.CapagRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class CapagController {

    private final CapagRepository capagRepository;

    @GetMapping("/capag")
    public Iterable<Capag> getCapag() {
        return capagRepository.findAll();
    }

    @GetMapping("/capag/")
    public Capag getCapagByMunicipio(String codMunicipio) {
        return capagRepository.findByCodigoMunicipioCompleto(codMunicipio);
    }

    @GetMapping("/capag/municipio")
    public Capag getCapagByNomeMunicipio(String nomeMunicipio) {
        return capagRepository.findByNomeMunicipio(nomeMunicipio);
    }
}
