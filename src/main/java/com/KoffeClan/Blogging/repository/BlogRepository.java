package com.KoffeClan.Blogging.repository;

import com.KoffeClan.Blogging.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    List<Blog> findByAuthor(String author);
    List<Blog> findByTitleContainingIgnoreCase(String keyword);
}
