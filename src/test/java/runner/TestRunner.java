package runner;

import org.junit.platform.suite.api.*;

import static io.cucumber.core.options.Constants.*;


@Suite
@IncludeEngines("cucumber") // объясняем Suite что это cucumber и мы будем запускать feature файл, передаем cucumber
@ConfigurationParameters({
        //@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@all"),
        @ConfigurationParameter(key = FEATURES_PROPERTY_NAME, value = "src/test/resources/Feature"),
        @ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "org.ibs.steps"),
        @ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm, pretty")
})

public class TestRunner {
}
