class RailFenceCipher {
    private int rows;

    RailFenceCipher(int rows) {
        this.rows = rows;
    }

    String getEncryptedData(String message) {
        StringBuilder[] rails = new StringBuilder[rows];

        for (int i = 0; i < rows; i++) {
            rails[i] = new StringBuilder();
        }

        int row = 0;
        int direction = 1;

        for (int i = 0; i < message.length(); i++) {
            rails[row].append(message.charAt(i));

            if (row == rows - 1) {
                direction = -1;
            } else if (row == 0) {
                direction = 1;
            }

            row += direction;
        }

        StringBuilder sb = new StringBuilder();

        for (StringBuilder rail : rails) {
            sb.append(rail);
        }

        return sb.toString();
    }

    String getDecryptedData(String message) {
        if (rows <= 1 || message.length() <= 1) {
            return message;
        }

        int[] railPattern = new int[message.length()];

        int row = 0;
        int direction = 1;

        for (int i = 0; i < message.length(); i++) {
            railPattern[i] = row;

            if (row == rows - 1) {
                direction = -1;
            } else if (row == 0) {
                direction = 1;
            }

            row += direction;
        }

        int[] railPositions = new int[rows];

        for (int rail : railPattern) {
            railPositions[rail]++;
        }

        StringBuilder[] rails = new StringBuilder[rows];

        int position = 0;

        for (int i = 0; i < rows; i++) {
            rails[i] = new StringBuilder(
                    message.substring(position, position + railPositions[i])
            );

            position += railPositions[i];
        }

        int[] indexes = new int[rows];
        StringBuilder result = new StringBuilder();

        for (int rail : railPattern) {
            result.append(rails[rail].charAt(indexes[rail]));
            indexes[rail]++;
        }

        return result.toString();
    }
}
