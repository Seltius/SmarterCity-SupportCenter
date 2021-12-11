package pt.iscte.smartercity.supportcenter;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("pt.iscte.smartercity.supportcenter");

        noClasses()
            .that()
            .resideInAnyPackage("pt.iscte.smartercity.supportcenter.service..")
            .or()
            .resideInAnyPackage("pt.iscte.smartercity.supportcenter.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..pt.iscte.smartercity.supportcenter.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
