import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

public class Q52Regex {
//      请实现一个函数用来匹配包括'.'和'*'的正则表达式。
//      模式中的字符'.'表示任意一个字符，而'*'表示它前
//      面的字符可以出现任意次（包含0次）。 在本题中，
//      匹配是指字符串的所有字符匹配整个模式。例如，
//      字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) return false;
        return match(str, pattern, 0, 0);
    }

    private boolean match(char[] str, char[] pattern, int sPtr, int pPtr) {
        // pattern和str指针同时结束，则成功匹配
        if (pPtr == pattern.length && sPtr == str.length) return true;
        // pattern指针已经结束，但是str指针还没有结束，则失败
        else if (pPtr == pattern.length && sPtr != str.length) return false;
        // str指针结束，pattern还没有结束，还有可能匹配
        else if (pPtr != pattern.length && sPtr == str.length) {
            if (pattern.length - pPtr == 2 && pattern[pPtr+1] == '*'){
                return true;
            }else {
                return false;
            }
        }else {
            char patternCurr = pattern[pPtr];
            if (patternCurr == '*') return false; // * 必须跟在某个字符后面
            if (pPtr == pattern.length - 1 || (pattern[pPtr + 1] != '*')){
                // pattern的最后一个字符，后面不会有*了
                // 或
                // 后一个不是*，此时只需要比较当前一个字符是否匹配
                if (patternCurr == '.' || str[sPtr] == patternCurr){
                    return match(str, pattern, sPtr + 1, pPtr + 1);
                }else return false;
            } else {
                // 尝试匹配 C*
                // 首先尝试匹配0个strCurr
                boolean result = match(str, pattern, sPtr, pPtr + 2);
                int sPtrTmp = sPtr;
                while (!result && (pattern[pPtr] == '.' || str[sPtrTmp] == pattern[pPtr]) && sPtrTmp < str.length){
                    result = match(str, pattern, sPtrTmp + 1, pPtr + 2);
                    sPtrTmp += 1;
                }
                return result;

            }
        }
    }

    public static void main(String[] args) {
        Q52Regex q = new Q52Regex();
        char[] str = "a".toCharArray();
        char[] pattern = "a.".toCharArray();
        System.out.println(q.match(str, pattern));
    }
}
