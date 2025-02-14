package org.example.infrastructure.persistent.dao;


import org.apache.ibatis.annotations.Mapper;
import org.example.infrastructure.persistent.po.RuleTreeNodeLine;

import java.util.List;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description 规则树节点连线表DAO
 * @create 2024-02-03 08:44
 */
@Mapper
public interface IRuleTreeNodeLineDao {

    List<RuleTreeNodeLine> queryRuleTreeNodeLineListByTreeId(String treeId);

}
