package com.example

import org.optaplanner.core.api.solver.SolverFactory
import org.optaplanner.core.api.solver.Solver

fun main() {
    // Carregar a configuração do OptaPlanner
    val solverFactory: SolverFactory<MyPlanningSolution> = SolverFactory.createFromXmlResource("solverConfig.xml")
    val solver: Solver<MyPlanningSolution> = solverFactory.buildSolver()

    // Definir a solução inicial e resolver
    val solution = MyPlanningSolution()  // Aqui você precisa definir sua classe de solução de planejamento
    val solvedSolution = solver.solve(solution)

    println("Solução encontrada: $solvedSolution")
}


import org.optaplanner.core.api.solver.SolverFactory

fun main() {
    val solverFactory = SolverFactory.createFromXmlResource<SolucaoProducao>("solverConfig.xml")
    val solver = solverFactory.buildSolver()

    val produtos = listOf(
        Produto(1, "Produto 1"),
        Produto(2, "Produto 2"),
        Produto(3, "Produto 3"),
        Produto(4, "Produto 4"),
        Produto(5, "Produto 5")
    )

    val solucaoInicial = SolucaoProducao(produtos)
    val solucaoFinal = solver.solve(solucaoInicial)

    println("Sequência de produção:")
    solucaoFinal.produtos.sortedBy { it.sequencia }.forEach { produto ->
        println("${produto.sequencia}: ${produto.nome}")
    }
}
