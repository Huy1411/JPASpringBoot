package com.example.jpamanytomany;

import com.example.jpamanytomany.jpa.Book;
import com.example.jpamanytomany.jpa.Publisher;
import com.example.jpamanytomany.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaManyToManyApplication implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepository;
    public static void main(String[] args) {
        SpringApplication.run(JpaManyToManyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception{
        bookRepository.save(new Book("JavaSpring1", new Publisher("NXB GD"), new Publisher("NXB HH")));
    }

}
