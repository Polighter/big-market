package org.example.infrastructure.persistent.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.infrastructure.persistent.po.Award;
import org.example.infrastructure.persistent.po.StrategyAward;

import java.util.List;

@Mapper
public interface IStrategyAwardDao {

    List<StrategyAward> queryStrategyAwardList();


    List<StrategyAward> queryStrategyAwardListByStrategyId(@Param("strategyId")Long strategyId);

    StrategyAward queryStrategyRuleModel(StrategyAward strategyAwardRes);

    StrategyAward queryStrategyAwardRule(@Param("strategyId") Long strategyId, @Param("awardId") Integer awardId);

    void updateStrategyAwardStock(StrategyAward strategyAward);

    StrategyAward queryStrategyAwardEntity(@Param("strategyId")Long strategyId, @Param("awardId")Integer awardId);
}
