package com.atguigu.servlet;

import com.atguigu.pojo.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. get request parameter
        //2. send sql to database to search student
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < 20; i++){
            int t = i+1;
            studentList.add(new Student(t,"name"+t,18+t,"phone"+t));
        }
        //3. save the returned result and save to the request
        req.setAttribute("stuList",studentList);
        //4. request dispatch to student.jsp
        req.getRequestDispatcher("/test/test2.jsp").forward(req,resp);
    }
}