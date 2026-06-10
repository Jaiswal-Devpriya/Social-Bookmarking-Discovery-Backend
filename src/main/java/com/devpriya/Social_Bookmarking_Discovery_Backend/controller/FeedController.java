package com.devpriya.Social_Bookmarking_Discovery_Backend.controller;

import com.devpriya.Social_Bookmarking_Discovery_Backend.entity.Bookmark;
import com.devpriya.Social_Bookmarking_Discovery_Backend.repository.BookmarkRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/feed")
public class FeedController {

    private final BookmarkRepository bookmarkRepository;

    public FeedController(BookmarkRepository bookmarkRepository) {
        this.bookmarkRepository = bookmarkRepository;
    }

    @GetMapping
    public List<Bookmark> getFeed(@RequestParam(required = false) String cursor) {
        if (cursor == null || cursor.isEmpty()) {
            return bookmarkRepository.findTop20ByOrderByCreatedAtDesc();
        }

        LocalDateTime cursorTime = LocalDateTime.parse(cursor);
        return bookmarkRepository.findTop20ByCreatedAtBeforeOrderByCreatedAtDesc(cursorTime);
    }
}