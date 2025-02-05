package org.example.types.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ResponseCode {

    STRATEGY_RULE_WEIGHT_IS_NULL("EER_BIZ_001","业务异常，策略规则中，权重规则已适用但未配置");

    private String code;
    private String info;


}
