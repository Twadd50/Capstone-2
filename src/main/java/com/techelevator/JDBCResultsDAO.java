package com.techelevator;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCResultsDAO implements ResultsDAO {
	private JdbcTemplate jdbcTemplate;

	public JDBCResultsDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
//-----------------------------------------------------------------------------------------------------------------------------------	
	
	
	@Override
	public List<Results> getAllResults(Answers answer) {
		   List<Results> allResults = new ArrayList<>();
		   
		   String sqlResults   = "INSERT INTO  results (id) (name) (total_questions) (correct_questions)";
		   SqlRowSet results   = jdbcTemplate.queryForRowSet(sqlResults);
		   		while(results.next()) {
			allResults.add(mapRowToResults(results));
			}
		return allResults;
	}

//	@Override
//	public List<Results> getAddNewUserName(Object[] storeName) {
//		String sqlNewUserName = "INSERT INTO results (name) values(?)";   
//		jdbcTemplate.update(sqlNewUserName);
//		return getAllResults();
//	}
	
	
	
	
	
//@Override
//public List<Results> getAllResults() {		
//	   List<Results> allResults = new ArrayList<>();
//	   
//	   String sqlResults   = "SELECT * FROM results";
//	SqlRowSet results   = jdbcTemplate.queryForRowSet(sqlResults);
//
//	while(results.next()) {
//		allResults.add(mapRowToResults(results));
//		}
//	return allResults;
//}
//
//@Override
//public List<Results> getAddNewUserName(String storeName) {
//	String sqlNewUserName = "INSERT INTO results (name) values(?)";   
//	jdbcTemplate.update(sqlNewUserName);
//	return getAllResults();
//}

//@Override
//public List<Results> getViewTopScores() {			
//	   List<Results> allResults = new ArrayList<>();
//
//	String sqlResults   = "SELECT * FROM results";
//	SqlRowSet results   = jdbcTemplate.queryForRowSet(sqlResults);
//	while(results.next()) {
//		allResults.add(mapRowToResults(results));
//		}
//	return allResults;
//}
//
//@Override
//public List<Results> getOverallScore() {
//	   List<Results> allResults = new ArrayList<>();
//	   
//	String sqlOverallScore = "SELECT total_questions, correct_questions";   
//	jdbcTemplate.update(sqlOverallScore);
//	return allResults;
//}
//@Override
//public List<Results> getId() {
//	   List<Results> allResults = new ArrayList<>();
//	   
//		String sqlGetId = "SELECT id";   
//		jdbcTemplate.update(sqlGetId);
//		return allResults;
//}
//@Override
//public List<Results> getName() {
//	   List<Results> allResults = new ArrayList<>();
//	   
//			String sqlGetName = "SELECT name";   
//			jdbcTemplate.update(sqlGetName);
//			return allResults;
//
//}
//
//@Override
//public List<Results> getCorrectQuestions() {
//	   List<Results> allResults = new ArrayList<>();
//	   
//				String sqlGetCorrectQuestions = "SELECT correct_questions";   
//				jdbcTemplate.update(sqlGetCorrectQuestions);
//				return allResults;
//}

private Results mapRowToResults(SqlRowSet results) {
	Results allResults;
	allResults = new Results();
	allResults.setId(results.getLong("id"));
	allResults.setName(results.getNString("name"));  // check 
	allResults.setCorrectQuestions(results.getLong("correct_questions"));
	allResults.setTotalQuestions(results.getLong("total_questions"));
	return allResults;
}

}
