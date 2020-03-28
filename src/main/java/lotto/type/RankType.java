package lotto.type;

public enum RankType {
    NO_RANK(0, 0),
    RANK1(2000000000, 6),
    RANK2(30000000, 5),
    RANK3(1500000, 5),
    RANK4(50000, 4),
    RANK5(5000, 3);

    private int reward;
    private int condition;

    RankType(int reward, int condition) {
        this.reward = reward;
        this.condition = condition;
    }

    public int totalReward(int count) {
        return this.reward * count;
    }

    public static RankType getRank(int condition, boolean bonusMatch) {
        if (condition == RANK2.condition && bonusMatch) {
            return RANK2;
        }

        if (condition == RANK3.condition) {
            return RANK3;
        }

        if (condition == RANK4.condition) {
            return RANK4;
        }

        if (condition == RANK5.condition) {
            return RANK5;
        }

        if (condition < RANK5.condition) {
            return NO_RANK;
        }

        return RANK1;
    }
}
