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
	public List<Answers> getAllAnswers() {
		List<Answers>  allAnswers = new ArrayList<>();
		String sqlAnswers = "SELECT * FROM answers";
		SqlRowSet results   = jdbcTemplate.queryForRowSet(sqlAnswers);
		while(results.next()) {
			allAnswers.add(mapRowToAnswers(results));
			
		}
		return allAnswers;
	}
private Questions mapRowToAnswers(SqlRowSet results) {
	return null;
}

}
