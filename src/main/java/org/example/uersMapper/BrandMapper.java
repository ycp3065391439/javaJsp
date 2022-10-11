package org.example.uersMapper;

import org.example.Brand;

import java.util.List;

public interface BrandMapper {
    public List<Brand> selectAll();
    public Brand selectById(Integer id);
}
