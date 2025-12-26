package com.ohgiraffers.section02.xmlconfig;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Application {

    // mybatis 설정 파일의 경로 (resource 폴더 기준)
    private static final String RECOURCE = "mybatis-config.xml";

    public static void main(String[] args) {


            try {
                // 1. 설정 파일 읽어올 스트림 만들기
                InputStream inputStream = Resources.getResourceAsStream(RECOURCE);

                // 2. SQLSessionFactoryBuilder를 이용해 SQLSessionFactory 생성
                SqlSessionFactory sqlSessionFactory
                        = new SqlSessionFactoryBuilder().build(inputStream);


                // 3. SQLSessionFactory를 이용해 sqlSessioon 생성
                // openSQLSession(false) : 자동커밋이 off된 세션 얻어오기
                SqlSession sqlSession = sqlSessionFactory.openSession(false);

                // 4. SQL 수행후 결과를 반환 받기
                // - selectOne() :  조회 결과가 1행인 SQL 을 수행후 결봐 받기
                // - "mapper.selectDate" : 등록된 매퍼 중 namespace가 mapper인 xml 파일을 찾아
                //                  id가 "selectDate"인 SQL을 선택
                java.util.Date now = sqlSession.selectOne("mapper.selectDate");

                System.out.println("now = " + now);

                sqlSession.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
}
