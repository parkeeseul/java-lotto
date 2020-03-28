package lotto.domain;

import lombok.Getter;

public class WinningLotto {
    private final int ADD_COUNT = 1;
    private final int ZERO = 0;
    @Getter
    private Lotto lotto;
    @Getter
    private int bonusNumber;

    public WinningLotto(Lotto lotto, String bonusValue) {
        this.lotto = lotto;
        this.bonusNumber = Integer.parseInt(bonusValue);
    }

    public int getMatchCount(Lotto lotto) {
        int matchCount = 0;

        for (Integer number : this.lotto.getNumbers()) {
            matchCount += addMatchCount(lotto, number);
        }

        return matchCount;
    }

    public boolean matchBonus(Lotto lotto) {
        return lotto.contains(this.bonusNumber);
    }

    private int addMatchCount(Lotto lotto, int number) {
        if (lotto.contains(number)) {
            return ADD_COUNT;
        }

        return ZERO;
    }
}
