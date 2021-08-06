package com.spring.basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.basic.model.BoardVO;
import com.spring.basic.service.IBoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private IBoardService service;

	@GetMapping("/write")
	public void write() {
		System.out.println("/board/write: GET");
	}

	// �ۼ��� �� ��� ó�� ��û
	// �޼��� �̸��� write() �Դϴ�.
	// �ۼ��� ���� DB�� ��� �� /board/list.jsp���Ϸ� ������ �� �ֵ���
	// (�� ��� �����޶�� ��û�� �ڵ����� ���� �� �ֵ���) ������ ó���� ������.

	@PostMapping("/write")
	public String write(BoardVO vo) {
		service.insertArticle(vo);
		return "redirect:/board/list";
	}

	// �� ��� ȭ�� ��û
	// �޼��� �̸� -> list()
	// DB ��� ����Ʈ���� ������ �� �� ����� list.jsp ���Ϸ� �����ؼ�
	// �������� �� ����� ��� �ֽø� �ǰڽ��ϴ�.
	// �� ����� table�� ����ؼ� ������ ����� �ּ���. (�� ��ȣ�� �ε��� �̿��ؼ� �޾��ּ���.)
	
	@GetMapping("/list")
	public void list(Model model) {
		System.out.println("/board/list: GET");
		model.addAttribute("articles", service.getArticles());
	}

	// �� ���� �󼼺��� ��û ó�� �޼���
	// �޼��� �̸� -> content, ��û url -> /content
	// DB ������ �ϴ� ����Ʈ���� �� ��ȣ�� �ش��ϴ� �� ��ü�� content.jsp�� �����ּ���.
	// content.jsp���� �ش� �� ������ ��� ����� �ּ���.
	
	@GetMapping("/content")
	public void content(@ModelAttribute("bId") int bId, Model model) {
		System.out.println("/board/content: GET");
		model.addAttribute("article", service.getArticle(bId));
	}
	
	//modify.jsp�� form�±׿� ó�� ���� ��Ƽ
	@GetMapping("/modify")
	public void modify(@ModelAttribute("bId") int bId, Model model) {
		System.out.println("/board/modify: GET");
		model.addAttribute("article", service.getArticle(bId));
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO vo, @RequestParam("bId") int bId) {
		
		System.out.println("/board/modify: POST");
		
		service.updateArticle(vo, bId);
		
		return "redirect:/board/content?bId=" + bId;
		
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("bId") int bId,RedirectAttributes ra) {
		
		System.out.println("/board/delete: GET");
		
		service.deleteArticle(bId);
		ra.addFlashAttribute("msg", "delete");
		
		return "redirect:/board/list";
		
	}
	
	
}
