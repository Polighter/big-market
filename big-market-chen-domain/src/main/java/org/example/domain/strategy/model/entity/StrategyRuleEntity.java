package org.example.domain.strategy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.types.common.Constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StrategyRuleEntity {
    private Long strategyId;
    private Integer awardId;
    private Integer ruleType;
    private String ruleModel;
    private String ruleValue;
    private String ruleDesc;

    /*
    * 获取权重值
    * 数据案例： 4000：102，103，104 5000：102，103，104 6000：102，103，104
    * */
    public Map<String, List<Integer>> getRuleWeightValues(){
        if(!"rule_weight".equals(ruleModel))return null;
        String[] ruleValueGroups = ruleValue.split(Constants.SPACE);
        Map<String, List<Integer>> resultMap = new HashMap<>();
        for(String ruleValueGroup : ruleValueGroups){
            //检查输入是否为空
            if(null == ruleValueGroup || ruleValueGroup.isEmpty()) return resultMap;
            //分割获取键和值
            String[] parts = ruleValueGroup.split(Constants.COLON);
            if(parts.length != 2){
                throw new IllegalArgumentException("rule_weight rule_rule invalid input format" + ruleValueGroup);
            }
            String[] valueStrings = parts[1].split(Constants.SPLIT);
            //要将String类型的转换成Integer类型值
            List<Integer> values = new ArrayList<>(valueStrings.length);
            for(String valueString : valueStrings){
                values.add(Integer.parseInt(valueString));
            }
            resultMap.put(parts[0],values);
        }
        return resultMap;
    }
}
