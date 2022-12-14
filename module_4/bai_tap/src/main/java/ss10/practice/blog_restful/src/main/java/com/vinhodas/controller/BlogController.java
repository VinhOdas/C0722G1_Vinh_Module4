package com.vinhodas.controller;

import com.vinhodas.dto.BlogDto;
import com.vinhodas.model.Blog;
import com.vinhodas.service.IBlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    IBlogService blogService;

    @GetMapping
    public ResponseEntity<List<BlogDto>> getBlogList() {
        List<Blog> blogDtos = blogService.findAll();
        if (blogDtos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<BlogDto> blogDtoList = new ArrayList<>();

        for (Blog x : blogDtos) {
            BlogDto blogDto = new BlogDto();
            BeanUtils.copyProperties(x, blogDto);
            blogDtoList.add(blogDto);
        }
        return new ResponseEntity<>(blogDtoList, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Void> create(@RequestBody BlogDto blogDto) {
        Blog blog = new Blog();
        BeanUtils.copyProperties(blogDto, blog);
        blogService.save(blog);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping("/search")
    public ResponseEntity<List<BlogDto>> searchList(@RequestParam String searchName) {
        List<Blog> blogDtos = blogService.findbyName(searchName);
        if (blogDtos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<BlogDto> blogDtoList = new ArrayList<>();

        for (Blog x : blogDtos) {
            BlogDto blogDto = new BlogDto();
            BeanUtils.copyProperties(x, blogDto);
            blogDtoList.add(blogDto);
        }
        return new ResponseEntity<>(blogDtoList, HttpStatus.OK);
    }


}
