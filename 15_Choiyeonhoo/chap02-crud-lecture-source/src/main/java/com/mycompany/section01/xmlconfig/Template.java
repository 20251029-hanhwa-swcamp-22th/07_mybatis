package com.mycompany.section01.xmlconfig;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/* SqlSessionFactory 객체를 하나만 만들어서 계속 재사용
* --> Singleton 패턴
* */

public class Template {

  private static SqlSessionFactory sqlSessionFactory;
  private static final String RESOURCE = "com/mycompany/section01/xmlconfig/mybatis-config.xml";

  /* mybatis-config.xml 설정이 적용된 SqlSession 생성 메서드
  * - SqlSession : MyBatis의 DB 연결 및 SQL 수행 객체
  * */
  public static SqlSession getSqlSession(){
    if (sqlSessionFactory == null) {
      try {
        InputStream inputStream = Resources.getResourceAsStream(RESOURCE);

        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
    return sqlSessionFactory.openSession(false);
  }

}
