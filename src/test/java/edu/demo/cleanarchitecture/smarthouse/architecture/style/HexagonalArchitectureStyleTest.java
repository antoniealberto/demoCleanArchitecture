package edu.demo.cleanarchitecture.smarthouse.architecture.style;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.dependencies.SliceRule;
import com.tngtech.archunit.library.dependencies.SlicesRuleDefinition;

import static com.tngtech.archunit.core.domain.properties.HasName.Predicates.nameMatching;
import static com.tngtech.archunit.library.Architectures.onionArchitecture;

@AnalyzeClasses(packages = {
        "edu.demo.cleanarchitecture.smarthouse"
})
public class HexagonalArchitectureStyleTest {

    @ArchTest
    static final ArchRule onion_architecture_is_respected = onionArchitecture()
            .domainModels("..domain.model..")
            .domainServices("..domain.service..")
            .applicationServices("..application..")
            .adapter("config", "..framework.api.adapters.config..")
            .adapter("instrumentation", "..framework.api.adapters.instrumentation..")
            .adapter("instrumentation.web", "..framework.api.adapters.instrumentation.web..")
            .adapter("logging", "..framework.spi.adapters.logging..")
            .adapter("repository", "..framework.spi.adapters.repository..");

    @ArchTest
    SliceRule adapters_Should_Not_Depend_On_Each_Other =
            SlicesRuleDefinition.slices()
                    .matching("..framework.(**)..")
                    .should().notDependOnEachOther()
                    .ignoreDependency(nameMatching(".*repositories.*"),nameMatching(".*entities.*"));

}
