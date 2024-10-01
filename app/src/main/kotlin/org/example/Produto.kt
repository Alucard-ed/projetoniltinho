import org.optaplanner.core.api.domain.entity.PlanningEntity
import org.optaplanner.core.api.domain.variable.PlanningVariable

@PlanningEntity
data class Produto(
    val id: Long,
    val nome: String
) {
    @PlanningVariable(valueRangeProviderRefs = ["sequenciaRange"])
    var sequencia: Int? = null
}
