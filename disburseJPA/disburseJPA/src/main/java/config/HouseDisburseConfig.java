package config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.orm.jpa.JpaVendorAdapter;

@SpringBootApplication
@ComponentScan("disburseJPA")
@EnableJpaRepositories("disburseJPA.repository")
public class HouseDisburseConfig {
	
	@Bean
	public DataSource getDataSource() throws SQLException {
		DataSource ds = new EmbeddedDatabaseBuilder().addScript("classpath:2013Q4_HOUSE_DISBURSE.sql").build();
		ds.getConnection().setAutoCommit(true);
		return ds;
	}	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws SQLException {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(getDataSource());
		em.setPackagesToScan("disburseJPA.vo");
		JpaVendorAdapter va = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(va);
		return em;
	}

}
