package cn.fzj.controller;

import cn.fzj.pojo.Deal;
import cn.fzj.pojo.User;
import cn.fzj.service.impl.DealServiceImpl;
import cn.fzj.service.impl.UserServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;

/**
 * 交易条目处理Controller
 */
@Controller
public class DealController {
    @Autowired
    DealServiceImpl dealService;

    /**
     * 发布二手书需求
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/addRequirement")
    public String addRequirement(HttpServletRequest request, Model model){
        User user = (User) request.getSession().getAttribute("user");
        int id = user.getId();
        String bookName = request.getParameter("bname");
        String priceStr = request.getParameter("price");
        BigDecimal price = new BigDecimal(priceStr);
        String description = request.getParameter("description");
        String picture = "图片url";
        int flag = dealService.addRequirement(id, bookName, price, picture, description);
        if (flag == 1){
            model.addAttribute("msg","插入成功");
            return "pushNeed";
        }
        else{
            model.addAttribute("msg","插入失败");
            return "pushNeed";
        }
    }

    /**
     * 出售二手书
     * @return
     */
    @RequestMapping("/addBook")
    public String addBook(HttpServletRequest request, Model model){
        User user = (User) request.getSession().getAttribute("user");
        int id = user.getId();
        String bookName = request.getParameter("bname");
        String priceStr = request.getParameter("price");
        BigDecimal price = new BigDecimal(priceStr);
        String description = request.getParameter("description");
        String picture = "图片url";
        int flag = dealService.addBook(id, bookName, price, picture, description);
        if (flag == 1){
            model.addAttribute("msg","插入成功");
            return "saleBook";
        }
        else{
            model.addAttribute("msg","插入失败");
            return "saleBook";
        }
    }

    @RequestMapping("/showMyNeed")
    public String showMyNeed(HttpServletRequest request, Model model){
        User user = (User) request.getSession().getAttribute("user");
        int id = user.getId();
        List<Deal> needs = dealService.queryNeedByUid(id);
        model.addAttribute("needs",needs);
        return "showMyNeed";
    }

    @RequestMapping("/delNeed")
    public String delNeed(HttpServletRequest request,Model model){
        String dealIdStr = request.getParameter("dealId");
        int dealId = Integer.parseInt(dealIdStr);
        int flag = dealService.delDealById(dealId);
        if (flag == 1){
            model.addAttribute("msg","插入成功");
            return "/showMyNeed";
        }
        else{
            model.addAttribute("msg","插入失败");
            return "showMyNeed";
        }
    }

    @RequestMapping("/showMySupply")
    public String showMySupply(HttpServletRequest request, Model model){
        User user = (User) request.getSession().getAttribute("user");
        int id = user.getId();
        List<Deal> supplies = dealService.querySupplyByUid(id);
        model.addAttribute("supplies",supplies);
        return "showMySupply";
    }

    @RequestMapping("/delSupply")
    public String delSupply(HttpServletRequest request,Model model){
        String dealIdStr = request.getParameter("dealId");
        int dealId = Integer.parseInt(dealIdStr);
        int flag = dealService.delDealById(dealId);
        if (flag == 1){
            model.addAttribute("msg","删除成功");
            return "/showMySupply";
        }
        else{
            model.addAttribute("msg","删除失败");
            return "/showMySupply";
        }
    }

    @RequestMapping("/showAllNeed")
    @ResponseBody
    public List<Deal> showAllNeed() {
        List<Deal> allNeed = dealService.queryAllNeed();
        //System.out.println(allNeed);
        return allNeed;
    }
    @RequestMapping("/showAllSupply")
    @ResponseBody
    public List<Deal> showAllSupply(){
        List<Deal> allSupplies = dealService.queryAllSupply();
        return allSupplies;
    }
}
