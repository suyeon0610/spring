package com.spring.mvc.board.commons.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import com.spring.mvc.user.model.UserVO;
import com.spring.mvc.user.service.IUserService;

public class AutoLoginInterceptor extends HandlerInterceptorAdapter{
	
	private IUserService service;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("자동 로그인 인터셉터 발동!");
		
		//1. 자동 로그인 쿠키가 있는지의 여부 확인
		//-> loginCookie의 존재 여부 확인 (loginCookie에 세션 아이디 저장되어 있음)
		//원하는 쿠키의 값을 한번에 꺼내올 수 있음.(request객체, 쿠키이름)
		Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
		
		HttpSession session = request.getSession();
		if(loginCookie != null) { //자동 로그인을 이전에 신청한 유저라면
			
			//2. DB에서 쿠키값(세션id)과 일치하는 세션아이디를 가진 회원의 정보 조회.
			UserVO vo = service.getUserWithSessionId(loginCookie.getValue());
			System.out.println("쿠키의 값: " + loginCookie.getValue());
			System.out.println("DB에서 가지고 온 값: " + vo);
			if(vo != null) {
				//자동 로그인 신청한 사람의 로그인 데이터(세션)를 만들어 줌.
				session.setAttribute("login", vo);
			}
			
		}
		
		//true이면 컨트롤러로 요청이 들어가고, false면 요청 막음
		//true를 쓴 이유는 자동 로그인 신청 여부와 상관없이 홈 화면은 누구나 봐야하기 때문
		return true;
	}
	
}
