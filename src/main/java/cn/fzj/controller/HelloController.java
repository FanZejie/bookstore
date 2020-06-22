package cn.fzj.controller;

import cn.fzj.pojo.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
//测试用Controller
@RestController
public class HelloController {
    @RequestMapping(value = "/json1",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String json1() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        User user = new User(1,"范泽杰","111111","1227508136@qq.com",1);
        //将这个对象转换为json字符串
        String s = mapper.writeValueAsString(user);
        System.out.println(s);
        return s;
    }

    @RequestMapping(value = "/time1")
    @ResponseBody//他现在返回的是一个时间戳1592801833800
    public String time1() throws JsonProcessingException {
        Date date = new Date();
        return new ObjectMapper().writeValueAsString(date);
    }

    @RequestMapping(value = "/time2")
    @ResponseBody
    public String time2() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        //关闭时间戳
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //让mapper指定时间日期格式为simpleDateFormat
        mapper.setDateFormat(simpleDateFormat);
        return mapper.writeValueAsString(date);

    }
}
