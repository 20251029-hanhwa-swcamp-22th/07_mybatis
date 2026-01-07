package com.kang.section03.template;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.xml.transform.Templates;
import java.io.IOException;
import java.io.InputStream;

public class Application {

    public static void main(String[] args) {

            SqlSession sqlSession = template.getSqlSession();

            java.util.Date now = sqlSession.selectOne("mapper.selectDate");

            System.out.println("now = " + now);

            sqlSession.close();

       }
    }
