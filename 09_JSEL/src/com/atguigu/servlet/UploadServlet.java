package com.atguigu.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UploadServlet extends HttpServlet {
    //used to handle file upload
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("Files uploaded.");
//        ServletInputStream servletInputStream = req.getInputStream();
//        byte[] buffer = new byte[100000];
//        int read = servletInputStream.read(buffer);
//        System.out.println(new String(buffer, 0, read));
        //1. check if the files uploaded are multipart-data
        if (ServletFileUpload.isMultipartContent(req)){
            //1, create a fileitemfactory instance
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            //2.
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            try {
                List<FileItem> list = servletFileUpload.parseRequest(req);
                for(FileItem fileItem: list){
                    if(fileItem.isFormField()){
                        //1. common post form data
                        System.out.println("The uploaded form name is "+ fileItem.getFieldName());
                        System.out.println("The uploaded form value is "+ fileItem.getString("UTF-8"));
                    } else {
                        //uploaded files

                        System.out.println("The uploaded form name is "+ fileItem.getFieldName());
                        System.out.println("The uploaded form value is "+ fileItem.getString("UTF-8"));
                        System.out.println("You uploaded something.");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}

