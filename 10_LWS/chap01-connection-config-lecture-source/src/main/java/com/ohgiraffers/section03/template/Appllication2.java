package com.ohgiraffers.section03.template;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class Appllication2 {
    public static void main(String[] args) {

        SqlSession sqlSession = Templete.getSqlSession(); //  등록된 메뉴db와 연결

        List<String> menuNameList
                = sqlSession.selectList("mapper.selectMenuNameList");

        menuNameList.forEach(System.out::println);

        sqlSession.close();


    }
}
