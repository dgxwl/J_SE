package mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/*
 * mybatis使用demo
*/
public class MyBatisDemo {

    public static void main(String[] args) {
        try (InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml")) {
            //对应一个数据连接, 用来创建sqlSession的工厂(应为单例), 线程安全
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //执行操作的对象, 用完需要关闭
            SqlSession sqlSession = sqlSessionFactory.openSession();

            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> list = mapper.list();
            System.out.println("查询结果:");
            System.out.println(list);

            sqlSession.commit();
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
