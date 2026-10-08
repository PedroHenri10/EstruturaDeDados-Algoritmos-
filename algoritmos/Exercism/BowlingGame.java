import java.util.ArrayList;
import java.util.List;

class BowlingGame {

    private final List<Integer> rolls = new ArrayList<>();

    private int frame = 1;
    private int rollInFrame = 1;
    private int firstRoll = 0;

    private boolean tenthFrameStrike = false;
    private int bonusRolls = 0;
    private int firstBonusRoll = 0;

    private boolean gameOver = false;

    void roll(int pins) {

        if (pins < 0) {
            throw new IllegalStateException("Negative roll is invalid");
        }

        if (pins > 10) {
            throw new IllegalStateException("Pin count exceeds pins on the lane");
        }

        if (gameOver) {
            throw new IllegalStateException("Cannot roll after game is over");
        }

        if (frame < 10) {

            if (rollInFrame == 1) {
                firstRoll = pins;
                rolls.add(pins);

                if (pins == 10) {
                    frame++;
                } else {
                    rollInFrame = 2;
                }

                return;
            }

            if (firstRoll + pins > 10) {
                throw new IllegalStateException(
                    "Pin count exceeds pins on the lane"
                );
            }

            rolls.add(pins);

            frame++;
            rollInFrame = 1;

            return;
        }

        if (rollInFrame == 1) {

            firstRoll = pins;
            rolls.add(pins);

            if (pins == 10) {
                tenthFrameStrike = true;
                bonusRolls = 2;
                rollInFrame = 3;
            } else {
                rollInFrame = 2;
            }

            return;
        }

        if (rollInFrame == 2) {

            if (firstRoll + pins > 10) {
                throw new IllegalStateException(
                    "Pin count exceeds pins on the lane"
                );
            }

            rolls.add(pins);

            if (firstRoll + pins == 10) {
                bonusRolls = 1;
                rollInFrame = 3;
            } else {
                gameOver = true;
            }

            return;
        }
        
        if (tenthFrameStrike) {

            if (bonusRolls == 2) {
                firstBonusRoll = pins;
                rolls.add(pins);
                bonusRolls = 1;
                return;
            }

            if (firstBonusRoll != 10 && firstBonusRoll + pins > 10) {
                throw new IllegalStateException(
                    "Pin count exceeds pins on the lane"
                );
            }

            rolls.add(pins);
            bonusRolls = 0;
            gameOver = true;

        } else {
            rolls.add(pins);
            bonusRolls = 0;
            gameOver = true;
        }
    }

    int score() {

        if (!gameOver) {
            throw new IllegalStateException(
                "Score cannot be taken until the end of the game"
            );
        }

        int total = 0;
        int index = 0;

        for (int frame = 0; frame < 10; frame++) {

            
            if (rolls.get(index) == 10) {

                total += 10;
                total += rolls.get(index + 1);
                total += rolls.get(index + 2);

                index++;

            } else if (rolls.get(index) + rolls.get(index + 1) == 10) {

                total += 10;
                total += rolls.get(index + 2);

                index += 2;

            } else {

                total += rolls.get(index);
                total += rolls.get(index + 1);

                index += 2;
            }
        }

        return total;
    }
}
