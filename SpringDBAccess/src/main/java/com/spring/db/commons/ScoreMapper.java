package com.spring.db.commons;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.db.model.ScoreVO;

//JdbcTemplate���� SELECT 荑쇰━瑜� ���� ResultSet �ъ�⑹�� �명��寃� ��湲� ���� 
//�대���ㅻ�� ����.
//RowMapper �명�고���댁�ㅻ�� 援ы���⑸����.
public class ScoreMapper implements RowMapper<ScoreVO> {

	@Override
	public ScoreVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ScoreVO vo = new ScoreVO();
		vo.setStuId(rs.getInt("stu_id"));
		vo.setStuName(rs.getString("stu_name"));
		vo.setKor(rs.getInt("kor"));
		vo.setEng(rs.getInt("eng"));
		vo.setMath(rs.getInt("math"));
		vo.setTotal(rs.getInt("total"));
		vo.setAverage(rs.getDouble("average"));
		
		return vo;
	}

}












