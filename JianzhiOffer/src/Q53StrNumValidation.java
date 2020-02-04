public class Q53StrNumValidation {

    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0) return false;
        boolean result = false;

        // 基数部分
        int baseEnd = getNum(str, 0);
        if (baseEnd > 0) {
            // 基数部分有效
            if (baseEnd < str.length){
                // 有指数部分
                if ((str[baseEnd] == 'E' || str[baseEnd] == 'e')){
                    // 有效的指数开头
                    int expEnd = getInt(str, baseEnd+1);
                    if (expEnd > baseEnd + 1 && expEnd == str.length) {
                        // 有效的指数，且到末尾
                        result = true;
                    }else {
                        // 无效的指数
                        result = false;
                    }
                }else {
                    // 无效的指数开头
                    result = false;
                }
            }else {
                // 无指数部分，只有基数部分
                result = true;
            }
        } else {
            // 基数部分无效
            result = false;
        }


        return result;
    }

    private int getNum(char[] str, int start){
        if (start >= str.length) return -1;

        if (str[start] == '+' || str[start] == '-'){
            // 开头是符号，有效
            start += 1;
        } else if (isNum(str[0])){
            // 开头是数字，有效
            start = start;
        } else {
            // 开头是其它，无效
            return -1;
        }

        int pointCnt = 0;
        int ptr = start;
        while (ptr < str.length && (isNum(str[ptr]) || str[ptr] == '.')){
            if (str[ptr] == '.' && (ptr == str.length - 1 || pointCnt > 0)){
                ptr = -1;
                break;
            }else if (str[ptr] == '.'){
                pointCnt += 1;
            }
            ptr += 1;
        }
        return ptr;
    }

    private int getInt(char[] str, int start){
        if (start >= str.length) return -1;

        if (str[start] == '+' || str[start] == '-'){
            // 开头是符号，有效
            start += 1;
        } else if (isNum(str[0])){
            // 开头是数字，有效
            start = start;
        } else {
            // 开头是其它，无效
            return -1;
        }

        int ptr = start;
        while (ptr < str.length && isNum(str[ptr])){
            ptr += 1;
        }
        return ptr;
    }

    private boolean isNum(char c){
        return c >= '0' && c <= '9';
    }

    public static void main(String[] args) {
        Q53StrNumValidation q = new Q53StrNumValidation();
        System.out.println(q.isNumeric("-.123".toCharArray()));
    }
}
