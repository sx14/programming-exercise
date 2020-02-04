import java.util.ArrayList;

public class Q19PrintMatrix {

    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        if (matrix == null){
            return null;
        }

        ArrayList<Integer> out = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0){
            return out;
        }

        int rowNum = matrix.length;
        int colNum = matrix[0].length;

        int cycleNum = (rowNum<colNum?rowNum:colNum) / 2;
        for (int c = 0; c < cycleNum; ++c){
            int startRow = c;
            int startCol = c;
            // print one cycle
            // ttttr
            // l000r
            // lbbbb
            // print top
            for (int j=startCol; j<colNum-startCol-1; j++){
                out.add(matrix[startRow][j]);
            }
            // print right
            for (int i=startRow; i<rowNum-startRow-1;++i){
                out.add(matrix[i][colNum-startCol-1]);
            }
            // print bottom
            for (int j=colNum-startCol-1;j>startCol;--j){
                out.add(matrix[rowNum-startRow-1][j]);
            }
            // print left
            for (int i=rowNum-startRow-1;i>startRow;--i){
                out.add(matrix[i][startCol]);
            }
        }

        if (cycleNum > 0){
            if ((rowNum<colNum?rowNum:colNum) % 2 == 1){
                if (colNum > rowNum){
                    // fill middle row
                    for (int j=cycleNum;j<colNum-cycleNum;++j){
                        out.add(matrix[cycleNum][j]);
                    }
                }else{
                    // fill middle col
                    for (int i=cycleNum;i<rowNum-cycleNum;++i){
                        out.add(matrix[i][cycleNum]);
                    }
                }
            }
        }else {
            // only one row or one col
            for (int i=0;i<rowNum;++i){
                for (int j=0;j<colNum;++j){
                    out.add(matrix[i][j]);
                }
            }
        }
        return out;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        ArrayList out = printMatrix(matrix);
        int a = 1;
    }
}
