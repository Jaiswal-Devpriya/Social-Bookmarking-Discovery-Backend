package com.devpriya.Social_Bookmarking_Discovery_Backend.controller;

import com.devpriya.Social_Bookmarking_Discovery_Backend.entity.Bookmark;
import com.devpriya.Social_Bookmarking_Discovery_Backend.service.FeedService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feed")
public class FeedController {

    private final FeedService feedService;

    public FeedController(FeedService feedService) {
        this.feedService = feedService;
    }

    @GetMapping
    public List<Bookmark> getFeed(@RequestParam(required = false) String cursor) {
        return feedService.getFeed(cursor);
    }
}