package com.example.renrenkuang.dao;

import org.apache.ibatis.annotations.*;
import com.example.renrenkuang.model.Postmessage;

import java.util.List;

public interface PostmessageDao {


    List<Postmessage> getAllPostmessage(Postmessage postmessage);

    @Delete("delete from postmessage where id = #{id}")
    int removePostmessageById(int id);

    int addPostmessage(Postmessage postmessage);

    int updatePostmessage(Postmessage postmessage);

    @Select("select * from postmessage where id =#{id}")
    Postmessage getPostmessageById(int id);

    @Select("select * from postmessage where postmessageName =#{postmessageName}")
    Postmessage getPostmessageByPostmessageName(String postmessageName);




}