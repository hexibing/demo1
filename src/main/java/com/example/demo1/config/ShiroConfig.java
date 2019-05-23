package com.example.demo1.config;

import com.example.demo1.shiro.ManagerRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.MemorySessionDAO;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 **
 * shiro配置类
 * ApacheShiro核心通过Filter来实现权限控制和拦截 , 就好像SpringMVC通过DispachServlet来主控制请求分发一样 .
 * 既然是使用Filter , 即是通过URL规则来进行过滤和权限校验 , 所以我们需要定义一系列关于URL的规则和访问权限
 */
@Configuration
public class ShiroConfig {

    /**
     * DefaultAdvisorAutoProxyCreator , Spring的一个bean , 由Advisor决定对哪些类的方法进行AOP代理 .
     */
    @Bean
    @ConditionalOnMissingBean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAAP = new DefaultAdvisorAutoProxyCreator();
        defaultAAP.setProxyTargetClass(true);
        return defaultAAP;
    }

    //region Cookie及Session
    // ==================== Cookie及Session管理 begin ====================
    private static final String COOKIE_NAME = "rememberMe";
    /** cookie对象管理 */
    public SimpleCookie rememberMeCookie(){
        //这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
        SimpleCookie simpleCookie = new SimpleCookie(COOKIE_NAME);
        simpleCookie.setMaxAge(604800);//记住我cookie生效时间7天 ,单位秒
        return simpleCookie;
    }
    /** cookie管理对象 : 记住我功能 */
    public CookieRememberMeManager rememberMeManager(){
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        cookieRememberMeManager.setCipherKey(Base64.decode("3AvVhmFLUs0KTA3Kprsdag=="));//rememberMe cookie加密的密钥 建议每个项目都不一样 默认AES算法 密钥长度(128 256 512 位)
        return cookieRememberMeManager;
    }

    @Bean
    SessionDAO sessionDAO() {
        return new MemorySessionDAO();
    }




    /**
     * HashedCredentialsMatcher , 这个类是为了对密码进行编码的 ,
     * 防止密码在数据库里明码保存 , 当然在登陆认证的时候 ,
     * 这个类也负责对form里输入的密码进行编码
     * 处理认证匹配处理器：如果自定义需要实现继承HashedCredentialsMatcher
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        //md5加密1次
        hashedCredentialsMatcher.setHashAlgorithmName("SHA-256");
        hashedCredentialsMatcher.setHashIterations(1);
        return hashedCredentialsMatcher;
    }

    /**
     * 自定义realm
     *
     * @return
     */
    @Bean
    public ManagerRealm userRealm() {
        ManagerRealm userRealm = new ManagerRealm();
        userRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return userRealm;
    }

    /**
     * 安全管理器
     * 注：使用shiro-spring-boot-starter 1.4时，返回类型是SecurityManager会报错，直接引用shiro-spring则不报错
     *
     * @return
     */
    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm());
        return securityManager;
    }




    /**
     * AuthorizationAttributeSourceAdvisor , shiro里实现的Advisor类 ,
     * 内部使用AopAllianceAnnotationsAuthorizingMethodInterceptor来拦截用以下注解的方法 .
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager());
        return advisor;
    }

//    //thymeleaf模板引擎和shiro整合时使用
//    @Bean
//    public ShiroDialect shiroDialect() {
//        return new ShiroDialect();
//    }


        /**
         * ShiroFilterFactoryBean : 为了生成ShiroFilter , 处理拦截资源文件问题 .
         * 它主要保持了三项数据 , securityManager , filters , filterChainDefinitionManager .
         * 注意 : 单独一个ShiroFilterFactoryBean配置是或报错的 , 因为在初始化ShiroFilterFactoryBean的时候需要注入：SecurityManager
         *
         * FilterChain定义说明
         * 1 . 一个URL可以配置多个Filter , 使用逗号分隔
         * 2 . 当设置多个过滤器时 , 全部验证通过 , 才视为通过
         * 3 . 部分过滤器可指定参数 , 如perms , roles
         *
         */
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("/manager/login.do");
//        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setSuccessUrl("/");
        shiroFilterFactoryBean.setUnauthorizedUrl("/manager/noauth");
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauth");

        //注意此处使用的是LinkedHashMap，是有顺序的，shiro会按从上到下的顺序匹配验证，匹配了就不再继续验证
        //所以上面的url要苛刻，宽松的url要放在下面，尤其是"/**"要放到最下面，如果放前面的话其后的验证规则就没作用了。
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("/", "anon");
        filterChainDefinitionMap.put("/manager/login.do", "anon");
        filterChainDefinitionMap.put("/manager/logout.do", "anon");

//        filterChainDefinitionMap.put("/manager/logout.do", "logout");

        filterChainDefinitionMap.put("/user/**", "authc,roles[ROLE_USER]");//用户为ROLE_USER 角色可以访问 . 由用户角色控制用户行为 .
        filterChainDefinitionMap.put("/events/**", "authc,roles[ROLE_ADMIN]");
        //        filterChainDefinitionMap.put("/user/edit/**", "authc,perms[user:edit]");// 这里为了测试 , 固定写死的值 , 也可以从数据库或其他配置中读取 , 此处是用权限控制


        filterChainDefinitionMap.put("/manager/mocLogin.do", "anon");
        filterChainDefinitionMap.put("/captcha.jpg", "anon");
        filterChainDefinitionMap.put("/favicon.ico", "anon");
        filterChainDefinitionMap.put("/**", "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }



}
