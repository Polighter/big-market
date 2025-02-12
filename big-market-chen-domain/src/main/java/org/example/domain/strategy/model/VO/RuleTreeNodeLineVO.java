package org.example.domain.strategy.model.VO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
@AllArgsConstructor
public class RuleTreeNodeLineVO {
    /*规则树Id*/
    private Integer treeId;
    /*规则key节点 from*/
    private String ruleNodeFrom;
    /*规则key节点 to*/
    private String ruleNodeTo;
    /*限定类型*/
    private RuleLimitTypeVO ruleLimitType;
    /*限定值（到下个节点）*/
    private RuleLogicCheckTypeVO ruleLimitValue;

}
