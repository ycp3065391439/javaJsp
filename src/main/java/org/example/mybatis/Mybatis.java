package org.example.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.Brand;
import org.example.User;
import org.example.uersMapper.BrandMapper;
import org.example.uersMapper.UserMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Mybatis {
    private static SqlSessionFactory sqlSessionFactory;
    private static SqlSession sqlSession;
    static {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
    }

    public void selectAll() throws Exception {
        List<User> users = sqlSession.selectList("testUser.selectAll");
        System.out.println(users);
    }
    public void selectAllMapper() throws Exception {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectAll();
        System.out.println(users);
    }
    public void selectAllBrand() {
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectAll();
        System.out.println(brands);
    }
    public void selectById () {
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = mapper.selectById(7);
        System.out.println(brand);
    }
    public void selectAllBrandNoMapper() {
        List<Brand> brands = sqlSession.selectList("org.example.uersMapper.BrandMapper.selectAll");
        System.out.println(brands);
    }
}
