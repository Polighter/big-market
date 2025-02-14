package org.example.domain.strategy.model.VO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.Map;

/*
* 决策树值对象
*
* */
@Data
@Builder
@Component
@AllArgsConstructor
public class RuleTreeVO {
    /*规则树ID*/
    private String treeId;
    /*规则树名称*/
    private String treeName;
    /*规则树描述*/
    private String treeDesc;
    /*规则树根节点*/
    private String treeRootRuleNode;
    /*规则节点*/
    private Map<String,RuleTreeNodeVO> treeNodeMap;

    public RuleTreeVO() {

    }
}
