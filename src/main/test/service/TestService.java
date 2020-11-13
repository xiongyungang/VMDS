package service;

import com.hd.entity.Auth;
import com.hd.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml", "classpath:springMVC.xml"})
public class TestService {
    @Autowired
    private RoleService roleService;

    @Test
    public void testAuth(){
        List<Auth> auths = roleService.listAuth();
        System.out.println("auths = " + auths);
    }
}
