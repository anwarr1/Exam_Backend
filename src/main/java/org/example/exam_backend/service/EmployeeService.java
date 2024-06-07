package org.example.exam_backend.service;

import lombok.NoArgsConstructor;
import org.example.exam_backend.models.Employee;
import org.example.exam_backend.models.Person;
import org.example.exam_backend.repository.EmployeeRepository;
import org.example.exam_backend.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
public class EmployeeService {

    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository personRepository) {
        this.employeeRepository = personRepository;
    }

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }
 public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    public  void addPerson(Employee person) {
        employeeRepository.save(person);
    }


    public  void deletePerson(Long id) {
        employeeRepository.deleteById(id);
    }
}
