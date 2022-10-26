package edu.demo.cleanarchitecture.smarthouse.architecture.style;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@AnalyzeClasses(packages = {
        "edu.demo.cleanarchitecture.smarthouse.framework.spi.adapters.repository"
})
public class LayeredDAOArchitectureStyleTest {

    @ArchTest
    static ArchRule layered_DAO_Architecture = layeredArchitecture().consideringAllDependencies()
                    .layer("entity").definedBy("..db.entities..")
                    .layer("dao").definedBy("..db.repositories..")
                    .layer("service").definedBy("..")

                    .whereLayer("entity").mayOnlyBeAccessedByLayers("dao", "service")
                    .whereLayer("dao").mayOnlyBeAccessedByLayers("service");

    @ArchTest
    static ArchRule entities_must_be_suffixed_in_correct_package =
            classes()
                    .that().areAnnotatedWith(Entity.class)
                    .should().resideInAPackage("..db.entities..")
                    .andShould().haveSimpleNameEndingWith("Entity");

    @ArchTest
    static ArchRule repositories_must_be_suffixed_in_correct_package =
            classes()
                    .that().areAnnotatedWith(Repository.class)
                    .should().resideInAPackage("..db.repositories..")
                    .andShould().haveSimpleNameEndingWith("Repository");

}
