package org.acme.vehiclerouting.solver;

import ai.timefold.solver.benchmark.api.PlannerBenchmarkFactory;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.acme.vehiclerouting.domain.VehicleRoutePlan;
import org.acme.vehiclerouting.rest.VehicleRouteDemoResource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;

@QuarkusTest
@EnabledIfSystemProperty(named = "slowly", matches = "true")
public class BenchmarkTest {
    @Inject
    PlannerBenchmarkFactory benchmarkFactory;

    @Test
    public void benchmark() {
        VehicleRoutePlan plan = new VehicleRouteDemoResource().generate(VehicleRouteDemoResource.DemoData.FIRENZE);
        benchmarkFactory.buildPlannerBenchmark(plan).benchmarkAndShowReportInBrowser();
    }
}
