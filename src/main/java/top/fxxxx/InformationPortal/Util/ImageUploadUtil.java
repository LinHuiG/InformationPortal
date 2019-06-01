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
 * @ClassName: ImageUploadUtil
 * @Description: 图片上传工具类，包括ckeditor操作
 */
public class ImageUploadUtil {

    // 图片类型
    private static List<String> fileTypes = new ArrayList<String>();

    static {
        fileTypes.add(".jpg");
        fileTypes.add(".jpeg");
        fileTypes.add(".bmp");
        fileTypes.add(".gif");
        fileTypes.add(".png");
    }

    /**
     * 图片上传
     *
     * @Title upload
     * @param request
     * @param DirectoryName
     *            文件上传目录：比如upload(无需带前面的/) upload/news ..
     * @return
     * @throws IllegalStateException
     * @throws IOException
     */
    public static String myupload(HttpServletRequest request, String DirectoryName)
    {
/**
 * Servlet implementation class UploadServlet
 */
         String ans="";
            long serialVersionUID = 1L;

            // 上传文件存储目录
            String UPLOAD_DIRECTORY = "resource"+File.separator+"Image";

            // 上传配置
             int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
             int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
             int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB

            /**
             * 上传数据及保存文件
             */

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

                // 设置最大文件上传值
                upload.setFileSizeMax(MAX_FILE_SIZE);

                // 设置最大请求值 (包含文件和表单数据)
                upload.setSizeMax(MAX_REQUEST_SIZE);

                // 中文处理
                upload.setHeaderEncoding("UTF-8");

                // 构造临时路径来存储上传的文件
                // 这个路径相对当前应用的目录
                String uploadPath = request.getServletContext().getRealPath("./") +  UPLOAD_DIRECTORY;


                // 如果目录不存在则创建
                File uploadDir = new File(uploadPath);
                if (!uploadDir.exists()) {
                    uploadDir.mkdir();
                }

                try {
                    // 解析请求的内容提取文件数据
                    @SuppressWarnings("unchecked")
                    List<FileItem> formItems = upload.parseRequest(request);

                    if (formItems != null && formItems.size() > 0) {
                        // 迭代表单数据
                        for (FileItem item : formItems) {
                            // 处理不在表单中的字段
                            if (!item.isFormField()) {
                                String fileName = new File(item.getName()).getName();
                                Long time=new Date().getTime();
                                int cd = fileName.lastIndexOf(".");
                                fileName =time+ fileName.substring(cd);

                                String filePath = uploadPath + File.separator + fileName;
                                File storeFile = new File(filePath);
                                ans=fileName;
                                // 在控制台输出文件的上传路径
                                // 保存文件到硬盘
                                item.write(storeFile);
                                request.setAttribute("message",
                                        "文件上传成功!");
                            }
                        }
                    }
                } catch (Exception ex) {
                    request.setAttribute("message",
                            "错误信息: " + ex.getMessage());
                }
                // 跳转到 message.jsp

            return ans;

    }
    public static String upload(HttpServletRequest request, String DirectoryName) throws IllegalStateException,
            IOException {
        // 创建一个通用的多部分解析器
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession()
                .getServletContext());
        // 图片名称
        String fileName = null;
        // 判断 request 是否有文件上传,即多部分请求
        if (multipartResolver.isMultipart(request)) {
            // 转换成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            // 取得request中的所有文件名
            Iterator<String> iter = multiRequest.getFileNames();
            if (iter.hasNext()) {

                // 记录上传过程起始时的时间，用来计算上传时间
                // int pre = (int) System.currentTimeMillis();
                // 取得上传文件
                MultipartFile file = multiRequest.getFile(iter.next());
                if (file != null) {
                    // 取得当前上传文件的文件名称
                    String myFileName = file.getOriginalFilename();
                    // 如果名称不为“”,说明该文件存在，否则说明该文件不存在
                    if (myFileName.trim() != "") {
                        // 获得图片的原始名称
                        String originalFilename = file.getOriginalFilename();
                        // 获得图片后缀名称,如果后缀不为图片格式，则不上传
                        String suffix = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
                        if (!fileTypes.contains(suffix)) {
                            //continue;
                        }
                        // 获得上传路径的绝对路径地址(/upload)-->
                        String realPath = request.getSession().getServletContext().getRealPath("/" + DirectoryName);
                        // 如果路径不存在，则创建该路径
                        File realPathDirectory = new File(realPath);
                        if (realPathDirectory == null || !realPathDirectory.exists()) {
                            realPathDirectory.mkdirs();
                        }
                        // 重命名上传后的文件名 111112323.jpg
                        fileName = DateUtil.format(new Date()) + suffix;
                        // 定义上传路径 .../upload/111112323.jpg
                        File uploadFile = new File(realPathDirectory + "\\" + fileName);
                        file.transferTo(uploadFile);
                    }
                }
                // 记录上传该文件后的时间
                // int finaltime = (int) System.currentTimeMillis();
                // System.out.println(finaltime - pre);
            }
        }
        return fileName;
    }

    /**
     * ckeditor文件上传功能，回调，传回图片路径，实现预览效果。
     *
     * @Title ckeditor
     * @param request
     * @param response
     * @param DirectoryName
     *            文件上传目录：比如upload(无需带前面的/) upload/..
     * @throws IOException
     */
    public static void ckeditor(HttpServletRequest request, HttpServletResponse response, String DirectoryName)
            throws IOException {
        String fileName = myupload(request, DirectoryName);
        // 结合ckeditor功能
        // imageContextPath为图片在服务器地址，如upload/123.jpg,非绝对路径
        String imageContextPath = request.getContextPath() + "/" + DirectoryName + "/" + fileName;
        //System.out.println(imageContextPath);
        response.setContentType("text/html;charset=UTF-8");
        String callback = request.getParameter("CKEditorFuncNum");
        //System.out.println(callback);
        PrintWriter out = response.getWriter();
        out.print("<script type=\"text/javascript\">");
        out.print("window.parent.CKEDITOR.tools.callFunction("
                + callback + ",'" + imageContextPath
                 + "','')");
        out.print("</script>");
        out.flush();
        out.close();
    }
}
