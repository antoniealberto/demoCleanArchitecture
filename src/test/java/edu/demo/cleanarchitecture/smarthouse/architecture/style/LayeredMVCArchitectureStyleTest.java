package edu.demo.cleanarchitecture.smarthouse.architecture.style;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import edu.demo.cleanarchitecture.smarthouse.architecture.model.ApplicationLayer;
import edu.demo.cleanarchitecture.smarthouse.architecture.model.ApplicationPackages;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;
@AnalyzeClasses(packages = {
        "edu.demo.cleanarchitecture.smarthouse.framework.api.adapters"
})
public class LayeredMVCArchitectureStyleTest {

    @ArchTest
    static ArchRule layered_MVC_Architecture = layeredArchitecture().consideringAllDependencies()
                    .layer("model").definedBy("..instrumentation.web.model..")
                    .layer("view").definedBy("..instrumentation.web.view..")
                    .layer("controller").definedBy("..instrumentation.web.controller..")
                    .layer("service").definedBy("..instrumentation..")
                    .whereLayer("model").mayOnlyBeAccessedByLayers("controller")
                    .whereLayer("view").mayOnlyBeAccessedByLayers("controller")
                    .whereLayer("service").mayOnlyBeAccessedByLayers("controller");


    @ArchTest
    static ArchRule web_controllers_must_be_suffixed_in_correct_package =classes()
            .that().areAnnotatedWith(Controller.class)
            .or().areAnnotatedWith(RestController.class)
    .should().resideInAnyPackage(ApplicationPackages.CONTROLLER.getName())
    .andShould().haveSimpleNameEndingWith(ApplicationLayer.CONTROLLER.getName())
    .as("Controllers should reside in a package ${Packages.CONTROLLER}");

    @ArchTest
    static ArchRule services_should_only_be_accessed_by_controllers = classes()
            .that().resideInAPackage("..service..")
            .should().onlyBeAccessed().byAnyPackage("..controller..", "..service..")
            .allowEmptyShould(true);

}
