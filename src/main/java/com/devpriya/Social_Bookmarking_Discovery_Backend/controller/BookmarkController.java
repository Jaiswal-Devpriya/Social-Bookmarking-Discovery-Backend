package com.devpriya.Social_Bookmarking_Discovery_Backend.controller;

import com.devpriya.Social_Bookmarking_Discovery_Backend.entity.Bookmark;
import com.devpriya.Social_Bookmarking_Discovery_Backend.repository.BookmarkRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookmarks")
public class BookmarkController {

    private final BookmarkRepository bookmarkRepository;

    public BookmarkController(BookmarkRepository bookmarkRepository) {
        this.bookmarkRepository = bookmarkRepository;
    }

    @GetMapping
    public List<Bookmark> getAllBookmarks() {
        return bookmarkRepository.findAll();
    }

    @PostMapping
    public Bookmark createBookmark(@RequestBody Bookmark bookmark) {
        return bookmarkRepository.save(bookmark);
    }
}