package com.thales.googlehashcode.common.impl.gametheory;
import com.thales.googlehashcode.common.impl.gametheory.stickgame.StickGame;
import com.thales.googlehashcode.common.impl.gametheory.stickgame.StickGenerator;
import com.thales.googlehashcode.common.impl.gametheory.stickgame.StickMove;
import com.thales.googlehashcode.common.model.time.TimeoutException;
import com.thales.googlehashcode.common.impl.gametheory.stickgame.StickGame;
import com.thales.googlehashcode.common.impl.gametheory.stickgame.StickGenerator;
import com.thales.googlehashcode.common.impl.gametheory.stickgame.StickMove;

import static junit.framework.Assert.fail;
import static junit.framework.TestCase.assertEquals;

public class Tester {

    public interface IBestMoveEvaluator {
        StickMove findBestMove(StickGame game, StickGenerator generator, int maxdepth) throws TimeoutException;
    }

    public static void testAlgo(IBestMoveEvaluator evaluator, boolean gameStateDuplication) {
        final StickGenerator generator = new StickGenerator();

        StickGame game;
        StickMove move;

        game = new StickGame(1, 2, gameStateDuplication);
        try {
            move = evaluator.findBestMove(game, generator, 1);
            assertEquals(1, move.getSticks());

            for (int player = 0; player < 2; player++) {
                for (int sticks = 2; sticks < 10; sticks++) {
                    for (int depth = 1; depth < 10; depth++) {
                        game = new StickGame(player, sticks, gameStateDuplication);
                        move = evaluator.findBestMove(game, generator, depth);
                        final int sticksExpected = (sticks - 1) % 4;

                        if (sticksExpected != 0) {// There is no solution where we can win and algo can return any move...
                            assertEquals(sticksExpected, move.getSticks());
                        }
                        assertEquals(sticks, game.getSticksRemaining());// ensure algo is restoring correctly game state
                    }
                }
            }
        } catch (TimeoutException e) {
            fail();
        }
    }
}
