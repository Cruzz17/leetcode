package listnode;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo134 {

    public int canCompleteCircuit1(int[] gas, int[] cost) {

        Node root = new Node();
        root.setGas(gas[0]);
        root.setCost(cost[0]);

        boolean res = false;
        Node index = root;
        for (int i = 1; i < gas.length; i++) {
            Node node = new Node();
            node.setCost(cost[i]);
            node.setGas(gas[i]);
            index.next = node;
            index = index.next;
        }
        index.next = root;
        Node head = new Node();
        head.next = root;
        int count = 0;
        // 分别从各个起点出发
        for (int i = 0; i < cost.length; i++) {
            // 先找到当前节点
            head = head.next;
            if (judge(head, 0, cost.length)) {
                return i;
            }
        }
        return -1;
    }

    public boolean judge(Node head, int deposit, int size) {
        int count = 0;
        while (count < size) {
            if (head.gas + deposit >= head.cost) {
                deposit = head.gas + deposit - head.cost;
                head = head.next;
            } else {
                return false;
            }
            count++;
        }
        return true;
    }

    static class Node {
        int gas;
        int cost;
        Node next;

        public int getCost() {
            return cost;
        }

        public Node getNext() {
            return next;
        }

        public int getGas() {
            return gas;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }

        public void setGas(int gas) {
            this.gas = gas;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int [] dp = new int[cost.length];
        int sum = 0;
        int max = -1;
        int index = -1;
        for (int i = 0; i < dp.length; i++) {
            dp[i] = gas[i] - cost[i];
            if(dp[i] > 0 && dp[i] > max){
                max = dp[i];
                index = i;
            }
            sum+= dp[i];
        }
        if(dp.length == 1 && dp[0] >=0) return 0;
        if(sum < 0) return -1;
        for (int i = 0; i < dp.length; i++) {
            if( dp[i] > 0 && judge(dp, i) ){
                return i;
            }
        }
        return index;
    }
    public boolean judge(int[] dp, int index) {
        int count = 0;
        int j = index + 1;
        int sum = dp[index];
        while (count < dp.length - 1) {
            if(sum<0) return false;
            if( j >= dp.length) {
                j = j -dp.length;
            }
            sum+=dp[j];
            count++;
            j++;
        }
        return true;
    }

    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int n = gas.length;
        int sum = 0;
        int min = 0;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            sum += gas[i] - cost[i];
            if (sum < min) {
                min = sum;
                idx = i + 1;
            }
        }
        return sum < 0 ? -1 : idx;
    }

    public static void main(String[] args) {
        Demo134 demo134 = new Demo134();
        int[] gas = new int[]{ 6,1,4,3,5 };
        int[] cost = new int[]{3,8,2,4,2};
                            // 3,-7,2,-1,3
        System.out.println(demo134.canCompleteCircuit2(gas, cost));
    }
}


