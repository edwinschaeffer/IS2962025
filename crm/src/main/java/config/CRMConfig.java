package config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("localhost.crm")
@MapperScan("localhost.crm.mapper")
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
	public SqlSessionFactory myBatisFactory() throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setTypeAliasesPackage("localhost.crm.vo");
		sessionFactory.setDataSource(getDataSource());
		return sessionFactory.getObject();
	}
	
	@Bean
	public JdbcTemplate getJdbcTemplate() throws SQLException {
		return new JdbcTemplate(getDataSource());
	}
}
