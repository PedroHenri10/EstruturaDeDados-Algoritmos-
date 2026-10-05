import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Matrix2 {

    private final List<List<Integer>> values;

    Matrix(List<List<Integer>> values) {
        this.values = values;
    }

    Set<MatrixCoordinate> getSaddlePoints() {
        Set<MatrixCoordinate> saddlePoints = new HashSet<>();

        for (int row = 0; row < values.size(); row++) {
            for (int col = 0; col < values.get(row).size(); col++) {

                int value = values.get(row).get(col);

                boolean biggestInRow = true;
                for (int column = 0; column < values.get(row).size(); column++) {
                    if (values.get(row).get(column) > value) {
                        biggestInRow = false;
                        break;
                    }
                }

                if (!biggestInRow) {
                    continue;
                }

                boolean smallestInColumn = true;
                for (int r = 0; r < values.size(); r++) {
                    if (values.get(r).get(col) < value) {
                        smallestInColumn = false;
                        break;
                    }
                }

                if (smallestInColumn) {
                    saddlePoints.add(new MatrixCoordinate(row + 1, col + 1));
                }
            }
        }
