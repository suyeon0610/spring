package com.spring.basic.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.basic.model.BoardVO;

public interface IBoardService {
	
	//�Խñ� ���
		void insertArticle(BoardVO vo);
		
		//��ü �Խñ� ���
		List<BoardVO> getArticles();
		
		//�Խñ� �󼼺���
		BoardVO getArticle(int bId);
		
		//�Խñ� ����
		void deleteArticle(int bId);
		
		//�Խñ� ����
		void updateArticle(BoardVO vo, int bId);
	
}
