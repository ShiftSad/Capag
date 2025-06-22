package dev.shiftsad.capag;

import dev.shiftsad.capag.importer.CapagImporter;
import dev.shiftsad.capag.importer.IbgeImporter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ImportRunner implements CommandLineRunner {

    private final IbgeImporter ibgeImporter;
    private final CapagImporter capagImporter;

    @Override
    public void run(String... args) throws Exception {
        if (args.length > 1 && "--import".equals(args[0])) {
            if ("ibge".equalsIgnoreCase(args[1])) {
                ibgeImporter.importPopulationData();
            }

            if ("capag".equalsIgnoreCase(args[1])) {
                capagImporter.importCapagData();
            }

            System.exit(0);
        }
    }
}
