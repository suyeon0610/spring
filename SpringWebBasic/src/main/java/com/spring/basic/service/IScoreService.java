package com.spring.basic.service;

import java.util.List;

import com.spring.basic.model.ScoreVO;

public interface IScoreService {
	
	//���� ���
		void insertScore(ScoreVO vo);
		
		//���� ��ü ��ȸ
		List<ScoreVO> selectAllScores();
		
		//���� ����
		void deleteScore(int stuNum);
		
		//���� ���� ��ȸ
		ScoreVO selectScore(int stuNum);

}
