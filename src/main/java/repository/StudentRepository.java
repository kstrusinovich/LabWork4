package repository;

import model.Student;

import java.util.List;

public interface StudentRepository {

    List<Student> findAll();

    Student findById(Long id);

    void delete(Long id);

    void add(Long id, String name, int age, int group_t, double average_mark);
}
