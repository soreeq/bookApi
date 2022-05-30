package com.example.demo;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookApi {

    private List<Book> bookList;

    public BookApi() {
        this.bookList = new ArrayList<>();
    }

    @ApiOperation(value = "Znajdz ksiazke po IBAN", notes = "znajduje ksiazke po numerze iban")
    @GetMapping("/{iban}")
    public Book getBooks(@PathVariable int iban){
        return bookList.stream()
                .filter(book -> book.getIBAN() == iban).findFirst().get();
    }

    @ApiOperation(value = "Znajdz ksiazke po tytule", notes = "znajduje ksiazke po tytule")
    @GetMapping("/{title}")
    public Book getBooks(@PathVariable String title){
        return bookList.stream()
                .filter(book -> book.getTitle() == title).findFirst().get();
    }

    @ApiOperation(value = "Zwraca liste ksiazek", notes = "Wszystkie ksiazki")
    @GetMapping List<Book> getBooks() {
        return bookList;
    }

    @ApiOperation(value = "Dodaje ksiazke", notes = "dodawanie ksiazki")
    @PostMapping
    public boolean addBook(@PathVariable Book book ) {
        return bookList.add(book);
    }
}
