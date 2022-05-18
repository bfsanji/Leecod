package 回溯.Lee17;

import java.util.ArrayList;
import java.util.List;

public class Lee17 {
    List<String> list = new ArrayList<>();
    StringBuilder temp = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return list;
        }
        //初始对应所有的数字，为了直接对应2-9，新增了两个无效的字符串""
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        //迭代处理
        backTracking(digits, numString, 0);
        return list;
    }
    void backTracking(String digits, String[] numString, int index){
        int digit = Integer.parseInt(digits);
        if(temp.length() == digits.length()){
            list.add(temp.toString());
            return;
        }
        String letter = numString[digits.charAt(index) - '0'];
        for(int i =0; i<letter.length(); i++){
            temp.append(letter.charAt(i));
            backTracking(digits, numString, index+1);
            temp.deleteCharAt(temp.length() -1);
        }
    }
}
