package cn.fzj.controller;

import cn.fzj.pojo.Deal;
import cn.fzj.service.DealService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    DealService dealService;

    @RequestMapping("/index")
    public String toIndex(Model model){
        //在这里的model放入分页信息
        List<Deal> allNeed = dealService.queryAllNeed();
        List<Deal> allSupply = dealService.queryAllSupply();
        model.addAttribute("allNeed",allNeed);
        model.addAttribute("allSupply",allSupply);
        return "index";
    }
}
