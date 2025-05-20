package com.myorganisation.service;

import com.myorganisation.dto.StudentRequestDTO;
import com.myorganisation.dto.StudentResponseDTO;
import com.myorganisation.model.Student;
import com.myorganisation.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public StudentResponseDTO registerStudent(StudentRequestDTO studentRequestDTO) {
        Student student = new Student();

        student.setName(studentRequestDTO.getName());
        student.setCourse(studentRequestDTO.getCourse());
        student.setEmail(studentRequestDTO.getEmail());
        student.setFee(studentRequestDTO.getFee());

        student = studentRepository.save(student);

        StudentResponseDTO studentResponseDTO = new StudentResponseDTO();

        studentResponseDTO.setId(student.getId());
        studentResponseDTO.setName(student.getName());
        studentResponseDTO.setCourse(student.getCourse());
        studentResponseDTO.setEmail(student.getEmail());
        studentResponseDTO.setFee(student.getFee());

        return studentResponseDTO;
    }

    @Override
    public StudentResponseDTO getStudent(Long id) {
        Student student = studentRepository.findById(id).orElse(null);

        StudentResponseDTO studentResponseDTO = new StudentResponseDTO();

        studentResponseDTO.setId(student.getId());
        studentResponseDTO.setName(student.getName());
        studentResponseDTO.setCourse(student.getCourse());
        studentResponseDTO.setEmail(student.getEmail());
        studentResponseDTO.setFee(student.getFee());

        return studentResponseDTO;
    }

    @Override
    public List<StudentResponseDTO> getAllStudents() {
        List<Student> studentList = studentRepository.findAll();

        List<StudentResponseDTO> studentResponseDTOList = new ArrayList<>();

        for(Student student: studentList) {
            StudentResponseDTO studentResponseDTO = new StudentResponseDTO();

            studentResponseDTO.setId(student.getId());
            studentResponseDTO.setName(student.getName());
            studentResponseDTO.setCourse(student.getCourse());
            studentResponseDTO.setEmail(student.getEmail());
            studentResponseDTO.setFee(student.getFee());

            studentResponseDTOList.add(studentResponseDTO);
        }

        return studentResponseDTOList;
    }

    @Override
    public StudentResponseDTO updateStudent(Long id, StudentRequestDTO studentRequestDTO) {
        Student student = studentRepository.findById(id).orElse(null);

        student.setName(studentRequestDTO.getName());
        student.setCourse(studentRequestDTO.getCourse());
        student.setEmail(studentRequestDTO.getEmail());
        student.setFee(studentRequestDTO.getFee());

        student = studentRepository.save(student);

        StudentResponseDTO studentResponseDTO = new StudentResponseDTO();

        studentResponseDTO.setId(student.getId());
        studentResponseDTO.setName(student.getName());
        studentResponseDTO.setCourse(student.getCourse());
        studentResponseDTO.setEmail(student.getEmail());
        studentResponseDTO.setFee(student.getFee());

        return studentResponseDTO;
    }

    @Override
    public String removeStudent(Long id) {
        String name = studentRepository.findById(id).orElse(null).getName();
        studentRepository.deleteById(id);

        return "Student name: " + name + ", has been removed successfully.";
    }
}