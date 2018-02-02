package cn.edots.nest.mvc.interceptor;

import cn.edots.nest.mvc.annotation.Authorization;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author ParckLee.
 * @Company wemoons.com
 * @Date 2017/8/16.
 */
public abstract class AuthorizedHandler implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Authorization authorization = getAuthorizationAnnotation(handler);
        if (authorization == null || authorization.required()) {
            return handle(request, response, handler, authorization);
        } else {
            return true;
        }
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        Authorization authorization = getAuthorizationAnnotation(handler);
        if (authorization == null || authorization.required()) {
            execute(request, response, handler, modelAndView, authorization);
        }
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) throws Exception {
        completion(request, response, handler, e, getAuthorizationAnnotation(handler));
    }

    private Authorization getAuthorizationAnnotation(Object handler) {
        Authorization authorization = null;
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            authorization = handlerMethod.getBean().getClass().getAnnotation(Authorization.class);
            Authorization methodAnnotation = handlerMethod.getMethodAnnotation(Authorization.class);
            if (methodAnnotation != null) {
                authorization = methodAnnotation;
            }
        }
        return authorization;
    }

    /**
     * 请求执行前执行
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws IOException
     */
    protected abstract boolean handle(HttpServletRequest request, HttpServletResponse response, Object handler, Authorization authorization) throws IOException;

    /**
     * 附加执行计划
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     */
    protected abstract void execute(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView, Authorization authorization);

    /**
     * 完成后
     *
     * @param request
     * @param response
     * @param handler
     * @param e
     * @param authorization
     */
    protected void completion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e, Authorization authorization) {
    }
}

