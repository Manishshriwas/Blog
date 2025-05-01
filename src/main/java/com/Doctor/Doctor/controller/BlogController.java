package com.Doctor.Doctor.controller;


import com.Doctor.Doctor.model.Blog;
import com.Doctor.Doctor.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping
    public Blog create(@RequestBody Blog blog) {
        return blogService.addBlog(blog);
    }

    @GetMapping
    public List<Blog>getAll(){
        return blogService.getAllBlogs(0,10);
    }
    @GetMapping("/{id}")
    public Blog getById(@PathVariable Long id) {
        return blogService.getBlogById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public Blog update(@PathVariable Long id, @RequestBody Blog blog) {
        return blogService.updateBlog(id, blog);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        blogService.deleteBlog(id);
    }

    @PostMapping("/{id}/summarize")
    public String summarize(@PathVariable Long id) {
        Blog blog = blogService.getBlogById(id).orElseThrow();
        // Mocked summary - replace with OpenAI/spaCy REST call
        return "Summary: " + blog.getContent().substring(0, Math.min(100, blog.getContent().length())) + "...";
    }
}
