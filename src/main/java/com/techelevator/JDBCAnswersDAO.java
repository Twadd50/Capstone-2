package com.techelevator;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet; 

public class JDBCAnswersDAO implements AnswersDAO {

		
	private JdbcTemplate jdbcTemplate;
 
		public JDBCAnswersDAO(DataSource dataSource) {
			this.jdbcTemplate = new JdbcTemplate(dataSource);
		}
//-----------------------------------------------------------------------------------------------------------------------------------	
	
		@Override
	public  List<Answers>  		getAllAnswers(Questions question) {
			List<Answers>       allAnswers = new ArrayList<>();
			String sqlAnswers   = "SELECT * FROM answers WHERE question_id = ?";
			SqlRowSet results   = jdbcTemplate.queryForRowSet(sqlAnswers);
			while(results.next()) {
			allAnswers.add(mapRowToAnswers(results));
			}
		
		return allAnswers;
	}
//	@Override
//	public List<Answers>  getId() {
//		   List<Answers>  allAnswers = new ArrayList<>();
//		
//		String sqlGetId = "SELECT id FROM answers ";
//		SqlRowSet results   = jdbcTemplate.queryForRowSet(sqlGetId);
//		while(results.next()) {
//			results.absolute(0);
//			}
//		return allAnswers;
//	}
//	@Override
//	public List<Answers>  getQuestionId() {
//		   List<Answers>  allAnswers = new ArrayList<>();
//		
//		String sqlgetQuestionId = "SELECT question_id FROM answers ";
//		SqlRowSet results   = jdbcTemplate.queryForRowSet(sqlgetQuestionId);
//		while(results.next()) {
//			////////check/////////
//			results.absolute(0);
//			}
//		return allAnswers;
//	}
//	@Override
//	public List<Answers>  getAnswerText() {
//		   List<Answers>  allAnswers = new ArrayList<>();
//		
//		String sqlgetAnswerText = "SELECT answer_text FROM answers ";
//		SqlRowSet results   = jdbcTemplate.queryForRowSet(sqlgetAnswerText);
//		while(results.next()) {
//			////////check/////////
//			results.absolute(0);
//			}
//		return allAnswers;
//	}
//	
//	@Override
//	public List<Answers>  getIsCorrect() {
//		   List<Answers>  allAnswers = new ArrayList<>();
//		
//		String sqlgetIsCorrect = "SELECT is_correct FROM answers ";
//		SqlRowSet results   = jdbcTemplate.queryForRowSet(sqlgetIsCorrect);
//		while(results.next()) {
//			////////check/////////
//			results.absolute(0);
//			}
//		return allAnswers;
//	}
	
//
	private Answers mapRowToAnswers(SqlRowSet results) {
	Answers allAnswers;
	allAnswers = new Answers();
	allAnswers.setAnswerId(results.getLong("answer_id"));
	allAnswers.setQuestionId(results.getLong("question_id"));
	allAnswers.setAnswerText(results.getString("answer_text"));
	allAnswers.setCorrect(results.getBoolean("is_correct"));  			 // if?
	
	return allAnswers;
	}

	@Override
	public List<Answers> getAnswerId(Questions question) {
		// TODO Auto-generated method stub
		return null;
	}

}
