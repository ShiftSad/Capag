package dev.shiftsad.capag.importer;

import dev.shiftsad.capag.entities.Population;
import dev.shiftsad.capag.repositories.PopulationRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class IbgeImporter {

    private static final Logger log = LoggerFactory.getLogger(IbgeImporter.class);
    private final PopulationRepository populationRepository;

    @Value("${ibge.population.data.path}")
    private String ibgePopulationDataPath;

    @Value("${ibge.population.data.delimiter}")
    private String ibgePopulationDelimiter;

    @Value("${ibge.population.data.year}")
    private Integer ano;

    public void importPopulationData() throws IOException {
        ArrayList<List<String>> records = Files.readAllLines(Paths.get(ibgePopulationDataPath))
                .stream()
                .map(line -> Arrays.asList(line.split(ibgePopulationDelimiter)))
                .collect(Collectors.toCollection(ArrayList::new));

        // Remove header
        records.removeFirst();

        for (List<String> record : records) {
            if (record.size() < 3) {
                continue;
            }
            var uf = record.getFirst().trim();
            var codUf = record.get(1).trim();
            var codMunicipio = record.get(2).trim();
            var municipio = record.get(3).trim();
            var populacao = Integer.parseInt(record.get(4).trim().replace(".", ""));

            if (populationRepository.findByCodMunicipioAndAno(codMunicipio, ano) == null) {
                Population population = new Population();
                population.setCodUf(codUf);
                population.setUf(uf);
                population.setCodMunicipio(codMunicipio);
                population.setMunicipio(municipio);
                population.setPopulacao(populacao);
                population.setAno(ano);

                populationRepository.save(population);
            } else log.info("Data for municipality {} in year {} already exists, skipping.", codMunicipio, ano);
        }

        log.info("Population data import completed successfully.");
        System.exit(0);
    }
}
