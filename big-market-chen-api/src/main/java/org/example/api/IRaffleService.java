package org.example.api;

import org.example.api.dto.RaffleAwardListRequestDTO;
import org.example.api.dto.RaffleAwardListResponseDTO;
import org.example.api.dto.RaffleRequestDTO;
import org.example.api.dto.RaffleResponseDTO;
import org.example.types.model.Response;

import java.util.List;

public interface IRaffleService {
    /**
     * 策略装配接口
     *
     * @param strategyId 策略ID
     * @return 装配结果
     */
    Response<Boolean> strategyArmory(Long strategyId);

    /**
     * 查询抽奖奖品列表配置
     *
     * @param requestDTO 抽奖奖品列表查询请求参数
     * @return 奖品列表数据
     */
    Response<List<RaffleAwardListResponseDTO>> queryRaffleAwardList(RaffleAwardListRequestDTO requestDTO);

    /**
     * 随机抽奖接口
     *
     * @param requestDTO 请求参数
     * @return 抽奖结果
     */
    Response<RaffleResponseDTO> randomRaffle(RaffleRequestDTO requestDTO);
}
