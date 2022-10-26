package edu.demo.cleanarchitecture.smarthouse.architecture.uml;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.domain.PackageMatchers;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import edu.demo.cleanarchitecture.smarthouse.domain.service.HouseManagementService;
import org.junit.jupiter.api.Test;

import java.net.URL;

import static com.tngtech.archunit.core.domain.JavaClass.Functions.GET_PACKAGE_NAME;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.library.plantuml.rules.PlantUmlArchCondition.Configuration.consideringOnlyDependenciesInDiagram;
import static com.tngtech.archunit.library.plantuml.rules.PlantUmlArchCondition.adhereToPlantUmlDiagram;

public class DashboardWebControllerClassDependencyUMLTest {

    private final JavaClasses classes = new ClassFileImporter().importPackages("edu.demo.cleanarchitecture.smarthouse");
    private final URL plantUmlDiagram = DashboardWebControllerClassDependencyUMLTest.class.getResource("/edu/demo/cleanarchitecture/smarthouse/framework/api/adapters/web/dashboard_web_controller_class_dependency_diagram.puml");

    @Test
    public void classes_should_adhere_to_dashboard_web_controller_considering_only_dependencies_in_diagram() {
        classes().that().doNotBelongToAnyOf(HouseManagementService.class)
                .should(adhereToPlantUmlDiagram(plantUmlDiagram, consideringOnlyDependenciesInDiagram())
                        .ignoreDependenciesWithTarget(GET_PACKAGE_NAME.is(PackageMatchers.of("", "java.."))
                                .as("that is part of JDK"))
                )
                .check(classes);
    }
}
