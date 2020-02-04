public class Q1Find {
    public boolean Find0(int target, int [][] array) {
        if (array==null){
            return false;
        }

        int rawFlag = array.length;
        int colFlag = array[0].length;

        for (int i=0; i<rawFlag; ++i){
            for (int j=0; j<colFlag;++j){
                if (array[i][j] > target){
                    colFlag = j;
                }else if (array[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean Find(int target, int [][] array) {
        // from left bottom
        if (array==null){
            return false;
        }

        int nRaw = array.length;
        int nCol = array[0].length;

        int raw = nRaw - 1;
        int col = 0;
        while (raw >= 0 && col < nCol){
            if (array[raw][col] > target){
                raw -= 1;
            }else if (array[raw][col] < target){
                col += 1;
            }else {
                return true;
            }
        }
        return false;
    }
}
