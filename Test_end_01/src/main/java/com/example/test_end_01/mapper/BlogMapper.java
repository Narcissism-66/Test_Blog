package com.example.test_end_01.mapper;

import com.example.test_end_01.entity.pojo.Blog;
import com.example.test_end_01.entity.vo.BlogVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BlogMapper {
    @Insert("INSERT INTO test_blog(title,authorId,updateDate,content) VALUES(#{title},#{authorId},#{updateDate},#{content})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int insertNewBlog(Blog blog);

    @Select("SELECT id,title,authorId,substring(content,1,200) AS content FROM test_blog ORDER BY id DESC LIMIT 50")
    List<Blog> getBlogsOrderById();

    @Select("SELECT * FROM test_blog WHERE id=#{id}")
    Blog getBlogById(int id);

    @Update("UPDATE test_blog SET watches=watches+1 WHERE id=#{id}")
    int updateWatchesById(int id);
}
