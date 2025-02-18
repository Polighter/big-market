package org.example.types.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ResponseCode {
    SUCCESS("0000", "成功"),
    UN_ERROR("0001", "未知失败"),
    ILLEGAL_PARAMETER("0002", "非法参数"),

    STRATEGY_RULE_WEIGHT_IS_NULL("EER_BIZ_001","业务异常，策略规则中，权重规则已适用但未配置"),
    UN_ASSEMBLED_STRATEGY_ARMORY("EER_BIZ_002","抽奖策略未装配，请通过IStrategyArmory完成装配"),;

    private String code;
    private String info;


}
