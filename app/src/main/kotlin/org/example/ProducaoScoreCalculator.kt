package org.example

import org.optaplanner.core.api.score.buildin.simple.SimpleScore
import org.optaplanner.core.api.score.calculator.EasyScoreCalculator

class ProducaoScoreCalculator : EasyScoreCalculator<SolucaoProducao, SimpleScore> {
    override fun calculateScore(solucao: SolucaoProducao): SimpleScore {
        var penalidade = 0

        // Exemplo de lógica de penalidade
        for ((i, produto) in solucao.produtos.withIndex()) {
            if (produto.sequencia != i + 1) {
                penalidade += 1
            }
        }

        return SimpleScore.of(-penalidade)
    }
}

