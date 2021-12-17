package com.atguigu.mybatis_plus;

import com.atguigu.mybatis_plus.entity.User;
import com.atguigu.mybatis_plus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisPlusApplicationTests {

    @Autowired
    private UserMapper userMapper;

    // 修改
    @Test
    public void update() {
        User user = new User();
        user.setId(1471526460698140674L); // insert Long convert  Integer
        user.setName("lucy_marry");

        int count = userMapper.updateById(user);
        System.out.println(count);
    }

    // 添加
    @Test
    public void add() {
        User user = new User();
        user.setName("lucy");
        user.setAge(20);
        user.setEmail("1234@qq.com");
        int insert = userMapper.insert(user);
        System.out.println(insert); // 影响的行数
    }

    @Test
    public void findAll() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);

    }

}
