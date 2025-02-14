package org.example.infrastructure.persistent.dao;


import org.apache.ibatis.annotations.Mapper;
import org.example.infrastructure.persistent.po.RuleTree;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description 规则树表DAO
 * @create 2024-02-03 08:42
 */
@Mapper
public interface IRuleTreeDao {

    RuleTree queryRuleTreeByTreeId(String treeId);

}
