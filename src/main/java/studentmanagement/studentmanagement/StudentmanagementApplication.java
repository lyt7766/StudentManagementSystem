package studentmanagement.studentmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import studentmanagement.studentmanagement.entity.Student;
import studentmanagement.studentmanagement.repository.StudentRepository;

@SpringBootApplication
public class StudentmanagementApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentmanagementApplication.class, args);
	}
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {
		// Student student1 = new Student("Ramesh", "Tan", "ramesh@gmail.com");
		// studentRepository.save(student1);

		// Student student2 = new Student("Tan", "Ramesh", "ramesh@gmail.com");
		// studentRepository.save(student2);
	}

}
