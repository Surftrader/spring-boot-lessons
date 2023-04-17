package ua.com.poseal.springbootlessons.sms.repositories;

import org.springframework.stereotype.Component;
import ua.com.poseal.springbootlessons.sms.models.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class StudentRepository {
    private static List<Student> students;
    private static long ID = 0;

    public StudentRepository() {
        if (students == null) {
            students = new ArrayList<>();
            students.add(new Student(++ID, "Mark", "Polo", "polo@gmail.com"));
            students.add(new Student(++ID, "Jacob", "Thornton", "thornton@gmail.com"));
            students.add(new Student(++ID, "Larry", "Otto", "otto@gmail.com"));
        }
    }

    public List<Student> findAll() {
        return students;
    }

    public Optional<Student> findById(Long id) {
        return students.stream().filter(s -> s.getId() == id).findAny();
    }

    public Boolean deleteById(Long id) {
        Optional<Student> student = findById(id);
        if (student.isPresent()) {
            students.remove(student.get());
            return true;
        }
        return false;
    }

    public void save(Student student) {
        student.setId(++ID);
        students.add(student);
    }
}
