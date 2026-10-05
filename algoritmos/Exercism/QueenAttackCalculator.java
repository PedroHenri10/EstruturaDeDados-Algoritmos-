class Queen{
    private int row;
    private int column;

    public Queen(int row, int column) {
        if(row < 0){
            throw new IllegalArgumentException("Queen position must have positive row.");
        }

        if(row > 7){
            throw new IllegalArgumentException("Queen position must have row <= 7.");
        }

        if(column < 0){
            throw new IllegalArgumentException("Queen position must have positive column.");
        }

        if(column > 7){
            throw new IllegalArgumentException("Queen position must have column <= 7.");
        }

        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}

class QueenAttackCalculator {
    private Queen queen1;
    private Queen queen2;

    QueenAttackCalculator(Queen queen1, Queen queen2) {
        if(queen1 == null || queen2 == null){
            throw new IllegalArgumentException("You must supply valid positions for both Queens.");
        }

        if(queen1.getRow() == queen2.getRow() && queen1.getColumn() == queen2.getColumn()){
            throw new IllegalArgumentException("Queens cannot occupy the same position.");
        }
        this.queen1= queen1;
        this.queen2=queen2;
    }

    boolean canQueensAttackOneAnother() {
        if(queen1.getRow() == queen2.getRow() || queen1.getColumn() == queen2.getColumn()){
            return true;
        }
        if(Math.abs(queen1.getRow() - queen2.getRow()) == Math.abs(queen1.getColumn() - queen2.getColumn())){
            return true;
        }
        return false;
    }

}
