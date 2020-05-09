package com.ferao.testInterface;

import com.ferao.mapper.UserMapper;
import com.ferao.pojo.QueryVo;
import com.ferao.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

public class MybatisJunitTest {

    InputStream inputStream;
    SqlSession session;
    UserMapper mapper;
    DataSource source;
    @Before
    public void init(){
        try {
            inputStream = Resources.getResourceAsStream("mybatis/MybatisConfig.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            session = sqlSessionFactory.openSession();
            mapper = session.getMapper(UserMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @After
    public void destroy(){
        try {
            //提交事务
            session.commit();
            session.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试查询所有操作
     */
    @Test
    public void findAllTest(){
        List<User> users=mapper.findAll();
        for (User user : users){
            System.out.println(user);
        }
    }

    /**
     * 测试查询部分操作
     */
    @Test
    public void queryUserTest(){
        HashMap map = new HashMap<>();
        //map.put("id",2);
        map.put("username","丽丽");
        List<User> users=mapper.queryUser(map);
        for (User user : users){
            System.out.println(user);
        }
    }

    /**
     * 测试更新部分操作
     */
    @Test
    public void updateUsrTest(){
        HashMap map = new HashMap<>();
        map.put("id",2);
        map.put("username","莉莉");
        int i=mapper.updateUsr(map);
        System.out.println(i);

    }

    /**
     * 测试插入操作
     */
    @Test
    public void saveTest(){
        User user = new User(4,"丽丽");
        //执行保存方法
        mapper.saveUser(user);
        System.out.println("success");
        System.out.println(session);
    }
    /**
     * 测试更新操作
     */
    @Test
    public void updateTest(){
        User user = new User(1,"丽丽");
        //执行保存方法
        mapper.updateUser(user);
        System.out.println("success");
    }
    /**
     * 测试删除操作
     */
    @Test
    public void deleteTest(){
        User user = new User();
        mapper.deleteUser(4);
        System.out.println("success");
    }

    /**
     * 测试id查询操作
     */
    @Test
    public void findByIdTest(){
        User user = mapper.findById(3);
        System.out.println(user);
        System.out.println("success");
    }
    /**
     * 测试查询总记录条数
     */
    @Test
    public void testFindTotal(){
        int count= mapper.findTotal();
        System.out.println(count);
    }

    /**
     * 测试使用QueryVo作为查询条件
     */
    @Test
    public void testFindByVo(){
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUsername("%丽%");
        vo.setUser(user);
        List<User> users=mapper.findUserByVo(vo);
        for (User u : users){
            System.out.println(u);
        }
    }

    /**
     * 测试分页
     */
    @Test
    public void limtTest(){

        HashMap<String, Integer> map = new HashMap<>();
        map.put("startIndex",0);
        map.put("pageSize",3);

        List<User> userList = mapper.getUserByLimit(map);

        for (User user : userList) {
            System.out.println(user);
        }
    }


}
