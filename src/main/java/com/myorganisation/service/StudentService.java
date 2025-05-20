package com.myorganisation.service;

import com.myorganisation.dto.StudentRequestDTO;
import com.myorganisation.dto.StudentResponseDTO;

import java.util.List;

public interface StudentService {
    //CRUD
    StudentResponseDTO registerStudent(StudentRequestDTO studentRequestDTO);
    StudentResponseDTO getStudent(Long id);
    List<StudentResponseDTO> getAllStudents();
    StudentResponseDTO updateStudent(Long id, StudentRequestDTO studentRequestDTO);
    String removeStudent(Long id);
}
