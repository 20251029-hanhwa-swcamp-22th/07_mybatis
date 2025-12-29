package com.beyond.section02.xmlconfig;

import com.beyond.section03.template.Template;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Application {

  // Mybatis 설정 파일의 경로(resources 폴더 기준)

  public static void main(String[] args) {


    // 3. SqlSessionFactory를 이용해 SqlSession 생성
    // openSession(false) : 자동 커밋이 off된 세션 얻어오기
    SqlSession sqlSession = Template.getSqlSession();

    // 4. SQL 수행 후 결과 반환 받기
    // - selectOne() : 조회 결과가 1행인 SQL을 수행 후 결과 반환 받기
    // - "mapper.selectDate" : 등록된 매퍼 중 namespace가 mapper인 xml 파일을 찾아
    //                         id가 selectDate인 SQL을 선택
    java.util.Date now = sqlSession.selectOne("mapper.selectDate");

    System.out.println("now = " + now);

    sqlSession.close();

  }
}