package com.gabriel.hamburgueria.domain

import java.math.BigDecimal

data class Alimento(
    var id: Long?,
    val nome: String,
    val preco: BigDecimal,
    val descricao: String?,
    val categoria: String
)