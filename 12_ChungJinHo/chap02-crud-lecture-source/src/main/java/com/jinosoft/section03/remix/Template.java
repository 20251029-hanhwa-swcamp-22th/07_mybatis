package com.jinosoft.section03.remix;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * MyBatis SqlSession을 생성하여 반환하는 유틸리티 클래스입니다.
 * <p>
 * Java Config와 XML Mapping을 혼합한 Remix 방식을 지원합니다.
 * </p>
 */
public class Template {

  private static SqlSessionFactory sqlSessionFactory = null;

  private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
  private static final String URL = "jdbc:mysql://localhost:3306/menudb";
  private static final String USERNAME = "swcamp";
  private static final String PASSWORD = "swcamp";

  /**
   * SqlSessionFactory를 통해 SqlSession을 생성하고 반환합니다.
   * <p>
   * 최초 호출 시 Configuration 객체를 생성하고 매퍼를 등록합니다.
   * </p>
   * 
   * @return 생성된 SqlSession 객체
   */
  public static SqlSession getSqlSession() {

    if (sqlSessionFactory == null) {

      try {
        // 1. 환경 설정 객체 만들기
        Environment environment = new Environment("dev", new JdbcTransactionFactory(),
            new PooledDataSource(DRIVER, URL, USERNAME, PASSWORD));

        // 2. Configuration 객체 생성 및 환경 설정 등록
        Configuration configuration = new Configuration(environment);

        // TypeAlias 등록
        configuration.getTypeAliasRegistry().registerAlias("MenuDTO", MenuDTO.class);

        // 3. Mapper 등록
        configuration.addMapper(MenuMapper.class);

        configuration.setMapUnderscoreToCamelCase(true);

        // 4. SqlSessionFactoryBuilder를 이용해 SqlSessionFactory 생성
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }

    return sqlSessionFactory.openSession(false);

  }
}
