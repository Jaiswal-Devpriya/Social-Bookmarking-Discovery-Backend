package com.devpriya.Social_Bookmarking_Discovery_Backend.repository;

import com.devpriya.Social_Bookmarking_Discovery_Backend.entity.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {

    List<Bookmark> findTop20ByCreatedAtBeforeOrderByCreatedAtDesc(LocalDateTime cursor);

    List<Bookmark> findTop20ByOrderByCreatedAtDesc();
}