package org.example.domain.strategy.model.entity;

/*策略权重实体对象*/

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.types.common.Constants;
import org.springframework.util.StringUtils;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StrategyEntity {

    private Long strategyId;
    private String strategyDesc;
    private String ruleModels;

    public String[] ruleModels(){
        if(ruleModels == null || ruleModels.isEmpty())return null;
        return ruleModels.split(Constants.SPLIT);
    }

    public String getRuleModels(){
        String[] ruleModels = this.ruleModels();
        if(ruleModels == null) return null;
        for(String ruleModel : ruleModels){
            if("rule_weight".equals(ruleModel))return ruleModel;
        }
        return null;
    }
}
