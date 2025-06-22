package dev.shiftsad.capag.importer;

import dev.shiftsad.capag.entities.Capag;
import dev.shiftsad.capag.repositories.CapagRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class CapagImporter {

    private static final Logger log = LoggerFactory.getLogger(CapagImporter.class);
    private final CapagRepository capagRepository;

    private static final Pattern SPLIT_OUTSIDE_QUOTES =
            Pattern.compile(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

    @Value("${capag.data.path}")
    private String capagDataPath;

    public void importCapagData() throws IOException {
        Path path = Paths.get(capagDataPath);
        try (Stream<String> lines = Files.lines(path)) {
            List<Capag> lista = lines
                    .skip(1)
                    .map(CapagImporter::splitCsv)
                    .map(CapagImporter::getCapag)
                    .collect(Collectors.toList());
            capagRepository.saveAll(lista);
        }

        log.info("CAPAG data import completed successfully.");
    }

    private static List<String> splitCsv(String line) {
        return SPLIT_OUTSIDE_QUOTES
                .splitAsStream(line)
                .map(f -> f
                        .replaceAll("^\"|\"$", "")
                        .replace("\"\"", "\"")
                        .trim())
                .collect(Collectors.toList());
    }

    private static Capag getCapag(List<String> rec) {
        Capag c = new Capag();
        c.setCodigoMunicipioCompleto(rec.get(0));
        c.setNomeMunicipio(rec.get(1));
        c.setUf(rec.get(2));
        c.setCapag(rec.get(3));
        c.setIndicador1(rec.get(4));
        c.setNota1(rec.get(5));
        c.setIndicador2(rec.get(6));
        c.setNota2(rec.get(7));
        c.setIndicador3(rec.get(8));
        c.setNota3(rec.get(9));
        c.setIcf(rec.get(10));
        return c;
    }
}
