package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * @author Ivan Ustinov(ivanustinov1985@yandex.ru)
 * @version 1.0
 * @since 11.09.2018
 */
@WebFilter(urlPatterns = {"/*"},
        initParams = {
                @WebInitParam(name = "encoding", value = "UTF-8")})
public class UnicodeFilter implements Filter {
    private String code;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter");
        code = filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String codeRequest = response.getCharacterEncoding();
        System.out.println(codeRequest);
        if (!code.equalsIgnoreCase(codeRequest)) {
            response.setCharacterEncoding(code);
        }
        System.out.println(response.getCharacterEncoding());
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        code = null;
    }
}
