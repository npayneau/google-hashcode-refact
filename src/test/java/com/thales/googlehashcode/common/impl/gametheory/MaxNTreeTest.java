package com.thales.googlehashcode.common.impl.gametheory;

import com.thales.googlehashcode.common.impl.gametheory.stickgame.StickGame;
import com.thales.googlehashcode.common.impl.gametheory.stickgame.StickMove;
import com.thales.googlehashcode.common.model.time.Timer;
import com.thales.googlehashcode.common.impl.gametheory.stickgame.StickGame;
import com.thales.googlehashcode.common.impl.gametheory.stickgame.StickMove;
import org.junit.Test;

public class MaxNTreeTest {

    @Test
    public void testStickGame() {
        final Timer timer = new Timer();

        final MaxNTree<StickMove, StickGame> maxNTree
                = new MaxNTree<>(timer, (rawScores, player) -> rawScores[player]);

        Tester.testAlgo((game, generator, maxdepth) -> maxNTree.best(game, generator, 0, maxdepth), false);
        Tester.testAlgo((game, generator, maxdepth) -> maxNTree.best(game, generator, 0, maxdepth), true);
    }
}
