package com.example.test_end_01.service.Impl;

import com.example.test_end_01.entity.pojo.Blog;
import com.example.test_end_01.entity.vo.BlogVo;
import com.example.test_end_01.mapper.BlogMapper;
import com.example.test_end_01.mapper.UserMapper;
import com.example.test_end_01.service.BlogService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Resource
    BlogMapper blogMapper;
    @Resource
    UserMapper userMapper;
    @Override
    public int addNewBlog(Blog blog) {
        return blogMapper.insertNewBlog(blog);
    }

    @Override
    public List<BlogVo> getBlogsOrderById() {
        List<BlogVo> result=new ArrayList<BlogVo>();
        for(Blog blog : blogMapper.getBlogsOrderById()){
            result.add((new BlogVo(blog,userMapper.getUsernameById(blog.getAuthorId()),userMapper.getAvatorById(blog.getAuthorId()))));
        }
        return result;
    }

    @Override
    public BlogVo getBlogById(int id) {
        blogMapper.updateWatchesById(id);
        Blog blog=blogMapper.getBlogById(id);
        return new BlogVo(blogMapper.getBlogById(id),userMapper.getUsernameById(blog.getAuthorId()),userMapper.getAvatorById(blog.getAuthorId()));
    }

}
