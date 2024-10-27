// package com.gabriel.hamburgueria.repository

// import org.springframework.stereotype.Component

// import com.gabriel.hamburgueria.domain.Alimento
// import com.gabriel.hamburgueria.controller.dto.AlimentoDto
// import com.gabriel.hamburgueria.exception.AlimentoNotFoundException

// class AlimentoRepositoryInMemory : AlimentoRepository {
//     private val alimentoList: MutableList<Alimento>
//     private var index: Long = 0

//     init {
//         alimentoList = ArrayList()
//     }

//     override fun save(alimento: Alimento): Alimento {
//         index++
//         alimento.id = index
//         alimentoList.add(alimento)
//         return alimento
//     }

//     override fun findAll(): List<Alimento> {
//         return alimentoList
//     }

//     override fun findByNome(nome: String): Alimento {
//         try {
//             return alimentoList.first{it.nome == nome}
//         } catch (e: NoSuchElementException) {
//             throw AlimentoNotFoundException("Alimento não encontrado com nome: $nome")
//         }
//     }

//     override fun findById(id: Long): Alimento {
//         try {
//             return alimentoList.first{it.id == id}
//         } catch (e: NoSuchElementException) {
//             throw AlimentoNotFoundException("Alimento não encontrado com id: $id")
//         }
//     }

//     override fun delete(id: Long) {
//         alimentoList.removeIf{it.id == id}
//     }

//     override fun update(id: Long, alimentoDto: AlimentoDto): Alimento? {
//         var alimentoUpdated: Alimento? = null
//         alimentoList.forEachIndexed { index, alimento ->
//             if (alimento.id == id) {
//                 alimentoList[index] = alimento.copy(
//                     nome = alimentoDto.nome!!,
//                     preco = alimentoDto.preco!!,
//                     descricao = alimentoDto.descricao!!,
//                     categoria = alimentoDto.categoria!!
//                 )
//                 alimentoUpdated = alimentoList[index]
//             }
//         }
//         return alimentoUpdated
//     }
// }