import structure.MaxHeap;

/**
 * 最低加油次数
 * 思路:贪心前进,利用最大堆记录每一站的加油量
 */
public class _871 {

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (target <= startFuel)
        {
            return 0;
        }else {
            if (stations.length == 0)
            {
                return -1;
            }

            int l = 0;
            int i = 0;
            int count = 0;
            MaxHeap heap = new MaxHeap();
            while (l + startFuel < target && i < stations.length)
            {
                int[] station = stations[i];
                while (heap.size() > 0 && l + startFuel < station[0])
                {
                    startFuel += heap.pop();
                    count++;
                    if (l + startFuel > target)
                    {
                        return count;
                    }
                }
                if (l + startFuel < station[0])
                {
                    return -1;
                }else {
                    startFuel -= (station[0] - l);
                    l = station[0];
                    heap.push(station[1]);
                }
                i++;
            }
            while (l + startFuel < target && heap.size() > 0)
            {
                startFuel += heap.pop();
                count++;
            }

            if (l + startFuel < target)
            {
                return -1;
            }

            return count;
        }
    }
}
