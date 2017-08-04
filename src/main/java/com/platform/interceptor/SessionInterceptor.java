package com.platform.interceptor;

import com.platform.base.SysConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * SpringMVC拦截器实现类
 * @author
 *
 */
public class SessionInterceptor extends HandlerInterceptorAdapter {

    private static final Logger log = LoggerFactory.getLogger(SessionInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String url = request.getRequestURI();

        HttpSession session = request.getSession();
        log.debug(url);

        if (url.indexOf("logon") > -1 && session.getAttribute(SysConst.SESSION_USER_NAME) == null) {

            // 未登陆
            response.setContentType("application/json;charset=UTF-8");
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);

            try {
                response.getWriter().write("-1001");
                response.getWriter().flush();
                response.getWriter().close();
            } catch (IOException e) {
            }

            return false;
        }


        return super.preHandle(request, response, handler);
    }
}
