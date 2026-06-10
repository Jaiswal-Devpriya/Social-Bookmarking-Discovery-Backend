package com.devpriya.Social_Bookmarking_Discovery_Backend.repository;

import com.devpriya.Social_Bookmarking_Discovery_Backend.entity.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
}