package 回溯.Lee39;



import java.util.*;

public class Lee39 {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        System.out.println(linkedList.contains(1));
        String s = "123a";
        System.out.println(s.substring(0,2));
//        System.out.println(Integer.parseInt(s));
        LinkedList linkedList1 = new LinkedList();
        linkedList1.add(1);
        linkedList1.set(0,2);
        System.out.println(linkedList1);
        char[][] i = new char[2][2];
        i[0][0] = '1';
        i[1][0] = '3';
        i[1][1] = '2';
        i[0][1] = 1;
        for(char[] n : i){
//            for (char m:n)
//            System.out.println(n);
            System.out.println(new String(n));


        }

    }
    List<List<Integer>> result = new ArrayList();
    LinkedList<Integer> path = new LinkedList();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracking(candidates, target,0,0);
        return result;
    }
    void backtracking(int[] candidates, int target,int sum, int startIndex){
        if(sum == target){
            result.add(new ArrayList(path));
            return;
        }
        if(sum > target){
            return;
        }

        for(int i = startIndex; i<candidates.length; i++){
            sum += candidates[i];
            path.add(candidates[i]);
            backtracking(candidates,target,sum,i+1);
            sum-=candidates[i];
            path.removeLast();
        }
    }
}
