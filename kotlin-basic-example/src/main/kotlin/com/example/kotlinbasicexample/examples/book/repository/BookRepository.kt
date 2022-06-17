package com.example.kotlinbasicexample.examples.book.repository

import com.example.kotlinbasicexample.examples.book.domain.Book
import org.springframework.data.repository.CrudRepository

interface BookRepository : CrudRepository<Book, Long> {
}