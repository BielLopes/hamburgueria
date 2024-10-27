package com.gabriel.hamburgueria.repository.model

import java.math.BigDecimal

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType

import com.gabriel.hamburgueria.domain.Alimento

@Entity(name = "alimento")
data class AlimentoEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,
    val nome: String,
    val preco: BigDecimal,
    val descricao: String?,
    val categoria: String
) {
    fun toDomain(): Alimento {
        return Alimento(
            id = id,
            nome = nome,
            descricao = descricao,
            preco = preco,
            categoria = categoria
        )
    }
    
    companion object{ // Clouse para métodos estáticos
        fun toEntity(alimento: Alimento): AlimentoEntity{
            return AlimentoEntity(
                id = alimento.id,
                nome = alimento.nome,
                descricao = alimento.descricao,
                preco = alimento.preco,
                categoria = alimento.categoria
            )
        }
    }
}