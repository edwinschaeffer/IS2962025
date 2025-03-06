package config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("localhost.crm")
public class CRMConfig {
    // We now have a DataSource and a JdbcTemplate in the "hivemind" aka 
	// Spring Container
	
	@Bean
	public DataSource getDataSource() throws SQLException {
		DataSource ds = new EmbeddedDatabaseBuilder().addScript("classpath:potentialLeads.sql").build();
		ds.getConnection().setAutoCommit(true);
		return ds;
	}
	
	@Bean
	public JdbcTemplate getJdbcTemplate() throws SQLException {
		return new JdbcTemplate(getDataSource());
	}
}
