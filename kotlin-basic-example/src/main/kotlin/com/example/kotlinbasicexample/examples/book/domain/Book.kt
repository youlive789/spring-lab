package com.example.kotlinbasicexample.examples.book.domain

import com.example.kotlinbasicexample.core.domain.Dto
import com.example.kotlinbasicexample.core.domain.Entity
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table(name = "BOOK")
class Book(id: Long?, name: String?, pageSize: Long?) : Entity {
    @Id
    val id: Long? = id
    var name: String? = name
    var pageSize: Long? = pageSize

    constructor() : this(null, null, null)

    override fun toDto(): BookDto {
        return BookDto(id, name, pageSize)
    }

}

data class BookDto(val id: Long?, val name: String?, val pageSize: Long?) : Dto {

    constructor() : this(null, null, null)

    override fun toEntity(): Book {
        return Book(id, name, pageSize)
    }
}