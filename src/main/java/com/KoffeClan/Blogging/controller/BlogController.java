package com.KoffeClan.Blogging.controller;

import com.KoffeClan.Blogging.entity.Blog;
import com.KoffeClan.Blogging.service.BlogService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/blogs")
@Validated
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping("/save")
    public ResponseEntity<Blog> saveBlog(@Valid @RequestBody Blog blog) {
        return ResponseEntity.ok(blogService.saveBlog(blog));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Blog>> getAllBlogs() {
        return ResponseEntity.ok(blogService.getAllBlogs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable Long id) {
        return ResponseEntity.ok(blogService.getBlogById(id));
    }

    @PostMapping("/summarize")
    public ResponseEntity<Map<String, String>> summarizeBlog(@RequestBody Map<String, String> request) {
        String content = request.get("content");
        String summary = blogService.summarizeText(content);
        return ResponseEntity.ok(Map.of("summary", summary));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, String>> handleException(RuntimeException ex) {
        return ResponseEntity.badRequest().body(Map.of("error", ex.getMessage()));
    }
}
