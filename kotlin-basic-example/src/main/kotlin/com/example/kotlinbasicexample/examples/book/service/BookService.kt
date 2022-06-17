package com.example.kotlinbasicexample.examples.book.service

import com.example.kotlinbasicexample.examples.book.domain.BookDto

interface BookService {
    fun getBooks() : List<BookDto>
    fun getBookById(id: Long) : BookDto?
}