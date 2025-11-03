package api_rest.ejecuciones;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features/obtener_empleados.feature")
@ConfigurationParameter(key = "cucumber.glue", value = "api_rest/pasos_definidos")

@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "io.cucumber.core.plugin.SerenityReporterParallel,pretty,timeline:build/test- results/timeline")

public class ApiRunnerTags {

}
