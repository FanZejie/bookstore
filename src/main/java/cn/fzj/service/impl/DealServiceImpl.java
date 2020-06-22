package cn.fzj.service.impl;

import cn.fzj.mapper.DealMapper;
import cn.fzj.mapper.UserMapper;
import cn.fzj.pojo.Deal;
import cn.fzj.service.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class DealServiceImpl implements DealService {
    @Autowired
    Deal deal;
    @Autowired
    DealMapper mapper;
    @Autowired
    UserMapper userMapper;

    @Override
    public int addRequirement(int uid, String bookName, BigDecimal price, String picture, String description) {
        deal.setUid(uid);
        deal.setBookName(bookName);
        deal.setPrice(price);
        deal.setPicture(picture);
        deal.setDescription(description);
        deal.setStatus(0);
        String username = userMapper.queryUsernameById(uid);
        deal.setUsername(username);
        int flag = mapper.addDeal(deal);
        return flag;
    }

    @Override
    public int addBook(int uid, String bookName, BigDecimal price, String picture, String description) {
        deal.setUid(uid);
        deal.setBookName(bookName);
        deal.setPrice(price);
        deal.setPicture(picture);
        deal.setDescription(description);
        deal.setStatus(1);
        String username = userMapper.queryUsernameById(uid);
        deal.setUsername(username);
        int flag = mapper.addDeal(deal);
        return flag;
    }

    @Override
    public List<Deal> queryNeedByUid(int uid) {
        return mapper.queryNeedByUid(uid);
    }

    @Override
    public int delDealById(int id) {
        return mapper.delDealById(id);
    }

    @Override
    public List<Deal> querySupplyByUid(int uid) {
        return mapper.querySupplyByUid(uid);
    }

    @Override
    public List<Deal> queryAllSupply() {
        return mapper.queryAllSupply();
    }

    @Override
    public List<Deal> queryAllNeed() {
        return mapper.queryAllNeed();
    }
}
