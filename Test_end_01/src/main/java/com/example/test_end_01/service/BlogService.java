package com.example.test_end_01.service;

import com.example.test_end_01.entity.pojo.Blog;
import com.example.test_end_01.entity.vo.BlogVo;

import java.util.List;

public interface BlogService {
    int addNewBlog(Blog blog);
    List<BlogVo> getBlogsOrderById();
    BlogVo getBlogById(int id);
}
