package com.example.test_end_01.controller;

import com.example.test_end_01.entity.pojo.Blog;
import com.example.test_end_01.entity.pojo.RestBean;
import com.example.test_end_01.entity.pojo.User;
import com.example.test_end_01.entity.vo.BlogVo;
import com.example.test_end_01.service.BlogService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/blog")
public class BlogController {
    @Resource
    BlogService blogService;

    @PostMapping("addNew")
    public RestBean<String> addNewBlog(HttpServletRequest request,
                                       @RequestParam("title") String title,
                                       @RequestParam ("content")String content
    ) {
        Blog blog=new Blog(title, (Integer) request.getAttribute("id"), new Date(), content);
        int status = blogService.addNewBlog(blog);
        if(status>0) return RestBean.success("发布成功！");
        else return RestBean.failure(503,"出现错误，请联系管理员~");
    }
    @GetMapping("getIntroduce")
    public RestBean<List<BlogVo>> getIntroduceBlog(){
        return RestBean.success("获取成功！",blogService.getBlogsOrderById());
    }
    @GetMapping ("getBlog")
    public RestBean<BlogVo> getBlog(@RequestParam("id") int id){
        return RestBean.success("成功！",blogService.getBlogById(id));
    }

}
