package com.Doctor.Doctor.service;


import com.Doctor.Doctor.model.Blog;
import com.Doctor.Doctor.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepo;

    public Blog addBlog(Blog blog) {
        blog.setCreatedAt(LocalDateTime.now());
        return blogRepo.save(blog);
    }

    // Get all blogs with pagination
    public List<Blog> getAllBlogs(int page, int size) {
        return blogRepo.findAll(PageRequest.of(page, size)).getContent();
    }

    // Get a single blog by ID
    public Optional<Blog> getBlogById(Long id) {
        return blogRepo.findById(id);
    }

    // Update an existing blog
    public Blog updateBlog(Long id, Blog updatedBlog) {
        return blogRepo.findById(id).map(blog -> {
            blog.setTitle(updatedBlog.getTitle());
            blog.setContent(updatedBlog.getContent());
            blog.setAuthor(updatedBlog.getAuthor());
            return blogRepo.save(blog);
        }).orElseThrow(() -> new RuntimeException("Blog not found with ID: " + id));
    }

    // Delete a blog
    public void deleteBlog(Long id) {
        if (!blogRepo.existsById(id)) {
            throw new RuntimeException("Blog not found with ID: " + id);
        }
        blogRepo.deleteById(id);
    }

    // Simple summarization logic (mocked or placeholder)
    public String generateSummary(Long blogId) {
        Blog blog = blogRepo.findById(blogId)
                .orElseThrow(() -> new RuntimeException("Blog not found with ID: " + blogId));

        String content = blog.getContent();
        int summaryLength = Math.min(100, content.length());

        return "Summary: " + content.substring(0, summaryLength) + "...";
    }
}











