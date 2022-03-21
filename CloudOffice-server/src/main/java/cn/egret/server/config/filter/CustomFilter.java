package cn.egret.server.config.filter;

import cn.egret.server.pojo.Menu;
import cn.egret.server.pojo.Role;
import cn.egret.server.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * 权限控制
 * 根据请求url分析出请求所需  角色
 *
 * @author egret
 */
@Component
public class CustomFilter implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private IMenuService menuService;

    AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        //获取请求的url
        String requestUrl = ((FilterInvocation)o).getRequestUrl();
        //System.out.println("requestUrl = " + requestUrl);
        //获取菜单
        List<Menu> menus = menuService.getMenusWithRole();
        //System.out.println("menus = " + menus);
        for (Menu menu : menus) {
            //判断请求的url与菜单角色是否匹配
            if (antPathMatcher.match(menu.getUrl(),requestUrl)){
                //System.out.println("menu = " + menu.getUrl());
                // 获取当前访问这个菜单需要的角色权限是哪些， 注意那个Role::getName，获得的都是Role_manager这些东西
                String[] str = menu.getRoles().stream().map(Role::getName).toArray(String[]::new);
                for(String s : str){
                    System.out.println("stritem:" + s);
                }
                // 装载权限列表
                return SecurityConfig.createList(str);
            }
        }
        //没匹配的url默认为登录即可访问
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
