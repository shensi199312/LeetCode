package simulate;

/**
 * 比较版本
 */
public class S_3 {
    public int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");

        int i = 0;
        while (i < split1.length || i < split2.length)
        {
            int v1 = i > split1.length - 1 ? 0 : Integer.parseInt(split1[i]);
            int v2 = i > split2.length - 1 ? 0 : Integer.parseInt(split2[i]);
            if (v1 == v2)
            {
                i++;
            }else {
                return v1 > v2 ? 1 : -1;
            }
        }
        return 0;
    }
}
