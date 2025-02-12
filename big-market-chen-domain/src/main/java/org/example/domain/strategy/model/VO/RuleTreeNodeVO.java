package org.example.domain.strategy.model.VO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class RuleTreeNodeVO {

    /*规则树ID*/
    private Integer treeId;
    /*规则树key*/
    private String ruleKey;
    /*规则描述*/
    private String ruleDesc;
    /*规则比值*/
    private String ruleValue;
    /*规则连线*/
    private List<RuleTreeNodeLineVO> treeNodeLineVOList;
}
