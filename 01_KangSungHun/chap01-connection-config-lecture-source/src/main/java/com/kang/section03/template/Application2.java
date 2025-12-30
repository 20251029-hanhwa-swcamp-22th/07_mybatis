package com.kang.section03.template;

import org.apache.ibatis.session.SqlSession;

import java.time.temporal.Temporal;
import java.util.List;

public class Application2 {
    public static void main(String[] args) {

        SqlSession sqlSession = template.getSqlSession();

        List<String> menuNameList
                = sqlSession.selectList("mapper.selectMenuNameList");

        menuNameList.forEach(System.out::println);

        sqlSession.close();

    }

}
