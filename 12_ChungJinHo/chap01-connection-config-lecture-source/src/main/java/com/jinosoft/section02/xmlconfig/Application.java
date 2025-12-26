package com.jinosoft.section02.xmlconfig;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Application {
  // Mybatis 설정 파일의 경로(resources 폴더 기준)
  private static final String RESOURCE = "mybatis-config.xml";


  public static void main(String[] args) {
    try {
      // 1. 설정 파일 읽어올 스트림 만들기
      InputStream inputStream = Resources.getResourceAsStream(RESOURCE);
      // 2. SqlSessionFactoryBuilder를 이용해 SqlSessionFactory 생성
      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

      // 3. SqlSessionFactory를 이용해 SqlSession을 생성
      SqlSession sqlSession = sqlSessionFactory.openSession(false);

      java.util.Date now = sqlSession.selectOne("mapper.selectDate");

      System.out.println("now = " + now);

      inputStream.close();



    } catch (IOException e) {
      throw new RuntimeException(e);
    }

  }
}
