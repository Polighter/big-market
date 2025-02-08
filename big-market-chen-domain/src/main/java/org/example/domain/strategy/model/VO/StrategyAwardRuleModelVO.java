package org.example.domain.strategy.model.VO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.domain.strategy.service.rule.factory.DefaultLogicFactory;
import org.example.types.common.Constants;

import java.util.ArrayList;
import java.util.List;


/*
* 抽奖规则的值对象，仅限从数据库中查询返回
* */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StrategyAwardRuleModelVO {
    private String ruleModels;

    public String[] raffleCenterRuleModelList(){
        List<String> ruleModelList = new ArrayList<>();
        String[] ruleModelValues = ruleModels.split(Constants.SPLIT);
        for (String ruleModel : ruleModelValues){
            if(DefaultLogicFactory.LogicModel.isCenter(ruleModel)){
                ruleModelList.add(ruleModel);
            }
        }
        return ruleModelList.toArray(new String[0]);
    }
}
