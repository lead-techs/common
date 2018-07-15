package top.ibase4j.core.filter;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;
import top.ibase4j.core.Constants;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class ShiroFormAuthenticationFilter extends FormAuthenticationFilter {
    private static final Logger log = LoggerFactory.getLogger(ShiroFormAuthenticationFilter.class);

    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        System.out.println("................");
        System.out.println("http response");

        HttpServletRequest httpRequest = WebUtils.toHttp(request);
        HttpServletResponse httpResponse = WebUtils.toHttp(response);
        httpResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, PATCH, DELETE");
        httpResponse.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Origin, Access-Control-Allow-Headers, Authorization, X-Requested-With, requestId, Correlation-Id");

        if (httpRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpResponse.setHeader("Access-Control-Allow-Origin", "*");
            httpResponse.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Origin, Access-Control-Allow-Headers, Authorization, X-Requested-With, requestId, Correlation-Id");

            httpResponse.setStatus(HttpStatus.OK.value());

            return false;
        }

        return super.preHandle(request, response);
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        setLoginUrl("/cstm/login");

        if (this.isLoginRequest(request, response)) {
            System.out.println("enter login");

            if (this.isLoginSubmission(request, response)) {
                return this.executeLogin(request, response);
            } else {
                return true;
            }
        } else if (pathsMatch("/cstm/login", request) || pathsMatch("/cstm/logout", request) || pathsMatch("/cstm/regin", request)) {
            System.out.println("enter pathsMatch");

            return true;
        } else {
            this.saveRequest(request);
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse resp = (HttpServletResponse) response;
            resp.setHeader("Access-Control-Allow-Origin", req.getHeader("Origin"));
            resp.setHeader("Access-Control-Allow-Credentials", "true");
            resp.setContentType("application/json; charset=utf-8");
            resp.setCharacterEncoding("UTF-8");
            PrintWriter out = resp.getWriter();
            JSONObject result = new JSONObject();
            result.put("message", "还没有登录！");
            result.put("code", 401);
            result.put("result", false);
            out.println(result);
            out.flush();
            out.close();
            return false;
        }
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest req, ServletResponse resp, Object o) {

        System.out.println("enter is AccessAllowed");

        HttpServletRequest request = (HttpServletRequest) req;
        //获取请求路径
        if (((HttpServletRequest) req).getMethod().equals("OPTIONS")) {
            ((HttpServletResponse) resp).setHeader("Access-Control-Allow-Origin", "*");
            ((HttpServletResponse) resp).setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Origin, Access-Control-Allow-Headers, Authorization, X-Requested-With, requestId, Correlation-Id");
            ((HttpServletResponse) resp).setStatus(200);
            return true;
        }

        String path = request.getServletPath();
        // 模板 导出 导入
        if (path.contains("template") || path.contains("print") || path.contains("download")) {
            ((HttpServletResponse) resp).setStatus(200);


            return true;
        }

        //  Subject subject = getSubject(req, resp);
        //  if (null != subject.getPrincipals()) {

        // 先使用token
        // 使用token查找用户
        String token = "";
        // 先从parameter中取出，比如导出
        if (StringUtils.isNotBlank(request.getParameter("_token"))) {
            token = request.getParameter("_token");
        }

        // 再从Header中找出
        if (StringUtils.isBlank(token)) {
            token = request.getHeader("Authorization");
        }
//
//        HttpSession r = request.getSession();
//        System.out.println(r);
//        System.out.println(r);
//
//        String d = request.getSession().getId();
//        System.out.println(d);
//        System.out.println(d);


        System.out.println(".........................token .....................");
        System.out.println(token);

        // 在使用session+
        if (StringUtils.isNotBlank(token)) {
            String[] a = token.split("##");
            String clientIp = (String) request.getSession().getAttribute(Constants.USER_IP);
            try {

                System.out.println("username..." + a[0]);
                System.out.println("password..." + a[1]);
                System.out.println("clientIp..." + clientIp);


                Subject subject = SecurityUtils.getSubject();
                UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(a[0], a[1], clientIp);
                subject.login(usernamePasswordToken);
                return subject.isAuthenticated();
            } catch (Exception ex) {
                return false;
            }
        }

        return false;
    }
}