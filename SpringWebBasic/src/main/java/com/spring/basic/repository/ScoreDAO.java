package com.spring.basic.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.basic.model.ScoreVO;

@Repository
public class ScoreDAO implements IScoreDAO {
	
	List<ScoreVO> scoreList = new ArrayList<>();

	@Override
	public void insertScore(ScoreVO vo) {
		scoreList.add(vo);
	}

	@Override
	public List<ScoreVO> selectAllScores() {
		return scoreList;
	}

	@Override
	public void deleteScore(int stuNum) {
		scoreList.remove(stuNum);
	}

	@Override
	public ScoreVO selectScore(int stuNum) {
		return scoreList.get(stuNum);
	}

}
