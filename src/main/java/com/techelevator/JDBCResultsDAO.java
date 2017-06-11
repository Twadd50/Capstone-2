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
public List<Results> getAllResults() {
	   List<Results> allResults = new ArrayList<>();
	
	String sqlResults   = "SELECT * FROM results";
	SqlRowSet results   = jdbcTemplate.queryForRowSet(sqlResults);

	while(results.next()) {
		allResults.add(mapRowToResults(results));
		}
	return allResults;
}








@Override
public List<Results> viewTopScores() {
	   List<Results> allResults = new ArrayList<>();

	String sqlResults   = "SELECT * FROM results";
	SqlRowSet results   = jdbcTemplate.queryForRowSet(sqlResults);
	while(results.next()) {
		allResults.add(mapRowToResults(results));
		}
	return allResults;
}


@Override
public Results addNewUserName() {
	   List<Results> allResults = new ArrayList<>();
	   
	
	String sqlNewUserName = "INSERT INTO results (name) values(?)";   
	jdbcTemplate.update(sqlNewUserName);
	return addNewUserName();
}















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


































