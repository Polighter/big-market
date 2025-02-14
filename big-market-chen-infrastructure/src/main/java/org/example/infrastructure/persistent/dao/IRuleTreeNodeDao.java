package org.example.infrastructure.persistent.dao;


import org.apache.ibatis.annotations.Mapper;
import org.example.infrastructure.persistent.po.RuleTreeNode;

import java.util.List;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description 规则树节点表DAO
 * @create 2024-02-03 08:43
 */
@Mapper
public interface IRuleTreeNodeDao {

    List<RuleTreeNode> queryRuleTreeNodeListByTreeId(String treeId);

    List<RuleTreeNode> queryRuleLocks(String[] treeIds);

}
