package net.yakovlev.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.yakovlev.model.Users;
import net.yakovlev.util.DBUtils;
import net.yakovlev.util.MyUtils;

@WebFilter(filterName = "cookieFilter", urlPatterns = { "/*" })
public class CookieFilter implements Filter {
	
	public CookieFilter() {
    }

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		
		Users userInSession = MyUtils.getLoginedUser(session);
		
		 if (userInSession != null) {
	            session.setAttribute("COOKIE_CHECKED", "CHECKED");
	            chain.doFilter(request, response);
	            return;
	        }
		// Connection создан в JDBCFilter.
	        Connection conn = MyUtils.getStoredConnection(request);
	        
	     // Флаг(flag) для проверки Cookie.
	        String checked = (String) session.getAttribute("COOKIE_CHECKED");
	        if (checked == null && conn != null) {
	            String username = MyUtils.getUserNameInCookie(req);
	            try {
	                Users user = DBUtils.findUser(conn, username);
	                MyUtils.storeLoginedUser(session, user);
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	            // Отметить проверенные Cookie.
	            session.setAttribute("COOKIE_CHECKED", "CHECKED");
	        }
	 
	        chain.doFilter(request, response);	
	}
}
