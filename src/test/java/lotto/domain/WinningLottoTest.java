package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {
    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        winningLotto = new WinningLotto(new Lotto("1,2,3,4,5,6"), "7");
    }

    @Test
    void getMatchCount() {
        int matchCount = winningLotto.getMatchCount(new Lotto("1,2,3,7,8,9"));

        assertThat(matchCount).isEqualTo(3);
    }

    @Test
    void matchBonus() {
        assertThat(winningLotto.matchBonus(new Lotto("1,2,3,4,5,6"))).isFalse();
        assertThat(winningLotto.matchBonus(new Lotto("1,2,3,4,5,7"))).isTrue();
    }
}
