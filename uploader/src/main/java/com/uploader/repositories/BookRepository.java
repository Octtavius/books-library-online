package com.uploader.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uploader.data.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}
