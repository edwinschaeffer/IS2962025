package config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

@SpringBootApplication
@ComponentScan("disburseMyBatis")
@MapperScan("disburseMyBatis.mapper")
public class HouseDisburseConfig {

	@Bean
	public DataSource getDataSource() throws SQLException {
		DataSource ds = new EmbeddedDatabaseBuilder().addScript("classpath:2013Q4_HOUSE_DISBURSE.sql").build();
		ds.getConnection().setAutoCommit(true);
		return ds;
	}
	@Bean
	public SqlSessionFactory myBatisFactory() throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setTypeAliasesPackage("disburseMyBatis.vo");
		sessionFactory.setDataSource(getDataSource());
		return sessionFactory.getObject();
	}
}
