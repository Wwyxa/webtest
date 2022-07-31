package com.it.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.dao.BrandDao;
import com.it.entity.Brand;
import com.it.service.BrandService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandDao brandDao;

    @Override
    public Integer add(Brand brand) {
        return brandDao.insert(brand);
    }

    @Override
    public Integer update(Brand brand) {
        return brandDao.updateById(brand);
    }

    @Override
    public Integer deleteById(Integer id) {
        return brandDao.deleteById(id);
    }

    @Override
    public Integer deleteByIds(Integer[] ids) {
        return brandDao.deleteBatchIds(Arrays.asList(ids));
    }

    @Override
    public Brand selectById(Integer id) {
        return brandDao.selectById(id);
    }

    @Override
    public IPage<Brand> selectByPage(Integer current, Integer size,Integer status,String brandName,String companyName) {
        IPage page=new Page(current,size);

        //QueryWrapper<Brand> wrapper=new QueryWrapper<Brand>();
        //wrapper.eq("status",status)
        //        .like("brand_name",brandName)
        //        .like("company_name",companyName);

        LambdaQueryWrapper<Brand> wrapper =new LambdaQueryWrapper<Brand>();
        wrapper.eq(null!=status,Brand::getStatus,status)
                .like(Brand::getBrandName,brandName)
                .like(Brand::getCompanyName,companyName);
        return brandDao.selectPage(page,wrapper);
    }


    //private Boolean isNullOrEmpty(Object obj){
    //    if (obj == null || "".equals(obj)){
    //        return true;
    //    }
    //    return false;
    //}
}
