package com.example.examen;

import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;


@Component
public class GraphQLController implements GraphQLQueryResolver {

    @Autowired
    private ServiceStudent studentService;

    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    public Student getStudentById(Long id) {
        return studentService.getStudentById(id);
    }
}
