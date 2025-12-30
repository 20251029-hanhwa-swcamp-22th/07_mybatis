package com.ohgiraffers.section03.template;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/* S1lSessionFactory 객체를 하나만 만들어서 계속 재사용
*   --> Singleton 패턴
* 객체가
* */

public class Templete {

    private static SqlSessionFactory sqlSessionFactory = null;

    private static final String RECOURCE = "mybatis-config.xml";

    public static SqlSession getSqlSession() {
        if (sqlSessionFactory == null) {
            try {
                // 1. 설정 파일 읽어올 스트림 만들기
                InputStream inputStream = Resources.getResourceAsStream(RECOURCE);

                // 2. SQLSessionFactoryBuilder를 이용해 SQLSessionFactory 생성
                sqlSessionFactory // 읽어온 설정으로 만든 패키지를 필드에 넣는것
                        = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return  sqlSessionFactory.openSession(false);
    }
}
