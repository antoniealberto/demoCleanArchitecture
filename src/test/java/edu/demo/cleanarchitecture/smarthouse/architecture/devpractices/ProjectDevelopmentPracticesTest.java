package edu.demo.cleanarchitecture.smarthouse.architecture.devpractices;

import com.tngtech.archunit.base.DescribedPredicate;
import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchIgnore;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.dependencies.SliceRule;
import com.tngtech.archunit.library.dependencies.SlicesRuleDefinition;

import static com.tngtech.archunit.lang.conditions.ArchPredicates.are;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.fields;
import static com.tngtech.archunit.library.GeneralCodingRules.*;

@AnalyzeClasses(packages = {"edu.demo.cleanarchitecture.smarthouse"})
public class ProjectDevelopmentPracticesTest {

    @ArchTest
    ArchRule classes_should_not_throw_generic_exceptions = NO_CLASSES_SHOULD_THROW_GENERIC_EXCEPTIONS;

    @ArchTest
    ArchRule classes_should_not_use_java_util_logging = NO_CLASSES_SHOULD_USE_JAVA_UTIL_LOGGING;

    /*(that is, the System.out, System.err, and printStackTrace methods: use a logging library instead)*/
    @ArchTest
    ArchRule classes_should_not_use_standard_console_printing = NO_CLASSES_SHOULD_ACCESS_STANDARD_STREAMS;

    /*(use this when you want the team use the modern java.time API instead)*/
    @ArchTest
    ArchRule classes_should_not_use_joda_time = NO_CLASSES_SHOULD_USE_JODATIME;

    @ArchTest
    SliceRule classes_must_be_free_of_cycles = SlicesRuleDefinition.slices()
            .matching("..(**)..").should().beFreeOfCycles();

    @ArchTest
    static ArchRule util_Classes_Must_Have_Only_Private_Constructor = classes()
            .that().haveSimpleNameEndingWith("Util").or().haveSimpleNameEndingWith("Utils")
            .should()
            .haveOnlyPrivateConstructors()
            .allowEmptyShould(true);
    @ArchTest
    static ArchRule all_Classes_Must_Not_Have_Public_Fields = fields().that()
            .areDeclaredInClassesThat().areNotEnums().and().areDeclaredInClassesThat().haveNameNotMatching(".*Test")
            .should().bePrivate()
            .orShould().beProtected()
            .andShould().notBePublic();
    @ArchIgnore
    @ArchTest
    ArchRule not_unnecessarily_public = classes()
            .that().areTopLevelClasses().and(are(onlyUsedFromSamePackage()))
            .should().notBePublic();
    static DescribedPredicate<JavaClass> onlyUsedFromSamePackage() {
        return DescribedPredicate.describe("only used from same package", javaClass ->
                javaClass.getDirectDependenciesToSelf().stream().allMatch(dependency ->
                        dependency.getOriginClass().getPackage().equals(javaClass.getPackage())
                )
        );
    }

}
