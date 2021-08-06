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

//�ڵ����� ������ �����̳ʿ� �ش� Ŭ������ ���� ����ϴ� �Ƴ����̼�
//���� ��� �� ���� HendlerMapping�� ��  Ŭ������ ��ü�� �˻��� �� ����
@Controller
@RequestMapping("/request")
public class RequestController {
	
	public RequestController() {
		System.out.println("RequestCon ����!");
	}
	
	@RequestMapping("/test")
	public String testCall() {
		System.out.println("/request/test ��û�� ����");
		return "test";
	}
	
	@RequestMapping("/req")
	public String req() {
		System.out.println("/request/req ��û�� ����");
		return "request/req-ex01";
	}
	
	@RequestMapping(value="/request/basic01", method=RequestMethod.GET)
	public String basicGet() {
		System.out.println("/request/basic01 GET ��û�� ����");
		return "request/req-ex01";
	}
	
	@RequestMapping(value="/request/basic01", method=RequestMethod.POST)
	public String basicPost() {
		System.out.println("/request/basic01  POST ��û�� ����");
		return "request/req-ex01";
	}

	//ȭ���� ��� �޼������ �ۼ�
	/*
	@GetMapping("/join")
	public String register() {
		System.out.println("/request/join: GET");
		return "request/join";
	}
	*/
	
	//��Ʈ�� ���� �޼����� Ÿ���� void�� �����ϸ�
	//��û�� ���� URI���� �� ���������� ������
	@GetMapping("/join")
	public void register() {
		System.out.println("/request/join: GET");
	}
	
	//��û URI �ּҰ� ������, ���� ��Ŀ� ���� ������ �ٸ��� �����ϱ� ������
	//���� �ּҸ� ����ϴ� ���� ����
	
	/*
	 1. �������� jsp/servlet ����� �Ķ���� �б� ó�� ���.
	 - HTttpServletRequest ��ġ Ȱ��. (jsp���� Ȱ���ϴ� ���)
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
	 2. @RequestParam �Ƴ����̼��� �̿��� ��û �Ķ���� ó��
	 	@RequestParam("�Ķ���� ������") ���� �޾Ƽ� ó���� ����
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
	 3. Ŀ�ǵ� ��ü�� Ȱ���� �Ķ���� ó��.
	 �Ķ���� �����Ϳ� �����Ǵ� VO Ŭ������ �ʿ���
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
