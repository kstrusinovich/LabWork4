import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import repository.JdbcTemplateStudentRepository;
import repository.StudentRepository;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:SQL/database.properties")
public class StudentConfig {

    @Autowired
    Environment environment;

    @Bean
    StudentRepository jdbcRepository() {
        return new JdbcTemplateStudentRepository(dataSource());
    }

    @Bean
    StudentService studentService() {
        return new StudentService(jdbcRepository());
    }

    @Bean
    DataSource dataSource() {
        DriverManagerDataSource source = new DriverManagerDataSource();
        source.setUrl(environment.getProperty("url"));
        source.setUsername(environment.getProperty("dbuser"));
        source.setPassword(environment.getProperty("dbpassword"));
        source.setDriverClassName(environment.getProperty("driver"));
        return source;
    }

}
