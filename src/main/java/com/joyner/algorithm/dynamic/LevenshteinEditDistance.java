package com.joyner.algorithm.dynamic;

/**
 * LevenshteinEditDistance algorithm
 *
 * the dissection of the implement shows in the diagram:src/main/resources/dissect diagram .jpg
 *
 */
public class LevenshteinEditDistance {

    class Cell {
        private int value;
        private boolean isTop = false;
        private boolean isLeft = false;
        private boolean isDiagonal = false;

        public Cell createLeftCell(int value) {
            this.setValue(value);
            this.setLeft(true);
            return  this;
        }

        public Cell createTopCell(int value) {
            this.setValue(value);
            this.setTop(true);
            return  this;
        }

        public Cell createDiagonalCell(int value) {
            this.setValue(value);
            this.setDiagonal(true);
            return  this;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public boolean isTop() {
            return isTop;
        }

        public void setTop(boolean top) {
            isTop = top;
        }

        public boolean isLeft() {
            return isLeft;
        }

        public void setLeft(boolean left) {
            isLeft = left;
        }

        public boolean isDiagonal() {
            return isDiagonal;
        }

        public void setDiagonal(boolean diagonal) {
            isDiagonal = diagonal;
        }
    }


    public void ditDistancee(String source,String target) {
        if (source == null || target == null) {
            throw new RuntimeException("the parameter must be not null,please check it!");
        }

        char[] sourceCharArr = source.toCharArray();
        char[] targetCharArr = target.toCharArray();

        int rowNumbers = targetCharArr.length + 1;
        int colNumbers = sourceCharArr.length + 1;
        //
        int[][] metri = new int[rowNumbers][colNumbers];

        //init metri
        for (int row = 0; row < rowNumbers; row++) {
            for (int col = 0; col < colNumbers; col++) {
                //init the first row
                if (row == 0) {
                    metri[row][col] = col;
                }
                //init the first col
                if (col == 0) {
                    metri[row][col] = row;
                }

                //calculate the others
                if (row != 0 && col != 0) {
                    char s = sourceCharArr[col - 1];
                    char t = targetCharArr[row - 1];
                    int left = metri[row][col-1];
                    int top = metri[row - 1][col];
                    int diagonal = metri[row - 1][col-1];
                    int minimum = getMinimum(left,top,diagonal).getValue();
                    //if s and t is the same,then get the minimum else minimum +1
                    if (s == t ) {
                        metri[row][col] = minimum;
                    } else {
                        metri[row][col] = minimum + 1;
                    }
                }

            }
        }

        //calculate the operation path
        int lastRow = rowNumbers - 1;
        int lastCol = colNumbers - 1;
        while (true) {
            int last = metri[lastRow][lastCol];

            int left = Integer.MAX_VALUE;
            if (lastCol > 0) {
                left = metri[lastRow][lastCol - 1];
            }

            int top = Integer.MAX_VALUE;
            if (lastRow > 0 ) {
                top = metri[lastRow - 1][lastCol];
            }

            int diagonal = Integer.MAX_VALUE;
            if (lastRow > 0 && lastRow > 0) {
                diagonal = metri[lastRow - 1][lastCol - 1];
            }


            Cell c = getMinimum(left, top,diagonal);
            if (last != c.getValue()) {
                if (c.isLeft) {
                    System.out.println("deleting char:" + sourceCharArr[lastCol -1]);
                    if (lastCol != 0) {
                        lastCol--;
                    }

                }
                if (c.isTop) {
                    System.out.println("inserting char:" + sourceCharArr[lastCol -1]);
                    if (lastRow != 0) {
                        lastRow--;
                    }
                }

                if (c.isDiagonal) {
                    System.out.println("replacing char:" + sourceCharArr[lastCol -1] + " to " + targetCharArr[lastRow - 1]);
                    if (lastRow != 0) {
                        lastRow--;
                    }
                    if (lastCol != 0) {
                        lastCol--;
                    }

                }
            } else {
                if (lastRow != 0) {
                    lastRow--;
                }
                if (lastCol != 0) {
                    lastCol--;
                }
            }


            if (lastRow == 0 && lastCol == 0) {
                break;
            }




        }




        int result = metri[rowNumbers-1][colNumbers-1];
        System.out.println(result);

    }


    public  Cell getMinimum(int left,int top,int diagonal) {
        Cell diagonalCell = new Cell().createDiagonalCell(diagonal);
        Cell result = diagonalCell;
        int minimum = diagonal;
        if (left < minimum) {
            minimum = top;
            Cell leftCell = new Cell().createLeftCell(left);
            result = leftCell;
        }
        if (top < minimum ) {
            minimum = diagonal;
            Cell topCell = new Cell().createTopCell(top);
            result = topCell;
        }
        return  result;
    }



    public static void main(String[] args) {
        LevenshteinEditDistance levenshteinEditDistance = new LevenshteinEditDistance();
        levenshteinEditDistance.ditDistancee("abcdef" , "azced");
    }


}
