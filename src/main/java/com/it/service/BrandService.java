package com.it.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.entity.Brand;
import org.apache.catalina.User;


public interface BrandService {

    public Integer add(Brand brand);
    public Integer update(Brand brand);
    public Integer deleteById(Integer id);
    public Integer deleteByIds(Integer[] ids);
    public Brand selectById(Integer id);
    public IPage<Brand>  selectByPage(Integer current, Integer size,Integer status,String brandName,String companyName);

}
