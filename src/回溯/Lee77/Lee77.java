package 回溯.Lee77;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Lee77 {
    LinkedList<Integer> list = new LinkedList();
    List<List<Integer>> result = new ArrayList();
    public static void main(String[] args){
        Lee77 lee77 = new Lee77();
//        lee77.combine(4,2);


    }
    public List<List<Integer>> combine(int n, int k) {
        backtracking(n,k,1);
        return result;
    }
    void backtracking(int n, int k, int startIndex){
        if(list.size() == k){
            result.add(list);
            return;
        }
        for(int i = startIndex; i <= n-(k-list.size())+1; i++){
            list.add(i);
            backtracking(n, k, i+1);
            list.removeLast();
        }
    }
}
