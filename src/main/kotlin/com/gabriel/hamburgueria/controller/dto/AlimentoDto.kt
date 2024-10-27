package com.gabriel.hamburgueria.controller.dto

import java.math.BigDecimal

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import jakarta.validation.constraints.Min

import com.gabriel.hamburgueria.domain.Alimento

class AlimentoDto (
    @field:NotBlank(message = "Nome é obrigatório")
    @field:Size(min = 3, max = 20, message = "Nome deve ter entre 3 e 20 caracteres")
    val nome: String? = null,
    @field:NotNull(message = "Preço é obrigatório")
    @field:Min(value = 0, message = "Preço deve ser maior que 0")
    val preco: BigDecimal? = null,
    val descricao: String? = null,
    @field:NotBlank(message = "Categoria é obrigatório")
    @field:Size(max = 20, message = "Categoria deve ter no máximo 20 caracteres")
    val categoria: String? = null
) {
    fun toDomain(): Alimento {
        return Alimento(
            id = null,
            nome = nome!!,
            preco = preco!!,
            descricao = descricao!!,
            categoria = categoria!!
        )
    }
}