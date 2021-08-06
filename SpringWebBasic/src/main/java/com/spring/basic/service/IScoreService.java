package com.spring.basic.service;

import java.util.List;

import com.spring.basic.model.ScoreVO;

public interface IScoreService {
	
	//점수 등록
		void insertScore(ScoreVO vo);
		
		//점수 전체 조회
		List<ScoreVO> selectAllScores();
		
		//점수 삭제
		void deleteScore(int stuNum);
		
		//점수 개별 조회
		ScoreVO selectScore(int stuNum);

}
