package org.acme.vehiclerouting.domain;

import ai.timefold.solver.core.api.domain.entity.PlanningEntity;
import ai.timefold.solver.core.api.domain.variable.InverseRelationShadowVariable;

import java.time.LocalDateTime;

@PlanningEntity
public interface Standstill {
    @InverseRelationShadowVariable(sourceVariableName = "previousVisit")
    public Visit getNextVisit();

    public void setNextVisit(Visit visit);

    LocalDateTime getDepartureTime();

    Location getLocation();
}
