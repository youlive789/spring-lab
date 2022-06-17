package com.example.kotlinbasicexample.examples.book.service

import com.example.kotlinbasicexample.examples.book.domain.BookDto
import com.example.kotlinbasicexample.examples.book.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookServiceImpl(val bookRepository: BookRepository) : BookService {
    override fun getBooks(): List<BookDto> {
        return bookRepository.findAll().map {book -> book.toDto()};
    }

    override fun getBookById(id: Long): BookDto? {
        return bookRepository.findById(id).map { book -> book.toDto() }.orElseGet {BookDto()};
    }
}