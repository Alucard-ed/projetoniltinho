package org.example

import org.optaplanner.core.api.domain.solution.PlanningSolution
import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider
import org.optaplanner.core.api.score.buildin.simple.SimpleScore

@PlanningSolution
data class SolucaoProducao(
    @PlanningEntityCollectionProperty val produtos: List<Produto>
) {
    @ValueRangeProvider(id = "sequenciaRange")
    fun getSequenciaRange(): List<Int> = (1..produtos.size).toList()

    @PlanningScore
    var score: SimpleScore? = null
}
