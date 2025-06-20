package dev.shiftsad.capag;

import dev.shiftsad.capag.importer.IbgeImporter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ImportRunner implements CommandLineRunner {

    private final IbgeImporter ibgeImporter;

    @Override
    public void run(String... args) throws Exception {
        if (args.length > 0 && "--import".equals(args[0])) {
            if (args.length > 1 && "ibge".equalsIgnoreCase(args[1])) {
                ibgeImporter.importPopulationData();
            }


        }
    }
}
