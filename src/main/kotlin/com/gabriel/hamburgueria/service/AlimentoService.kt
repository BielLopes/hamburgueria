package com.gabriel.hamburgueria.service

import org.springframework.stereotype.Service

import com.gabriel.hamburgueria.domain.Alimento
import com.gabriel.hamburgueria.controller.dto.AlimentoDto
import com.gabriel.hamburgueria.repository.AlimentoRepository
import com.gabriel.hamburgueria.repository.model.AlimentoEntity

@Service
class AlimentoService(
    private val alimentoRepository: AlimentoRepository
) {

    fun salvar(alimentoDto: AlimentoDto): Alimento {
        val alimento = alimentoDto.toDomain()
        return alimentoRepository.save(AlimentoEntity.toEntity(alimento)).toDomain()
    }

    fun buscarTodos(): List<Alimento> {
        return alimentoRepository.findAll().map{ it.toDomain() }
    }

    fun buscarComFiltro(pesquisa: String): Alimento {
        val id = pesquisa.toLongOrNull()
        val alimentoEntity = if (id == null) {
            alimentoRepository.findByNome(pesquisa)
        } else {
            alimentoRepository.findById(id).orElseThrow()
        }
        return alimentoEntity.toDomain()
    }

    fun deletar(id: Long) {
        alimentoRepository.deleteById(id)
    }

    fun atualizar(id: Long, alimentoDto: AlimentoDto): Alimento? {
        val alimento = alimentoDto.toDomain().copy(id = id)
        return alimentoRepository.save(AlimentoEntity.toEntity(alimento)).toDomain()
    }
}