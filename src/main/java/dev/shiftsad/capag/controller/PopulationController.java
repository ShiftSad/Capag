package dev.shiftsad.capag.controller;

import dev.shiftsad.capag.entities.Population;
import dev.shiftsad.capag.repositories.PopulationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PopulationController {

    private final PopulationRepository populationRepository;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

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

    @CrossOrigin(origins = "*")
    @GetMapping("/population/recent/year")
    public Integer mostRecentYear() {
        return populationRepository.getMostRecentYear();
    }
}
