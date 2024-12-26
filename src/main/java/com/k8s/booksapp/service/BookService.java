package com.k8s.booksapp.service;

import com.k8s.booksapp.model.Book;
import com.k8s.booksapp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

//    @Cacheable(value="books", sync = true)
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Cacheable(value = "books", key = "#id")
    public Book getBookById(Long id) {
        System.out.println("Fetching product from database........" + id);
        return bookRepository.findById(id).orElse(null);
    }

    //Update Book
    @CachePut(value="books", key="#id")
    public Book updateBook(Book book) {
        Book existingBook = this.getBookById(book.getId());
        if (existingBook != null) {
            existingBook.setTitle(book.getTitle());
            existingBook.setISBN(book.getISBN());
            existingBook.setPublicationDate(book.getPublicationDate());
            existingBook.setAuthorName(book.getAuthorName());
            return bookRepository.save(existingBook);
        } else {
            return null;
        }
    }

    @CachePut(value = "books", key = "#book.id")
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    //Delete Book
    @CacheEvict(value = "books", key = "#id")
    public String deleteBook(Long id) {
        Book existingBook = this.getBookById(id);
        if (existingBook != null) {
            bookRepository.deleteById(id);
            return "Book removed !! " + id;
        } else {
            return "Book not found with id: " + id;
        }
    }
}
