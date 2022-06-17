package com.example.kotlinbasicexample.examples.book

import com.example.kotlinbasicexample.examples.book.domain.BookDto
import com.example.kotlinbasicexample.examples.book.service.BookService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/books")
class BookController(val bookService: BookService) {

    @GetMapping
    fun books(): List<BookDto> {
        return bookService.getBooks();
    }

    @GetMapping("/{id}")
    fun findBook(@PathVariable("id") id: Long): BookDto? {
        return bookService.getBookById(id)
    }
}