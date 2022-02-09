package test_example.by.morunov;

/**
 * @author Alex Morunov
 */
class GraphProcessing {

    public void longPath(int[][] matrix) {
        int[] result = matrix[0];
        int column;
        int row_ = 0;
        int max = 0;
        for (column = 0; column < matrix.length; column++) {
            for (int row = 0; row < matrix.length; row++) {
                int longPath = matrix[row][column] + max;
                if ((row_ - row) <= Math.abs(1)) {
                    System.out.println("initialVertex -> [" + row + "][" + column + "] = " + longPath);
                }
                if (matrix[row][column] > result[0]) {
                    result[column] = matrix[row][column];
                    row_ = row;
                }
            }
            max += matrix[row_][column];

        }
    }

    public static void main(String[] args) {


        int[][] matrix = {
                {1, 3, 3},
                {2, 1, 4},
                {6, 6, 4}
        };

        GraphProcessing gp = new GraphProcessing();


        gp.longPath(matrix);


    }


}