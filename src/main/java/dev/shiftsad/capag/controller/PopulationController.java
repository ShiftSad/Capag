package dev.shiftsad.capag.controller;

import dev.shiftsad.capag.dto.MunicipioDataRequest;
import dev.shiftsad.capag.entities.Population;
import dev.shiftsad.capag.repositories.PopulationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class PopulationController {

    private final PopulationRepository populationRepository;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @Cacheable("searchPopulation")
    @CrossOrigin(origins = "*")
    @GetMapping("/population")
    public Iterable<Population> search(@ModelAttribute Population probe) {
        ExampleMatcher matcher = ExampleMatcher
                .matchingAll()
                .withIgnoreNullValues()
                .withIgnoreCase();

        Example<Population> example = Example.of(probe, matcher);
        return populationRepository.findAll(example);
    }

    @Cacheable("batchPopulation")
    @PostMapping("/population/batch")
    @CrossOrigin(origins = "*")
    public Map<String, Population> getBatchPopulation(@RequestBody List<MunicipioDataRequest> requests) {
        List<Integer> anos = requests.stream().map(MunicipioDataRequest::getAno).toList();
        List<String> municipios = requests.stream().map(MunicipioDataRequest::getMunicipio).toList();
        List<String> ufs = requests.stream().map(MunicipioDataRequest::getUf).toList();

        List<Population> populations = populationRepository.findByAnoInAndMunicipioInAndUfIn(anos, municipios, ufs);

        Map<String, Population> responseMap = new HashMap<>();
        for (Population population : populations) {
            String key = population.getMunicipio() + "-" + population.getUf();
            responseMap.put(key, population);
        }

        return responseMap;
    }

    @Cacheable("populationByYear")
    @CrossOrigin(origins = "*")
    @GetMapping("/population/recent/year")
    public Integer mostRecentYear() {
        return populationRepository.getMostRecentYear();
    }
}
