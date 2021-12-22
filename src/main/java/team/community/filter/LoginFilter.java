package team.community.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author TAN00XU
 */
public class LoginFilter implements Filter {

    private static final String[] urls ={"/user/userAdd", "/registerPage", "/index.html", "/loginPage", "/login", "/MessageData.json","/captcha"};

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        System.out.println("执行登录过滤器");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //通过判断路径对资源放行
        //获取当前的请求路径
        String path = request.getServletPath();
        System.out.println(path);
        //判断当前路径是否应该被放行
        for (String url : urls) {
            if(url.equals(path) || path.startsWith("/assets/")){
                System.out.println("已放行");
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        }

        //登录验证
        Object userObject  = request.getSession().getAttribute("user");

        if (userObject != null) {
            System.out.println("已登录，放行");
            //放行
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        System.out.println("未登录，已拦截");
        System.out.println("");
        response.sendRedirect("/loginPage");

    }
}
