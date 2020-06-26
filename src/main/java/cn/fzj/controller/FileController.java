package cn.fzj.controller;

import cn.fzj.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class FileController {

    @GetMapping("/upload")
    public String upload() {
        return "upload";
    }

    @PostMapping("/upload")
    @ResponseBody
    public Map<String,Object> upload(@RequestParam("file") MultipartFile file, HttpServletRequest request, Model model) {
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        if (file.isEmpty()) {
            map.put("msg","上传失败");
            return map;
        }

        String fileName = UUID.randomUUID().toString().substring(0,5)+file.getOriginalFilename() ;
        User user = (User) request.getSession().getAttribute("user");
        //这个不能写到项目路径下，tomcat会访问不到
        //上传还必须是绝对路径，不然他会上传失败
            //那我能不能这里写个句对路径，但我实际往数据库中写的只有文件名，然后配置虚拟目录
        // String filePath = "\\path\\"+user.getUsername()+"\\";
        String filePath = "D:\\"+user.getUsername()+"\\";

        System.out.println(filePath);
        File dest = new File(filePath + fileName);
        if (!dest.exists()){
            dest.mkdirs();
        }

        Map<String,Object> data = new HashMap<>();
        data.put("src",filePath+fileName);
        try {
            file.transferTo(dest);
            map.put("msg","上传成功");
            map.put("url",fileName);
            System.out.println("上传成功");
            return map;
        } catch (IOException e) {
            map.put("msg","上传失败");
            System.out.println("上传失败");
        }
        return map;
    }
}
