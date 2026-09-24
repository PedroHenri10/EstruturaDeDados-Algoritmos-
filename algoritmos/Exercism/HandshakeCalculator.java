import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class HandshakeCalculator {

    List<Signal> calculateHandshake(int number) {

        List<Signal> signals = new ArrayList<>();

        Signal[] actions = {
                Signal.WINK,
                Signal.DOUBLE_BLINK,
                Signal.CLOSE_YOUR_EYES,
                Signal.JUMP
        };

        for (int i = 0; i < actions.length; i++) {
            int bit = 1 << i;

            if ((number & bit) != 0) {
                signals.add(actions[i]);
            }
        }

        if ((number & 16) != 0) {
            Collections.reverse(signals);
        }

        return signals;
    }
}
