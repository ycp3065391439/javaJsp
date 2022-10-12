package org.example.uersMapper;

import org.apache.ibatis.annotations.Param;
import org.example.Brand;

import java.util.List;

public interface BrandMapper {
    public List<Brand> selectAll();

    public Brand selectById(Integer id);

    public List<Brand> selectByCondition(Brand brand);

    public List<Brand> selectByCondition(@Param("status") Integer status,
                                         @Param("companyName") String companyName,
                                         @Param("brandName") String brandName);
    public List<Brand> selectOneChose (Brand brand);
    public void insert (Brand brand);
    public int updateBrand(Brand brand);
    public void delectOneBrand(int id);
    public void delectSomeBrand(int[] ids);
}
