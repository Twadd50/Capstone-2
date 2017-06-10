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
		
		   
		   	//SqlRowSet handles "results" from the = jdbcTemplate
			//when using "queryForRowSet" method, "mapRow" is needed
		   	//mapRow is used when each row of the result set corresponds to one object in your list
		String sqlQuestions = "SELECT * FROM questions";
		SqlRowSet results   = jdbcTemplate.queryForRowSet(sqlQuestions);
		while(results.next()) {
			allQuestions.add(mapRowToQuestions(results));
			
		}
		return allQuestions;
	}
			//sync what data can be accessed and where
	private Questions mapRowToQuestions(SqlRowSet results) {
		Questions allQuestions;
		allQuestions = new Questions();
		allQuestions.setId(results.getLong("id"));
			
		return allQuestions;	
	}
}






