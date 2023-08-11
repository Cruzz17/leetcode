package erfen;

/**
 * @Author: {USER}
 * @Date: {DATE} {TIME}
 * @Description: 0000000111
 */
public class Demo278 {
    public int firstBadVersion(int n) {
        int l = 1;
        int r = n;
        while (l < r){
            int mid = l + (r - l) / 2;
            if(!isBadVersion(mid)){
                l = mid + 1;
            }else {
                r = mid ;
            }
        }
        if(isBadVersion(l)) return l;
        return r;
    }
    public  boolean isBadVersion(int version){
        return version >= 4;
    }

    public static void main(String[] args) {
        Demo278 demo278=  new Demo278();
        System.out.println(demo278.firstBadVersion(5));
    }
}
