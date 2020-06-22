package cn.fzj.mapper;

import cn.fzj.pojo.Deal;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DealMapper {
    int addDeal(Deal deal);
    List<Deal> queryNeedByUid(int uid);
    int delDealById(int id);
    List<Deal> querySupplyByUid(int uid);
    List<Deal> queryAllSupply();
    List<Deal> queryAllNeed();
}
