package com.gabriel.hamburgueria.repository

import org.springframework.data.jpa.repository.JpaRepository

import com.gabriel.hamburgueria.repository.model.AlimentoEntity

interface AlimentoRepository: JpaRepository<AlimentoEntity, Long> {

    fun findByNome(nome: String): AlimentoEntity

}