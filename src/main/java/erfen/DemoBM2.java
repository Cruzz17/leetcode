package erfen;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class DemoBM2 {
    public int compare(String version1, String version2) {
        // write code here
        int res = 0;
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0;
        while (i < v1.length && i < v2.length) {
            int a = Integer.parseInt(v1[i]);
            int b = Integer.parseInt(v2[i]);
            if (a > b) {
                res = 1;
                break;
            } else if (a < b) {
                res = -1;
                break;
            }
            i++;
        }
        // 如果前面的版本号都相等，那么比较长度，长度长的版本号大，如果长度相等，那么版本号相等，返回0
        if (res == 0) {
            if (v1.length > v2.length) {
                for (int j = i; j < v1.length; j++) {
                    if (Integer.parseInt(v1[j]) != 0) {
                        res = 1;
                        break;
                    }
                }
            } else if (v1.length < v2.length) {
                for (int j = i; j < v2.length; j++) {
                    if (Integer.parseInt(v2[j]) != 0) {
                        res = -1;
                        break;
                    }
                }
            }
        }
        return res;
    }
}
