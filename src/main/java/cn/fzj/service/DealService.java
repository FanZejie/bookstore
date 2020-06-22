package cn.fzj.service;

import cn.fzj.pojo.Deal;

import java.math.BigDecimal;
import java.util.List;

public interface DealService {
    /**
     *
     * @param uid
     * @param bookName
     * @param price
     * @param picture
     * @param description
     * @return
     */
    int addRequirement(int uid, String bookName, BigDecimal price,String picture, String description);

    /**
     *
     * @param uid
     * @param bookName
     * @param price
     * @param picture
     * @param description
     * @return
     */
    int addBook(int uid, String bookName, BigDecimal price,String picture, String description);

    /**
     *查询该用户图书需求
     * @param uid
     * @return
     */
    List<Deal> queryNeedByUid(int uid);

    /**
     * 根据条目id删除条木，需求的和供给的都是用这个
     * @param id
     * @return
     */
    int delDealById(int id);

    /**
     *
     * @param uid
     * @return
     */
    List<Deal> querySupplyByUid(int uid);
    List<Deal> queryAllSupply();
    List<Deal> queryAllNeed();

}
