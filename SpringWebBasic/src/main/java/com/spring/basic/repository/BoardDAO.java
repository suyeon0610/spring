package com.spring.basic.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.basic.model.BoardVO;

@Repository
public class BoardDAO implements IBoardDAO {
	
	List<BoardVO> boardList = new ArrayList<>();

	@Override
	public void insertArticle(BoardVO vo) {
		boardList.add(vo);
	}

	@Override
	public List<BoardVO> getArticles() {
		return boardList;
	}

	@Override
	public BoardVO getArticle(int bId) {
		return boardList.get(bId);
	}

	@Override
	public void deleteArticle(int bId) {
		boardList.remove(bId);
	}

	@Override
	public void updateArticle(BoardVO vo, int bId) {
		boardList.set(bId, vo);

	}

}
