package com.KoffeClan.Blogging.service;

import com.KoffeClan.Blogging.entity.Blog;
import java.util.List;

public interface BlogService {
    Blog saveBlog(Blog blog);
    List<Blog> getAllBlogs();
    Blog getBlogById(Long id);
    String summarizeText(String content);
}
