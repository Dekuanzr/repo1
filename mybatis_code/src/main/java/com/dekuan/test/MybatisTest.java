package com.dekuan.test;

import com.dekuan.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest {

    /*
    mybatis快速入门测试
     */
    @Test
    public void mybatisQuickStart() throws IOException {
        // 1.加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        // 2.获取sqlSessionFactory工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        // 3.获取sqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 4.执行sql
        List<User> users = sqlSession.selectList("userMapper.findAll");
        // 5.打印结果
        for (User user:users){
            System.out.println(user);
        }
        // 6.释放资源
        sqlSession.close();
    }
    /*
    添加用户
     */
    @Test
    public void testSave() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        User user=new User();
        user.setUsername("lx1");
        user.setBirthday(new Date());
        user.setSex("女");
        user.setAddress("景德镇");

        sqlSession.insert("userMapper.saveUser",user);

//        sqlSession.commit();
        sqlSession.close();
    }

    /*
    更新用户
     */
    @Test
    public void testUpdate() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user=new User();
        user.setId(2);
        user.setUsername("lx");
        user.setBirthday(new Date());
        user.setSex("女");
        user.setAddress("江西九江");

        sqlSession.update("userMapper.updateUser",user);

        sqlSession.commit();
        sqlSession.close();
    }
    /*
   删除用户
    */
    @Test
    public void testDelete() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        sqlSession.delete("userMapper.deleteUser",10);

        sqlSession.commit();
        sqlSession.close();
    }
}
