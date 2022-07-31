package com.it.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Brand {

    @TableId(type= IdType.AUTO)
    private Integer id;

    @TableField(value="brand_name")
    private String brandName;

    @TableField(value="company_name")
    private String companyName;

    private Integer ordered;
    private String description;
    private Integer status;


}
