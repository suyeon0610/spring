package com.spring.basic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.basic.model.ScoreVO;
import com.spring.basic.repository.IScoreDAO;

@Service
public class ScoreService implements IScoreService {

	@Autowired
	private IScoreDAO dao;
	
	@Override
	public void insertScore(ScoreVO vo) {
		vo.calcData();
		dao.insertScore(vo);
	}

	@Override
	public List<ScoreVO> selectAllScores() {
		return dao.selectAllScores();
	}

	@Override
	public void deleteScore(int stuNum) {
		dao.deleteScore(stuNum-1);
	}

	@Override
	public ScoreVO selectScore(int stuNum) {
		return dao.selectScore(stuNum-1);
	}

}
