package lotto.domain;

import lombok.Getter;
import lotto.type.RankType;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;

public class LottoCalculator {
    @Getter
    private int rank1Count;
    @Getter
    private int rank2Count;
    @Getter
    private int rank3Count;
    @Getter
    private int rank4Count;
    @Getter
    private int rank5Count;

    public LottoCalculator(WinningLotto winningLotto, List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            RankType rankType = RankType.getRank(winningLotto.getMatchCount(lotto), winningLotto.matchBonus(lotto));

            addRankCount(rankType);
        }
    }

    public BigDecimal getWinningPercentage(int investment) {
        return new BigDecimal(getTotalReward()).divide(new BigDecimal(investment), new MathContext(2, RoundingMode.DOWN));
    }

    private int getTotalReward() {
        return RankType.RANK1.totalReward(rank1Count) +
                RankType.RANK2.totalReward(rank2Count) +
                RankType.RANK3.totalReward(rank3Count) +
                RankType.RANK4.totalReward(rank4Count) +
                RankType.RANK5.totalReward(rank5Count);
    }

    private void addRankCount(RankType rankType) {
        if (rankType == RankType.RANK1) {
            rank1Count++;
        }

        if (rankType == RankType.RANK2) {
            rank2Count++;
        }

        if (rankType == RankType.RANK3) {
            rank3Count++;
        }

        if (rankType == RankType.RANK4) {
            rank4Count++;
        }

        if (rankType == RankType.RANK5) {
            rank5Count++;
        }
    }
}
