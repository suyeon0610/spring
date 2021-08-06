package com.spring.basic.repository;

import java.util.List;

import com.spring.basic.model.ScoreVO;

public interface IScoreDAO {

	//���� ���
	void insertScore(ScoreVO vo);
	
	//���� ��ü ��ȸ
	List<ScoreVO> selectAllScores();
	
	//���� ����
	void deleteScore(int stuNum);
	
	//���� ���� ��ȸ
	ScoreVO selectScore(int stuNum);
	
}
