package cn.itcast.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @author: mingjian
 * @create: 2020-03-06 19:28
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/fileupload1")
    public String fileUpload1(HttpServletRequest request){
        System.out.println("文件上传……");

        String path=request.getSession().getServletContext().getRealPath("/uploads/");
        File file=new File(path);
        if(!file.exists())
            file.mkdirs();
        DiskFileItemFactory factory=new DiskFileItemFactory();
        ServletFileUpload upload=new ServletFileUpload(factory);

        try {
            List<FileItem> items = upload.parseRequest(request);
            for(FileItem item:items){
                if(item.isFormField()){

                }else{
                    String filename = item.getName();
                    item.write(new File(path,filename));
                    item.delete();
                }
            }

        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }

    @RequestMapping("/fileupload2")
    public String fileUpload2(HttpServletRequest request, MultipartFile upload) throws IOException {
        System.out.println("springmvc文件上传……");
        String path=request.getSession().getServletContext().getRealPath("/uploads/");
        File file=new File(path);
        if(!file.exists())
            file.mkdirs();
        String filename = upload.getOriginalFilename();
        String uuid= UUID.randomUUID().toString().replace("-","");
        filename=uuid+"_"+filename;
        upload.transferTo(new File(path,filename));
        return "success";
    }

    @RequestMapping("/fileupload3")
    public String fileUpload3(MultipartFile upload) throws IOException {
        System.out.println("跨服务器上传……");

        String path="http://localhost:9090/fileuploadServer_war/uploads/";
        String filename = upload.getOriginalFilename();
        String uuid= UUID.randomUUID().toString().replace("-","");
        filename=uuid+"_"+filename;

        Client client = Client.create();
        WebResource webResource = client.resource(path + filename);
        webResource.put(upload.getBytes());
        return "success";
    }
}
