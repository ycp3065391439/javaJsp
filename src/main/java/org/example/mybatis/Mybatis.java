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
    public void selectByCondition() {
        Brand sqlBrand = new Brand();
        sqlBrand.setStatus(null);
        sqlBrand.setBrandName("%华为%");
        sqlBrand.setCompanyName("%华为%");
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectByCondition(sqlBrand);
        List<Brand> brands1 = mapper.selectByCondition(sqlBrand.getStatus(), sqlBrand.getCompanyName(), sqlBrand.getBrandName());
        List<Brand> brands2 = mapper.selectOneChose(sqlBrand);
        System.out.println(brands2);
    }
    public void insertBrand() throws Exception {
        Brand insertBrand = new Brand();
        insertBrand.setBrandName("小米");
        insertBrand.setCompanyName("小米有限公司");
        insertBrand.setStatus(1);
        insertBrand.setOrdered(111);
        insertBrand.setDescription("发烧");
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.insert(insertBrand);
        System.out.println(insertBrand.getId());
        sqlSession.commit();
        this.selectAllBrand();
    }
    public void updateBrand() {
        Brand updateBrand = new Brand();
        updateBrand.setId(11);
        updateBrand.setDescription("草");
        updateBrand.setOrdered(111);
        updateBrand.setBrandName("苹果");
        updateBrand.setStatus(1);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        int i = mapper.updateBrand(updateBrand);
        System.out.println(i);
        selectAllBrand();
        sqlSession.commit();
    }
    public void delectBrand() {
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.delectOneBrand(11);
        sqlSession.commit();
    }
    public void delectSomeBrand() {
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.delectSomeBrand(new int[]{13,14,15});
        sqlSession.commit();
    }
}
