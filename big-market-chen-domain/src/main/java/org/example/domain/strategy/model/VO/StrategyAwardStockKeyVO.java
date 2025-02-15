package org.example.domain.strategy.model.VO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Builder
@Component
@AllArgsConstructor
public class StrategyAwardStockKeyVO {

    private Long strategyId;

    private Integer awardId;

    public StrategyAwardStockKeyVO(){

    }

}
