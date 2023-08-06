package hello.login.web.filter;


import hello.login.web.SessionConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.PatternMatchUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Slf4j
public class LoginCheckFilter implements Filter {

    private static final String[] whiteList = {"/", "/members/add", "/login", "/logout", "/css/*"};

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        String requestURI = httpRequest.getRequestURI();

        HttpServletResponse httpResponse = (HttpServletResponse)response;
        //요기까지가 준비이다.

        try{
            log.info("인증체크 필터 시작{}", requestURI);

            if (isLoginCheckPath(requestURI)) {
                log.info("인증 체크 로직 실행 {}", requestURI);
                //인증체크를 하려면 일단 세션을 뒤져야한다.
                HttpSession session = httpRequest.getSession(false);
                if (session == null || session.getAttribute(SessionConst.LOGIN_MEMBER) == null) {
                    log.info("미인증 사용자 요청 {}", requestURI);
                    //로그인으로 redirect
                    //redirectURL을 포함한 이유는 로그인 했을때 다시 그 페이지로 갈 수 있게 해주기 위해서다.
                    httpResponse.sendRedirect("/login?redirectURL=" + requestURI);
                    return;

                }
            }
            //체크해야할 필터가 아니면 다음필터로 넘어가기
            chain.doFilter(request, response);

        }catch(Exception e){
            throw e; //예외 로깅 가능 하지만, 톰켓까지 예외를 보내주어야 함
        }finally {
            log.info("인증 체크 필터 종료 {}", requestURI);

        }
    }

    /**
     * 화이트 리스트의 경우 인증 체크X
     */
    private boolean isLoginCheckPath(String requestURL) {
        return !PatternMatchUtils.simpleMatch(whiteList, requestURL);
    }

}
