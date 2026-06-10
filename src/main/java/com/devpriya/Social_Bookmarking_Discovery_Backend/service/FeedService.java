package com.devpriya.Social_Bookmarking_Discovery_Backend.service;

import com.devpriya.Social_Bookmarking_Discovery_Backend.entity.Bookmark;
import com.devpriya.Social_Bookmarking_Discovery_Backend.repository.BookmarkRepository;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class FeedService {

    private final BookmarkRepository bookmarkRepository;
    private final RedisTemplate<String, Object> redisTemplate;

    public FeedService(BookmarkRepository bookmarkRepository,
                       RedisTemplate<String, Object> redisTemplate) {
        this.bookmarkRepository = bookmarkRepository;
        this.redisTemplate = redisTemplate;
    }

    public List<Bookmark> getFeed(String cursor) {
        String cacheKey = "feed:global:" + (cursor == null ? "latest" : cursor);

        Object cachedFeed = redisTemplate.opsForValue().get(cacheKey);

        if (cachedFeed != null) {
            return (List<Bookmark>) cachedFeed;
        }

        List<Bookmark> feed;

        if (cursor == null || cursor.isEmpty()) {
            feed = bookmarkRepository.findTop20ByOrderByCreatedAtDesc();
        } else {
            LocalDateTime cursorTime = LocalDateTime.parse(cursor);
            feed = bookmarkRepository.findTop20ByCreatedAtBeforeOrderByCreatedAtDesc(cursorTime);
        }

        redisTemplate.opsForValue().set(cacheKey, feed, Duration.ofMinutes(1));

        return feed;
    }
}