package top.fxxxx.InformationPortal.Util;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.ivy.util.DateUtil;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * 图片上传工具类，加入了ckeditor跳转操作
 */
public class ImageUploadUtil {



    public static String myupload(HttpServletRequest request, String DirectoryName) {
        String ans = "";
        // 上传配置
        int MEMORY_THRESHOLD = 1024 * 1024 * 3;  // 3MB
        int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
        int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

        if (!ServletFileUpload.isMultipartContent(request)) {
            // 如果不是则停止
            return "";
        }

        // 配置上传参数
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // 设置临时存储目录
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setFileSizeMax(MAX_FILE_SIZE);
        upload.setSizeMax(MAX_REQUEST_SIZE);
        upload.setHeaderEncoding("UTF-8");
        String uploadPath = request.getServletContext().getRealPath("./") + DirectoryName;
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        try {
            // 解析请求的内容提取文件数据
            List<FileItem> formItems = upload.parseRequest(request);

            if (formItems != null && formItems.size() > 0) {
                for (FileItem item : formItems) {
                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                        Long time = new Date().getTime();
                        int cd = fileName.lastIndexOf(".");
                        String hz = fileName.substring(cd);
                        if (!fileTypes.contains(hz)) continue;
                        fileName = time + hz;
                        String filePath = uploadPath + File.separator + fileName;
                        File storeFile = new File(filePath);
                        ans = fileName;
                        item.write(storeFile);
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ans;

    }

    public static void ckeditor(HttpServletRequest request, HttpServletResponse response, String DirectoryName)
            throws IOException {
        String fileName = myupload(request, DirectoryName);
        // 结合ckeditor功能
        // imageContextPath为图片在服务器地址，如upload/123.jpg,非绝对路径
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        if (fileName != null && fileName.equals("")) {
            PrintWriter out = response.getWriter();
            out.print("<script type=\"text/javascript\">");
            out.println("alert('仅支持上传.jpg .jpeg .png .bmp .gif后缀图片文件');");
            out.print("</script>");
            return;
        }
        String imageContextPath = request.getContextPath() + "/" + DirectoryName + "/" + fileName;
        String callback = request.getParameter("CKEditorFuncNum");
        PrintWriter out = response.getWriter();
        out.print("<script type=\"text/javascript\">");
        out.print("window.parent.CKEDITOR.tools.callFunction("
                + callback + ",'" + imageContextPath
                + "','')");
        out.print("</script>");
        out.flush();
        out.close();
    }
    private static List<String> fileTypes = new ArrayList<String>();

    static {
        fileTypes.add(".gif");
        fileTypes.add(".png");
        fileTypes.add(".jpg");
        fileTypes.add(".jpeg");
        fileTypes.add(".bmp");
    }
}
