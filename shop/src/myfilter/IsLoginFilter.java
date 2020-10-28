package myfilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IsLoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) arg0;
		HttpServletResponse resp = (HttpServletResponse) arg1;

		String nowUrl = req.getRequestURI();

		if (nowUrl.contains("login") || nowUrl.contains(".css") || nowUrl.contains(".js") || nowUrl.contains(".gif")
				|| nowUrl.contains(".png") || nowUrl.contains(".jpg")) {
			arg2.doFilter(arg0, arg1);

		} else {
			Boolean isLogin = null;
			isLogin = (Boolean) req.getSession().getAttribute("isLogin");
			if (isLogin == null || !isLogin) {
				resp.sendRedirect(req.getContextPath() + "/login.jsp");
			} else {
				arg2.doFilter(arg0, arg1);
			}
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
