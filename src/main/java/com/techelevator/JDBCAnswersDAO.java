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
	public List<Answers>  getAllAnswers() {
		   List<Answers>  allAnswers = new ArrayList<>();
		
		String sqlAnswers   = "SELECT * FROM answers";
		SqlRowSet results   = jdbcTemplate.queryForRowSet(sqlAnswers);
		while(results.next()) {
			allAnswers.add(mapRowToAnswers(results));
			}
		
		return allAnswers;
	}
	@Override
	public List<Answers>  getQuestionsAndAnswers() {
		   List<Answers>  allAnswers = new ArrayList<>();
		   String         sqlquestionsAndAnswers   = "SELECT * FROM answers JOIN questions ON answers.question_id = questions.questions_id";
	SqlRowSet results   = jdbcTemplate.queryForRowSet(sqlquestionsAndAnswers);
	while(results.next()) {
		allAnswers.add(mapRowToAnswers(results));
		}
	
	return allAnswers;  
	//qJoinAnswers
}

	
	
	
//check
	private Answers mapRowToAnswers(SqlRowSet results) {
	Answers allAnswers;
	allAnswers = new Answers();
	allAnswers.setAnswerId(results.getLong("answer_id"));
	allAnswers.setQuestionId(results.getLong("question_id"));
	allAnswers.setAnswerText(results.getString("answer_text"));
	allAnswers.setCorrect(results.getBoolean("is_correct"));   // if statement??
	
	return allAnswers;
	}

}
