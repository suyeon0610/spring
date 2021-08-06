package com.spring.basic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.basic.model.ScoreVO;
import com.spring.basic.service.IScoreService;

@Controller
@RequestMapping("/score")
public class ScoreController {

	@Autowired // service 자동 등록
	private IScoreService service;

	// 점수 등록 화면을 열어주는 처리를 하는 요청 메서드
	@GetMapping("/register")
	public String register() {
		return "/score/write-form";
	}

	// 점수 등록 요청을 처리할 메서드
	@PostMapping("/register")
	public String register(ScoreVO vo) {
		service.insertScore(vo);
		return "/score/write-result";
	}

	// 점수 전체 조회를 처리하는 요청 메서드
	@GetMapping("/list")
	public void list(Model model) {
		model.addAttribute("scores", service.selectAllScores());
	}

	// 점수 삭제 요청 처리 메서드
	@GetMapping("/delete")
	public String delete(@RequestParam("stuNum") int stuNum, RedirectAttributes ra) {
		service.deleteScore(stuNum);
		ra.addFlashAttribute("msg", "삭제가 완료되었습니다.");
		return "redirect:/score/list";
	}

	// 점수 개별 조회 화면 열람 요청 메서드
	@GetMapping("/search")
	public void search() {
	}

	// 점수 개별 조회 처리 요청 메서드
	@GetMapping("/selectOne")
	public String search(@RequestParam("stuNum") int stuNum, RedirectAttributes ra, Model model) {
		List<ScoreVO> list = service.selectAllScores();
		if (stuNum > list.size()) {
			ra.addFlashAttribute("msg", "notFound");
			return "redirect:/score/search";
		}
		model.addAttribute("stu", service.selectScore(stuNum));
		return "/score/search-result";
	}
}
