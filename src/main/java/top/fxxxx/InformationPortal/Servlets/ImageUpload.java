package top.fxxxx.InformationPortal.Servlets;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.bind.annotation.RequestMapping;
import top.fxxxx.InformationPortal.Util.ImageUploadUtil;

public class ImageUpload extends HttpServlet {

    private String DirectoryName = "Image";

    /**
     * 图片上传
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }
    public void init() throws ServletException {
        // 执行必需的初始化
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        imageUpload(request,response);
    }
    /**
     * ckeditor图片上传
     */
    @RequestMapping("/ImageUpload")
    public void imageUpload(HttpServletRequest request, HttpServletResponse response) {
        try {
            ImageUploadUtil.ckeditor(request, response, DirectoryName);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}