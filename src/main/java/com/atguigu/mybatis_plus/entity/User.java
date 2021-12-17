package com.atguigu.mybatis_plus.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
public class User {

    // mybatis-plus 的主键策略 使用雪花算法实现
//    @TableId(type = IdType.ASSIGN_ID)

    private Long id;
    private String name;
    private Integer age;
    private String email;

    // 自动填充字段
    @TableField(fill = FieldFill.INSERT) // 设置添加或修改时设置值
    private Date createTime; // 数据库中字段：create_time
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime; // update_time

    // 添加版本号实现乐观锁
    @Version
    @TableField(fill = FieldFill.INSERT) // 设置默认值
    private Integer version;

    // 进行逻辑删除的标识设置
    @TableLogic
    @TableField(fill = FieldFill.INSERT) // 设置默认值
    private Integer deleted;

}
