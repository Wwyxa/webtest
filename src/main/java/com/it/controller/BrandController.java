package com.it.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.it.entity.Brand;
import com.it.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.Map;

import static com.it.controller.Code.*;

@RestController
@RequestMapping("/brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    /**
     * 添加
     * @param brand
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Brand brand){
        Integer flag = brandService.add(brand);
        String msg;
        if(flag>0)msg="添加成功";
        else msg="添加失败";
        return new Result(flag>0?Code.SAVE_OK:Code.SAVE_ERR,flag,msg);
    }

    /**
     * 更新
     * @param brand
     * @return
     */
    @PutMapping
    public Result update(@RequestBody Brand brand){
        Integer flag = brandService.update(brand);
        String msg;
        if(flag>0)msg="更新成功";
        else msg="更新失败";
        return new Result(flag>0?Code.UPDATE_OK: UPDATE_ERR,flag,msg);
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    @DeleteMapping
    public Result deleteByIds(@RequestBody Integer[] ids){
        Integer flag = brandService.deleteByIds(ids);
        String msg;
        if(flag>0)msg="删除成功";
        else msg="删除失败";
        return new Result(flag>0? DELETE_OK: DELETE_ERR,flag,msg);
    }

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        Integer flag = brandService.deleteById(id);
        String msg;
        if(flag>0)msg="删除成功";
        else msg="删除失败";
        return new Result(flag>0? DELETE_OK: DELETE_ERR,flag,msg);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id){
        Brand brand = brandService.selectById(id);
        return new Result(brand!=null? GET_OK: GET_ERR,brand);
    }

    /**
     * 分页模糊查询
     * @param current
     * @param size
     * @param status
     * @param brandName
     * @param companyName
     * @return
     */
    @GetMapping
    public Result selectByPage(@RequestParam(defaultValue = "1") Integer current,
                               @RequestParam(defaultValue = "5") Integer size,
                               @RequestParam(defaultValue = "") Integer status,
                               @RequestParam(defaultValue = "") String brandName,
                               @RequestParam(defaultValue = "") String companyName){
        IPage<Brand> page = brandService.selectByPage(current, size, status,brandName,companyName);
        //System.out.println(page.getRecords());
        Map map=new HashMap<>();
        map.put("data",page.getRecords());
        map.put("totalCount",page.getTotal());
        return new Result(page!=null? GET_OK: GET_ERR,map);
    }
}
