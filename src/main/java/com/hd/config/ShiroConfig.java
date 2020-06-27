package com.hd.config;

import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.LinkedHashMap;

@Configuration
public class ShiroConfig {

    @Value("${spring.redis.host}")
    String host;

    @Value("${spring.redis.port}")
    int port;

    @Bean
    public RedisManager redisManager(){
        RedisManager redisManager = new RedisManager(); // crazycake 实现
        redisManager.setHost(host);
        redisManager.setPort(port);
        redisManager.setTimeout(180000);
        return redisManager;
    }

    @Bean
    public JavaUuidSessionIdGenerator sessionIdGenerator(){
        return new JavaUuidSessionIdGenerator();
    }

    @Bean
    public RedisSessionDAO sessionDAO(){
        RedisSessionDAO sessionDAO = new RedisSessionDAO(); // crazycake 实现
        sessionDAO.setRedisManager(redisManager());
        sessionDAO.setSessionIdGenerator(sessionIdGenerator()); // Session ID 生成器
        return sessionDAO;
    }

    @Bean
    public SimpleCookie cookie() {
        SimpleCookie cookie = new SimpleCookie("SHAREJSESSIONID"); // cookie的name,对应的默认是 JSESSIONID
        //cookie.setHttpOnly(true);  // 关闭浏览器cookie失效
        cookie.setMaxAge(60 * 60 * 24 * 7); // maxage正数时持久化文件存储，单位秒，到期失效；负数时内存持久化，0时删除此cookie
        cookie.setPath("/");    //  path为 / 用于多个系统共享JSESSIONID
        return cookie;
    }

    @Bean
    public DefaultWebSessionManager sessionManager(){
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setGlobalSessionTimeout(-1000L); // 设置session超时
        sessionManager.setDeleteInvalidSessions(true);  // 删除无效session
        sessionManager.setSessionIdCookie(cookie());    // 设置JSESSIONID
        sessionManager.setSessionDAO(sessionDAO());     // 设置sessionDAO
        return sessionManager;
    }

    @Bean
    public RedisCacheManager redisCacheManager(){
        RedisCacheManager cacheManager = new RedisCacheManager();   // crazycake 实现
        cacheManager.setRedisManager(redisManager());
        return cacheManager;
    }

    /**
     * 创建DefaultWebSecurityManager
     * @param userRealm
     * @return
     */
    @Bean(name="securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm")UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联realm
        securityManager.setRealm(userRealm);
        securityManager.setSessionManager(sessionManager());    // 设置sessionManager
        securityManager.setCacheManager(redisCacheManager());   // 配置缓存的话，退出登录的时候crazycake会报错，要求放在session里面的实体类必须有个id标识
        return securityManager;
    }

    /**
     * 配置LifecycleBeanPostProcessor，可以来自动的调用配置在Spring IOC容器中 Shiro Bean 的生命周期方法
     * @return
     */
    @Bean
    public static LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }

    /**
     * 启用IOC容器中使用Shiro的注解，但是必须配置LifecycleBeanPostProcessor才可以使用
     * @return
     */
    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        return new DefaultAdvisorAutoProxyCreator();
    }

    /**
     * 配置Shiro的Web过滤器，拦截浏览器请求并交给SecurityManager处理
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);

		/*
		 * 添加shiro内置过滤器:
		 * 		anon:无需认证
		 * 		authc:必须认证才可以访问
		 * 		user:如果使用remember的功能才可以访问
		 * 		perms:该资源必须得到资源权限才可以访问
		 * 		roles:该资源必须得到角色权限才可以访问
		 */
        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<String,String>();
        filterChainDefinitionMap.put("/", "anon");
        filterChainDefinitionMap.put("/css/**","anon");
        filterChainDefinitionMap.put("/js/**","anon");
        filterChainDefinitionMap.put("/img/**","anon");
        filterChainDefinitionMap.put("/register.html","anon");
        filterChainDefinitionMap.put("/public/login.html","anon");
        filterChainDefinitionMap.put("/userlogin","anon");
        filterChainDefinitionMap.put("/userlogout","anon");
        filterChainDefinitionMap.put("/error/**","anon");
        filterChainDefinitionMap.put("/findOne","anon");

        filterChainDefinitionMap.put("/pnet/importRPD","anon");
        filterChainDefinitionMap.put("/pnet","anon");

        //设置授权
        filterChainDefinitionMap.put("/user/**","roles[admin]"); // 设置用户
        filterChainDefinitionMap.put("/user/**","perms[user:query]"); // 设置权限

        filterChainDefinitionMap.put("/**","authc");

        //修改跳转页面
        shiroFilterFactoryBean.setLoginUrl("/login.html");

        //自定义授权页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/unAuth.html");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return shiroFilterFactoryBean;
    }

    /**
     * 创建realm
     * @return 用户realm
     */
    @Bean(name="userRealm")
    public UserRealm getRealm(){
        return new UserRealm();
    }
}
