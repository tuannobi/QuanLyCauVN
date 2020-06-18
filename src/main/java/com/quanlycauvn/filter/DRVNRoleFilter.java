package com.quanlycauvn.filter;

import com.quanlycauvn.model.User;
import com.quanlycauvn.util.Constant;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/user/*","/chicuc/*","/chart/*"})
public class DRVNRoleFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest) servletRequest;
        HttpServletResponse resp=(HttpServletResponse) servletResponse;

        HttpSession session=req.getSession();
        Object obj=session.getAttribute("user");
        User user=(User) obj;
        if (user !=null){
            if(user.getVaiTro().getMaVaiTro()==1){
                filterChain.doFilter(req,resp);
            }else{
                req.getRequestDispatcher(Constant.Path.urlProhibit).forward(req,resp);
            }
        }else{
            resp.sendRedirect(req.getContextPath()+"/login");
        }
    }

    @Override
    public void destroy() {

    }
}
