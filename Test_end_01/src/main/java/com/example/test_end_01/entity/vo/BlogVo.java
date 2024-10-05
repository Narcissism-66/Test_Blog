package com.example.test_end_01.entity.vo;

import com.example.test_end_01.entity.pojo.Blog;
import lombok.Data;

@Data
public class BlogVo {
    private Blog blog;
    private String username, avator;
    public BlogVo(Blog blog, String username, String avator) {
        this.blog = blog;
        this.username = username;
        this.avator = avator;
    }
}
