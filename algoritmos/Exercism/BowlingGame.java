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
/*
import java.util.ArrayList;
import java.util.List;

class BowlingGame {

    private final List<Integer> rolls = new ArrayList<>();

    private int frame = 1;
    private int rollInFrame = 1;
    private int firstRoll;

    private boolean tenthFrameStrike;
    private int bonusRolls;
    private int firstBonusRoll;

    private boolean gameOver;

    void roll(int pins) {
        validateRoll(pins);

        if (gameOver) {
            throw new IllegalStateException("Cannot roll after game is over");
        }

        if (frame < 10) {
            rollRegularFrame(pins);
        } else {
            rollTenthFrame(pins);
        }
    }

    private void validateRoll(int pins) {
        if (pins < 0) {
            throw new IllegalStateException("Negative roll is invalid");
        }

        if (pins > 10) {
            throw new IllegalStateException(
                "Pin count exceeds pins on the lane"
            );
        }
    }

    private void rollRegularFrame(int pins) {
        if (rollInFrame == 1) {
            firstRoll = pins;
            rolls.add(pins);

            if (isStrike(pins)) {
                nextFrame();
            } else {
                rollInFrame = 2;
            }

            return;
        }

        validateFrameTotal(pins);

        rolls.add(pins);
        nextFrame();
    }

    private void rollTenthFrame(int pins) {
        if (rollInFrame == 1) {
            firstRoll = pins;
            rolls.add(pins);

            if (isStrike(pins)) {
                tenthFrameStrike = true;
                bonusRolls = 2;
                rollInFrame = 3;
            } else {
                rollInFrame = 2;
            }

            return;
        }

        if (rollInFrame == 2) {
            validateFrameTotal(pins);

            rolls.add(pins);

            if (isSpare(firstRoll, pins)) {
                bonusRolls = 1;
                rollInFrame = 3;
            } else {
                gameOver = true;
            }

            return;
        }

        rollBonus(pins);
    }

    private void rollBonus(int pins) {
        if (tenthFrameStrike && bonusRolls == 2) {
            firstBonusRoll = pins;
            rolls.add(pins);
            bonusRolls = 1;
            return;
        }

        if (tenthFrameStrike &&
            firstBonusRoll != 10 &&
            firstBonusRoll + pins > 10) {

            throw new IllegalStateException(
                "Pin count exceeds pins on the lane"
            );
        }

        rolls.add(pins);
        bonusRolls = 0;
        gameOver = true;
    }

    private void validateFrameTotal(int pins) {
        if (firstRoll + pins > 10) {
            throw new IllegalStateException(
                "Pin count exceeds pins on the lane"
            );
        }
    }

    private boolean isStrike(int pins) {
        return pins == 10;
    }

    private boolean isSpare(int first, int second) {
        return first + second == 10;
    }

    private void nextFrame() {
        frame++;
        rollInFrame = 1;
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

            if (isStrike(index)) {
                total += 10 + rolls.get(index + 1) + rolls.get(index + 2);
                index++;

            } else if (isSpare(index)) {
                total += 10 + rolls.get(index + 2);
                index += 2;

            } else {
                total += rolls.get(index) + rolls.get(index + 1);
                index += 2;
            }
        }

        return total;
    }

    private boolean isStrike(int index) {
        return rolls.get(index) == 10;
    }

    private boolean isSpare(int index) {
        return rolls.get(index) + rolls.get(index + 1) == 10;
    }
}
*/
