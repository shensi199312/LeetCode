import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * 思路：回溯+枝剪
 */
public class _22 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate("", n, n, result);
        return result;
    }

    /**
     * 递归
     * @param item 当前产生的组合字符串
     * @param left 剩余可添加左括号数目
     * @param right 剩余可添加右括号数目
     * @param result
     */
    public void generate(String item, int left, int right, List<String> result)
    {
        if (left == 0 && right == 0)
        {
            result.add(item);
            return;
        }
        if (left > 0)
        {
            generate(item + "(", left - 1, right, result);
        }

        if (left < right)
        {
            generate(item + ")", left, right - 1, result);
        }
    }
}
