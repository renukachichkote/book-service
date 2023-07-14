package com.example.bookservice.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book getBookById(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        return optionalBook.orElse(null);
    }

    public Book saveBook(Book book) {
        book.setAvailable(true);
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public Book updateBook(Long id, Book book) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book existingBook = optionalBook.get();
            if (null != book.getAuthor() && !Objects.equals(existingBook.getAuthor(), book.getAuthor())) {
                existingBook.setAuthor(book.getAuthor());
            }
            if(null != book.getTitle() && !Objects.equals(existingBook.getTitle(), book.getTitle())) {
                existingBook.setTitle(book.getTitle());
            }
            if(!Objects.equals(existingBook.isAvailable(), book.isAvailable())) {
                existingBook.setAvailable(book.isAvailable());
            }
            return bookRepository.save(existingBook);
        } else {
            return null;
        }
    }
}
