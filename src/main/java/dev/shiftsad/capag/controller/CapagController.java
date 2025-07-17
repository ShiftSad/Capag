package dev.shiftsad.capag.controller;

import dev.shiftsad.capag.dto.MunicipioDataRequest;
import dev.shiftsad.capag.entities.Capag;
import dev.shiftsad.capag.repositories.CapagRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@RestController
public class CapagController {

    private final CapagRepository capagRepository;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @Cacheable("searchCapag")
    @CrossOrigin(origins = "*")
    @GetMapping("/capag")
    public Flux<Capag> searchCapag(@ModelAttribute Capag probe) {
        ExampleMatcher matcher = ExampleMatcher
                .matchingAll()
                .withIgnoreNullValues()
                .withIgnoreCase();

        Example<Capag> example = Example.of(probe, matcher);
        return Flux.fromIterable(capagRepository.findAll(example));
    }

    @Cacheable("batchCapag")
    @PostMapping("/capag/batch")
    @CrossOrigin(origins = "*")
    public Mono<Map<String, Capag>> getBatchCapag(@RequestBody List<MunicipioDataRequest> requests) {
        return Mono.fromCallable(() -> {
            List<String> municipios = requests.stream().map(MunicipioDataRequest::getMunicipio).toList();
            List<String> ufs = requests.stream().map(MunicipioDataRequest::getUf).toList();

            List<Capag> capags = capagRepository.findByNomeMunicipioInAndUfIn(municipios, ufs);

            Map<String, Capag> responseMap = new HashMap<>();
            for (Capag capag : capags) {
                String key = capag.getNomeMunicipio() + "-" + capag.getUf();
                responseMap.put(key, capag);
            }
            return responseMap;
        });
    }
}
