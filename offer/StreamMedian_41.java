package offer;

import java.util.Comparator;
import java.util.PriorityQueue;

interface PlusAndDiv<T> {
    // 除以二，然后返回T对象
    T plusAndDiv(T other);
}
/**
 * 思路：
 * 维护两个堆，左边大顶堆，右边小顶堆，就像把一个数组从中间分开，一左一右
 * 数据是偶数时，插入到最小堆，否则最大堆
 * 如果新插入的数字比最大堆的堆顶数字小，则先插入到最大堆，然后把最大堆堆顶数字插入到最小堆
 * @param <T> 泛型T, 要实现Comparable接口与PlusAndDiv接口
 */
public class StreamMedian_41 <T extends Comparable<T> & PlusAndDiv<T>> {
    // 最小堆
    private PriorityQueue<T> min = new PriorityQueue<>(Comparable::compareTo);
    // 最大堆
    private PriorityQueue<T> max = new PriorityQueue<>((Comparator.reverseOrder()));
    public void insert(T num) {
        // 如果数据总数目是偶数
        if(((min.size() + max.size()) & 1) == 0) {
            // 如果新插入的数比最大堆里面最大的数要小，则把数字插入到最大堆，并将最大堆的堆顶数字pop，赋值给num
            if(max.size() > 0 && num.compareTo(max.peek()) < 0) {
                max.offer(num);
                num = max.poll();
            }
            min.offer(num);
        } else {
            // 类比上面情况
            if(min.size() > 0 && num.compareTo(min.peek()) > 0) {
                min.offer(num);
                num = min.poll();
            }
            max.offer(num);
        }
    }

    public T getMedian() {
        int size = min.size() + max.size();
        if(size == 0) {
            throw new RuntimeException("没有数据");
        }
        T mid = null;
        if((size & 1) == 1) {
            mid = min.peek();
        } else {
            mid = min.peek().plusAndDiv(max.peek());
        }
        return mid;
    }
}

