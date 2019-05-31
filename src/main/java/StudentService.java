import model.Student;
import repository.StudentRepository;

import java.util.List;

public class StudentService {

    private StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> findAll() {
        return repository.findAll();
    }

    public void delete(Long id){
        repository.delete(id);
    }
}
