package com.spring.basic.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.basic.model.UserVO;

//자동으로 스프링 컨테이너에 해당 클래스의 빈을 등록하는 아노테이션
//빈을 등록 해 놔야 HendlerMapping이 이  클래스의 객체를 검색할 수 있음
@Controller
@RequestMapping("/request")
public class RequestController {
	
	public RequestController() {
		System.out.println("RequestCon 생성!");
	}
	
	@RequestMapping("/test")
	public String testCall() {
		System.out.println("/request/test 요청이 들어옴");
		return "test";
	}
	
	@RequestMapping("/req")
	public String req() {
		System.out.println("/request/req 요청이 들어옴");
		return "request/req-ex01";
	}
	
	@RequestMapping(value="/request/basic01", method=RequestMethod.GET)
	public String basicGet() {
		System.out.println("/request/basic01 GET 요청이 들어옴");
		return "request/req-ex01";
	}
	
	@RequestMapping(value="/request/basic01", method=RequestMethod.POST)
	public String basicPost() {
		System.out.println("/request/basic01  POST 요청이 들어옴");
		return "request/req-ex01";
	}

	//화면을 띄울 메서드부터 작성
	/*
	@GetMapping("/join")
	public String register() {
		System.out.println("/request/join: GET");
		return "request/join";
	}
	*/
	
	//컨트롤 내의 메서드의 타입을 void로 선언하면
	//요청이 들어온 URI값을 뷰 리졸버에게 전달함
	@GetMapping("/join")
	public void register() {
		System.out.println("/request/join: GET");
	}
	
	//요청 URI 주소가 같더라도, 전송 방식에 따라 맵핑을 다르게 진행하기 때문에
	//같은 주소를 사용하는 것이 가능
	
	/*
	 1. 전통적인 jsp/servlet 방식의 파라미터 읽기 처리 방법.
	 - HTttpServletRequest 객치 활용. (jsp에서 활용하던 방식)
	 */
	
	/*
	@PostMapping("/join")
	public void register(HttpServletRequest request) {
		System.out.println("/request/join: POST");
		
		System.out.println("ID: " + request.getParameter("userId"));
		System.out.println("PW: " + request.getParameter("userPw"));
		System.out.println("HOBBY: " + Arrays.toString(request.getParameterValues("hobby")));
	}
	*/
	
	/*
	 2. @RequestParam 아노테이션을 이용한 요청 파라미터 처리
	 	@RequestParam("파라미터 변수명") 값을 받아서 처리할 변수
	 */
	
	/*
	@PostMapping("/join")
	public void register(@RequestParam("userId") String id,
						 @RequestParam("userPw") String pw,
						 @RequestParam(value="hobby", required = false, defaultValue = "no hobby") List<String> hobbys){
		
		System.out.println("ID: " + id);
		System.out.println("PW: " + pw);
		System.out.println("HOBBY: " + hobbys);
	}
	*/
	
	/*
	 3. 커맨드 객체를 활용한 파라미터 처리.
	 파라미터 데이터와 연동되는 VO 클래스가 필요함
	 */
	@PostMapping("/join")
	public void register(UserVO user) {
		System.out.println(user.toString());
	}
	//=======================================================================
	
	@GetMapping("/quiz")
	public String quiz() {
		System.out.println("/request/quiz: GET");
		return "request/req-quiz";
	}
	
	@PostMapping("/quiz")
	public String quiz(@RequestParam("id") String id,
					   @RequestParam("pw") String pw) {
		
		System.out.println("/request/quiz: POST");
		
		if(id.equals("abcd1234") && pw.equals("aaa1111")) {
			return "request/login-success";
		} else {			
			return "request/login-fail";
		}
	}
}
