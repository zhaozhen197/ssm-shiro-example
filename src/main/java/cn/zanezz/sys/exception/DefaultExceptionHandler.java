package cn.zanezz.sys.exception;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @auther TyCoding
 * @date 2018/9/5
 */
@ControllerAdvice
public class DefaultExceptionHandler implements HandlerExceptionResolver {

    /**
     * 权限校验失败异常
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler({UnauthorizedException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ModelAndView processUnauthenticatedException(NativeWebRequest request, UnauthorizedException e) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("exception", e);
        mv.setViewName("unauthorized");
        return mv;
    }

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        if(e instanceof UnauthorizedException ) {
            //如果是未授权所抛出的异常，统一跳转到为未授权页面
            return new ModelAndView("redirect:/unauthorized.jsp");
        }
//        如果是其他类型的错误，跳转到error.jsp
        return new ModelAndView("redirect:/error.jsp");
    }

}
