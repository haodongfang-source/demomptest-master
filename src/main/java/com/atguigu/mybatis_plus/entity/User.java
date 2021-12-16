package com.atguigu.mybatis_plus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class User {

    // mybatis-plus 的主键策略 使用雪花算法实现
    @TableId(type = IdType.ASSIGN_ID)

    private Long id;
    private String name;
    private Integer age;
    private String email;

}
