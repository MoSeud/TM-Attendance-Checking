package com.redsea.mas.serviceImpl;

import com.redsea.mas.domain.Faculty;
import com.redsea.mas.domain.Role;
import com.redsea.mas.domain.Student;
import com.redsea.mas.domain.User;
import com.redsea.mas.service.FacultyService;
import com.redsea.mas.service.StudentService;
import com.redsea.mas.util.Roles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class LoginService {

    @Autowired
    UserService userService;
    @Autowired
    FacultyService facultyService;
    @Autowired
    StudentService studentService;


    public Object getCurrentUserID(Authentication auth) {
        String email = auth.getName();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>"+"login"+ email);
        User user = userService.findUserByEmail(email);
        Set<Role> roles = user.getRoles();
        List<String> rolesString = roles.stream().map(Role::getRole).collect(Collectors.toList());
        if (rolesString.contains(Roles.FACULTY.name())) {
            Faculty faculty = facultyService.findByEmail(email);
            if (faculty != null) {
                return faculty;
            }

        }if (rolesString.contains(Roles.STUDENT.name())) {
            Student student = studentService.findStudentByEmail(email);
            if (student != null) {
                return student;
            }
        }
            return null;
    }


    public String getRole(Authentication auth){
        User user = userService.findUserByEmail(auth.getName());
        Set<Role> roles = user.getRoles();
        List<String> rolesString = roles.stream().map(Role::getRole).collect(Collectors.toList());
        return rolesString.isEmpty()? null: rolesString.get(0);
    }
}