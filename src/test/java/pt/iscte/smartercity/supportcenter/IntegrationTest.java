package pt.iscte.smartercity.supportcenter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.boot.test.context.SpringBootTest;
import pt.iscte.smartercity.supportcenter.SmarterCitySupportCenterApp;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = SmarterCitySupportCenterApp.class)
public @interface IntegrationTest {
}
