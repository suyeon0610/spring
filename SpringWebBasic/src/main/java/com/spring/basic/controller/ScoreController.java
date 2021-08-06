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

	@Autowired // service �ڵ� ���
	private IScoreService service;

	// ���� ��� ȭ���� �����ִ� ó���� �ϴ� ��û �޼���
	@GetMapping("/register")
	public String register() {
		return "/score/write-form";
	}

	// ���� ��� ��û�� ó���� �޼���
	@PostMapping("/register")
	public String register(ScoreVO vo) {
		service.insertScore(vo);
		return "/score/write-result";
	}

	// ���� ��ü ��ȸ�� ó���ϴ� ��û �޼���
	@GetMapping("/list")
	public void list(Model model) {
		model.addAttribute("scores", service.selectAllScores());
	}

	// ���� ���� ��û ó�� �޼���
	@GetMapping("/delete")
	public String delete(@RequestParam("stuNum") int stuNum, RedirectAttributes ra) {
		service.deleteScore(stuNum);
		ra.addFlashAttribute("msg", "������ �Ϸ�Ǿ����ϴ�.");
		return "redirect:/score/list";
	}

	// ���� ���� ��ȸ ȭ�� ���� ��û �޼���
	@GetMapping("/search")
	public void search() {
	}

	// ���� ���� ��ȸ ó�� ��û �޼���
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
