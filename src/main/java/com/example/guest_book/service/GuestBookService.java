package com.example.guest_book.service;

import com.example.guest_book.entity.GuestBook;
import com.example.guest_book.repository.GuestBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GuestBookService {
    private final GuestBookRepository guestBookRepository;

    public List<GuestBook> listBooks() throws DataAccessException {
        List<GuestBook> bookList = guestBookRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        return bookList;
    }

    public void addPost(GuestBook guestBook) throws DataAccessException {
        guestBookRepository.save(guestBook);
    }
}
