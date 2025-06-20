package dev.shiftsad.capag.controller;

import dev.shiftsad.capag.entities.Population;
import dev.shiftsad.capag.repositories.PopulationRepository;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@RestController
public class PopulationController {

    private final PopulationRepository populationRepository;

    @Transient
    private int mostRecentYear = -1;

    @GetMapping("/population")
    public Iterable<Population> getPopulation(@RequestParam(name = "ano") int ano) {
        return StreamSupport.stream(populationRepository.findAll().spliterator(), false)
                .filter(population -> population.getAno().equals(ano))
                .toList();
    }

    @GetMapping("/population/")
    public Population getPopulationByMunicipio(@RequestParam(name = "ano") int ano,
                                               @RequestParam(name = "codMunicipio") String codMunicipio) {
        return populationRepository.findByCodMunicipioAndAno(codMunicipio, ano);
    }

    @GetMapping("/population/recent")
    public Population getRecentPopulation(@RequestParam(name = "codMunicipio") String codMunicipio) {
        return populationRepository.findByCodMunicipioAndAno(codMunicipio, getMostRecentYear());
    }

    @GetMapping("/population/recent/")
    public Iterable<Population> getRecentPopulationAll() {
        return StreamSupport.stream(populationRepository.findAll().spliterator(), false)
                .filter(population -> population.getAno().equals(getMostRecentYear()))
                .toList();
    }

    @GetMapping("/population/recent/year")
    public Integer getMostRecentYear() {
        if (mostRecentYear == -1) return mostRecentYear = populationRepository.getMostRecentYear();
        return mostRecentYear;
    }
}
