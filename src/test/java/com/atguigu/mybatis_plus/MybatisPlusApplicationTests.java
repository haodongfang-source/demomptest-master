package com.atguigu.mybatis_plus;

import com.atguigu.mybatis_plus.entity.User;
import com.atguigu.mybatis_plus.mapper.UserMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class MybatisPlusApplicationTests {

    @Autowired
    private UserMapper userMapper;

    // 根据ID删除，返回影响的行数
    @Test
    public void delete(){
        int rows = userMapper.deleteById(1471742782786871297L);
        System.out.println(rows);
    }

    // 分布查询
    @Test
    public void testSelectPage() {
        Page<User> page = new Page(1, 3);
        Page<User> userPage = userMapper.selectPage(page, null);
        // 返回对象得到分页所有数据
        long pages = userPage.getPages();//总页数
        long current = userPage.getCurrent(); // 当前页
        List<User> records = userPage.getRecords(); // 查询记录的集合
        long total = userPage.getTotal(); // 获取总记录数
        boolean hasNext = userPage.hasNext(); // 下一页
        boolean hasPrevious = userPage.hasPrevious(); // 上一页


        System.out.println(pages);
        System.out.println(current);
        System.out.println(records);
        System.out.println(total);
        System.out.println(hasNext);
        System.out.println(hasPrevious);
    }

    // 简单条件查询 (了解)
    @Test
    public void testSelcet2() {

        HashMap<String, Object> columnMap = new HashMap<>();
        columnMap.put("name", "Jack");
        columnMap.put("age", 20);

        List<User> users = userMapper.selectByMap(columnMap);
        System.out.println(users);

    }

    // 多个ID的批量查询
    @Test
    public void testSelect1() {
        // 根据ID查询
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        System.out.println(users);

    }

    // 测试乐观锁
    @Test
    public void OptimisticLockerInterceptor() {
        // 根据ID查询
        User user = userMapper.selectById(1471749520579735553L);
        // 修改
        user.setName("李四");
        userMapper.updateById(user);
    }

    // 修改
    @Test
    public void update() {
        User user = new User();
        user.setId(1471742782786871297L); // insert Long convert  Integer
        user.setName("lucyupup");

        int count = userMapper.updateById(user);
        System.out.println(count);
    }

    // 添加
    @Test
    public void add() {
        User user = new User();
        user.setName("张三");
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
