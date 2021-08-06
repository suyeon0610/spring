package com.spring.basic.repository;

import java.util.List;

import com.spring.basic.model.BoardVO;

public interface IBoardDAO {
	
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
