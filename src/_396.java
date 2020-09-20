import java.util.ArrayList;
import java.util.List;

/**
 * 摆动序列
 */
public class _396 {

    private final int BEGIN = 0;

    private final int UP = 1;

    private final int DOWN = 2;

    private int state = BEGIN;

    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2)
        {
            return nums.length;
        }
        int maxLen = 1;
        for (int i = 1; i < nums.length; i++) {
            switch (state){
                case BEGIN:
                    if (nums[i] > nums[i - 1])
                    {
                        state = UP;
                        maxLen++;
                    }
                    if (nums[i] < nums[i - 1]){
                        state = DOWN;
                        maxLen++;
                    }
                    break;
                case UP:
                    if (nums[i] < nums[i - 1])
                    {
                        state = DOWN;
                        maxLen++;
                    }
                    break;
                case DOWN:
                    if (nums[i] > nums[i - 1])
                    {
                        state = UP;
                        maxLen++;
                    }
                    break;
            }
        }
        return maxLen;
    }

    public List<Integer> wiggleSequence(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums.length < 2)
        {
            for (int i = 0; i < nums.length; i++) {
                result.add(nums[i]);
            }
            return result;
        }
        result.add(nums[0]);
        int number = nums[0];
        for (int i = 1; i < nums.length; i++) {
            switch (state){
                case BEGIN:
                    if (nums[i] > nums[i - 1])
                    {
                        state = UP;
                    }
                    if (nums[i] < nums[i - 1]){
                        state = DOWN;
                    }
                    break;
                case UP:
                    if (nums[i] < nums[i - 1])
                    {
                        state = DOWN;
                        result.add(number);
                    }
                    break;
                case DOWN:
                    if (nums[i] > nums[i - 1])
                    {
                        state = UP;
                        result.add(number);
                    }
                    break;
            }
            number = nums[i];
        }
        result.add(number);
        return result;
    }

    public static void main(String[] args) {
        _396 v = new _396();
        List<Integer> integers = v.wiggleSequence(new int[]{1,17,5,10,13,15,10,5,16,8});
        System.out.println(integers);
    }
}
