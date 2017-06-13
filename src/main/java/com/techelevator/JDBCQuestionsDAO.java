package com.techelevator;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCQuestionsDAO implements QuestionsDAO {
	
	private JdbcTemplate jdbcTemplate;

	public JDBCQuestionsDAO(DataSource dataSource) { 
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
//-----------------------------------------------------------------------------------------------------------------------------------
	@Override
	public List<Questions> getAllQuestions() {
		   List<Questions> allQuestions = new ArrayList<>();
	
		String sqlQuestions = "SELECT * FROM questions";
		SqlRowSet results   = jdbcTemplate.queryForRowSet(sqlQuestions);
		while(results.next()) {
			allQuestions.add(mapRowToQuestions(results));
			}
		return allQuestions;
	}
	
			//sync what data can be accessed and where
	private Questions mapRowToQuestions(SqlRowSet results) {			//mapRow always needs all columns
		Questions allQuestions;
		allQuestions = new Questions();
		allQuestions.setId(results.getLong("id"));
		allQuestions.setQuestionText(results.getNString("question_text"));
			
		return allQuestions;	
	}
//	@Override
//	public List<Questions> getQuestionText() {
//		   List<Questions> allQuestions = new ArrayList<>();
//		
//			String sqlGetQuestionText = "SELECT question_text FROM questions";
//			SqlRowSet results   = jdbcTemplate.queryForRowSet(sqlGetQuestionText);
//			while(results.next()) {
//				allQuestions.add(mapRowToQuestions(results));
//				}
//			return allQuestions;
//		}
//	@Override
//	public List<Questions> getId() {
//		   List<Questions> allQuestions = new ArrayList<>();
//			
//				String sqlGetId = "SELECT id FROM questions";
//				SqlRowSet results   = jdbcTemplate.queryForRowSet(sqlGetId);
//				while(results.next()) {
//					allQuestions.add(mapRowToQuestions(results));
//					}
//				return allQuestions;
//	}
}






