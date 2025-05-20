package com.myorganisation.controller;

import com.myorganisation.dto.StudentRequestDTO;
import com.myorganisation.dto.StudentResponseDTO;
import com.myorganisation.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentResponseDTO> registerStudent(@RequestBody StudentRequestDTO studentRequestDTO) {
        return new ResponseEntity<>(studentService.registerStudent(studentRequestDTO), HttpStatusCode.valueOf(201));
    }

    @GetMapping
    public ResponseEntity<StudentResponseDTO> getStudent(@RequestParam(name = "id") Long id) {
        return new ResponseEntity<>(studentService.getStudent(id), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/all")
    public ResponseEntity<List<StudentResponseDTO>> getAllStudents() {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatusCode.valueOf(200));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> updateStudent(@PathVariable(name = "id") Long id, @RequestBody StudentRequestDTO studentRequestDTO) {
        return new ResponseEntity<>(studentService.updateStudent(id, studentRequestDTO), HttpStatusCode.valueOf(200));
    }

    @DeleteMapping
    public ResponseEntity<String> removeStudent(@RequestParam(name = "id") Long id) {
        return new ResponseEntity<>(studentService.removeStudent(id), HttpStatusCode.valueOf(200));
    }

}
