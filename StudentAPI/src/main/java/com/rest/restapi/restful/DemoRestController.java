package com.rest.restapi.restful;

import com.rest.restapi.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoRestController {
    List<Student> studentList ;
// PostConstruct Method Run only Once after running an application so we load data once during initialization and use that data as many time.
    
    @PostConstruct
    public void loadData(){
        studentList = new ArrayList<>();
        studentList.add(new Student("Rahul","Singh","Kamaladi"));
        studentList.add(new Student("Alice", "Smith", "456 Oak Ave"));
        studentList.add(new Student("Bob", "Johnson", "789 Elm St"));
        studentList.add(new Student("Emma", "Brown", "321 Pine St"));
        studentList.add(new Student("Jack", "Davis", "654 Maple Ave"));
        studentList.add(new Student("Sophia", "Wilson", "987 Cedar St"));
        studentList.add(new Student("Michael", "Martinez", "135 Birch Ave"));
        studentList.add(new Student("Olivia", "Garcia", "246 Willow St"));
        studentList.add(new Student("James", "Lopez", "579 Spruce Ave"));
        studentList.add(new Student("Emily", "Rodriguez", "864 Fir St"));
        studentList.add(new Student("Daniel", "Thomas", "975 Sycamore Ave"));
    }
    @GetMapping("/students/{studentID}")
    public Student getStudentByID(@PathVariable int studentID){
        if(studentID<0 || (studentID>=studentList.size())){
            throw new StudentNotFoundException("Student Not Found of ID : "+studentID);
        }
        return studentList.get(studentID);
    }
    @GetMapping("/students")
    List<Student> getAllStudents(){
        return studentList;
    }

    // Exception Handler Methodception
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException err){
        StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
        studentErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        studentErrorResponse.setMessage(err.getMessage());
        studentErrorResponse.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(studentErrorResponse,HttpStatus.NOT_FOUND);
    }
    // Handle Exception for all like String, Number, etc
     @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException err){
        StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
        studentErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        studentErrorResponse.setMessage(err.getMessage());
        studentErrorResponse.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(studentErrorResponse,HttpStatus.BAD_REQUEST);
    }
}
