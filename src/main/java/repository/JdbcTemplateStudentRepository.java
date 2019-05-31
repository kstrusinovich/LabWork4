package repository;


import model.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class JdbcTemplateStudentRepository implements StudentRepository{

    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateStudentRepository(DataSource ds){
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    @Override
    public List<Student> findAll(){
        return jdbcTemplate.query("select * from student", new BeanPropertyRowMapper<>(Student.class));
    }

    @Override
    public Student findById(Long id) {
        return jdbcTemplate.queryForObject("select * from student WHERE id = ?", new Object[]{id},  new BeanPropertyRowMapper<>(Student.class));
    }
    @Override
    public void delete(Long id){
        jdbcTemplate.update("DELETE FROM student WHERE id = ?", id);
    }

    @Override
    public void add(Long id, String name, int age, int group_t, double average_mark){
        jdbcTemplate.update("insert into student (id, name, age, group_t, average_mark)" +
                " values (?, ?, ?, ?, ?)", id, name, age, group_t, average_mark);
    }
}
