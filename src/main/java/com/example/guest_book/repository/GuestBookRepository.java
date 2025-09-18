package com.example.guest_book.repository;

import com.example.guest_book.entity.GuestBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestBookRepository extends JpaRepository<GuestBook,Integer> {
}
