import java.lang.reflect.Array;
import java.util.*;

import static javax.swing.UIManager.get;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Main {
    int res[] = {};

    public static void main(String[] args){
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this){
                    notify();
                    try{

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        });
                System.out.println(8);

    }

}
/**
 *

 ArrayList<ArrayList<Integer>> lists = new ArrayList<>(
 new ArrayList(Arrays.asList(
 new ArrayList<>(Arrays.asList(1,2,3,4,5)),
 new ArrayList<>(Arrays.asList(3,2,1,0)))));
 ArrayList<Integer> m = new ArrayList<>(Arrays.asList(1,2,3,4,5));
 ArrayList<Integer> s = new ArrayList<>(Arrays.asList(3,2,1,0));
 int[][] list = {
 {1,2,3},{2,3,4},{4,5,6},{5,6,7}
 };
 lists.get(1).add(2); */
/*
        public static void main(String[] args) {
            int n =3;
            CycThread2v t = new CycThread2v(0);
            CycThread2v t1 = new CycThread2v(1);
            CycThread2v t2 = new CycThread2v(2);
            int i=0;

            new Thread(t).start();
            new Thread(t1).start();
            new Thread(t2).start();
*/
            /**
            while(i<n){
                Thread t_ = new Thread(t);
                t_.setName("thread"+i+":");
                t_.start();
                i++;
            } */
       /* }
}
        int[] pre = new int[]{1,2,4,7,3,5,8,8};
        int[] in = new int[]{4,7,2,1,5,3,8,6};
        TreeNode root = reConstructBinaryTree(pre,in);
        System.out.println(root.val);
        Scanner x = new Scanner(System.in);
        String num = x.nextLine();
        int k = Integer.valueOf(num.split(" ")[1]);
        StringBuilder sb = new StringBuilder(num.split(" ")[0]);
        minNum(sb.toString(),k);*/
/*
        int[][] station = {
                {3, 4}, {1, 2}, {5, 6}, {7, 8}
        };
        String num= ("123456");
        String nu = ("123");
        if(num.startsWith(nu))
            System.out.println("ok");
        long thi =123;
        long
        LinkedList<Integer> list = new LinkedList<>();
        PriorityQueue<Integer> maxl = new PriorityQueue<>();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k =3;
            List<Integer> sum = new ArrayList<>();
            int len = nums.length;
            for (int i = 0; i < k; i++) {
                list.add(nums[i]);
            }
            int i = k;
            while (i <= len) {
                sum.add(findmax(list));
                list.poll();
                if (i == len)
                    break;
                list.add(nums[i]);
                i++;
            }
        System.out.println("ok");
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int j=0;j<2;j++){
            priorityQueue.add(station[i][1]);
        }
        int m =priorityQueue.poll();

        System.out.println(station.length+" "+m);
    }
    public static int findmax(LinkedList<Integer> list){
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList = list;
        linkedList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        return linkedList.getLast();
    }
}
/**
    public static String minNum(String num,int k){
        int[] nums = new int[num.length()];
        for(int i=0;i<num.length();i++){
            nums[i]=Integer.valueOf(num.charAt(i));
        }
        minNum(nums,k);
        return sb.toString();
    }
    public static String minNum(int[] num,int k){
        
        return num.toString();
    }


    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root=reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }
    //前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
    private static TreeNode reConstructBinaryTree(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn) {

        if(startPre>endPre||startIn>endIn)
            return null;
        TreeNode root=new TreeNode(pre[startPre]);

        for(int i=startIn;i<=endIn;i++)
            if(in[i]==pre[startPre]){
                root.left=reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                root.right=reConstructBinaryTree(pre,i-startIn+startPre+1,endPre,in,i+1,endIn);
                break;
            }

        return root;
    }
}
*/
