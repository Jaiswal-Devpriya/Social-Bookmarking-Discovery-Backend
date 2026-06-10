package com.devpriya.Social_Bookmarking_Discovery_Backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookmarks")
@Data
public class Bookmark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String url;

    private String description;

    private Long userId;

    private int score = 0;

    private LocalDateTime createdAt = LocalDateTime.now();
}