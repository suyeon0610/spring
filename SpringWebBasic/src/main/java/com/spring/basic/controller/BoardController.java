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

	// 작성된 글 등록 처리 요청
	// 메서드 이름은 write() 입니다.
	// 작성된 글을 DB에 등록 후 /board/list.jsp파일로 응답할 수 있도록
	// (글 목록 보여달라는 요청이 자동으로 들어올 수 있도록) 적절히 처리해 보세요.

	@PostMapping("/write")
	public String write(BoardVO vo) {
		service.insertArticle(vo);
		return "redirect:/board/list";
	}

	// 글 목록 화면 요청
	// 메서드 이름 -> list()
	// DB 대용 리스트에서 가지고 온 글 목록을 list.jsp 파일로 전달해서
	// 브라우저에 글 목록을 띄워 주시면 되겠습니다.
	// 글 목록을 table을 사용해서 간단히 만들어 주세요. (글 번호는 인덱스 이용해서 달아주세요.)
	
	@GetMapping("/list")
	public void list(Model model) {
		System.out.println("/board/list: GET");
		model.addAttribute("articles", service.getArticles());
	}

	// 글 내용 상세보기 요청 처리 메서드
	// 메서드 이름 -> content, 요청 url -> /content
	// DB 역할을 하는 리스트에서 글 번호에 해당하는 글 객체를 content.jsp로 보내주세요.
	// content.jsp에서 해당 글 정보를 모두 출력해 주세요.
	
	@GetMapping("/content")
	public void content(@ModelAttribute("bId") int bId, Model model) {
		System.out.println("/board/content: GET");
		model.addAttribute("article", service.getArticle(bId));
	}
	
	//modify.jsp의 form태그에 처음 내용 배티
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
