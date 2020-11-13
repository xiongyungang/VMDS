import com.hd.dao.RoleMapper;
import com.hd.dao.UserMapper;
import com.hd.entity.Auth;
import com.hd.entity.Role;
import com.hd.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestDao {
    @Resource
    RoleMapper roleMapper;

    @Resource
    UserMapper userMapper;

    @Test
    public void test1(){
        List<Auth> auths = roleMapper.listAuth();
        System.out.println("auths = " + auths);
    }

    @Test
    public void test2(){
        Role roleById = roleMapper.getRoleById(1);
        System.out.println("roleById = " + roleById);
    }

    @Test
    public void testUser() {
        List<Map> welcome = userMapper.welcome();
        System.out.println("welcome = " + welcome);
        //List<User> list = userMapper.list();
        //System.out.println("list = " + list);
    }
}
