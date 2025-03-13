package com.KoffeClan.Blogging.service;

import com.KoffeClan.Blogging.entity.Blog;
import com.KoffeClan.Blogging.repository.BlogRepository;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Map;

@Service
public class BlogServiceImpl implements BlogService {

    private final RestTemplate restTemplate;
    private final BlogRepository blogRepository;

    public BlogServiceImpl(BlogRepository blogRepository) {
        this.restTemplate = new RestTemplate();
        this.blogRepository = blogRepository;
    }

    @Override
    public Blog saveBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    @Override
    public Blog getBlogById(Long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Blog not found with ID: " + id));
    }

    @Override
    public String summarizeText(String content) {
        String pythonServiceUrl = "http://127.0.0.1:5000/summarize";
        Map<String, String> requestBody = Map.of("content", content);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map<String, String>> request = new HttpEntity<>(requestBody, headers);

        try {
            ResponseEntity<Map> response = restTemplate.postForEntity(pythonServiceUrl, request, Map.class);
            return response.getBody().get("summary").toString();
        } catch (Exception e) {
            return "Summarization service is unavailable. Please try again later.";
        }
    }
}
