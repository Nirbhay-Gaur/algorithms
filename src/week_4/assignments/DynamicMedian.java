package week_4.assignments;

import java.util.Collections;
import java.util.PriorityQueue;

public class DynamicMedian {

    PriorityQueue<Integer> minPQ = new PriorityQueue<>();
    PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) {
        int[] array = new int[]{3, 1, 2, 5, 4, 7, 6, 8, 9};
        DynamicMedian dynamicMedian = new DynamicMedian();
        for (int i : array) {
            dynamicMedian.insert(i);
        }
      
        System.out.println(dynamicMedian.removeMedian());
        System.out.println(dynamicMedian.getMedian());

    }

    public void insert(int x) {
        if (maxPQ.size() == 0) maxPQ.add(x);
        else {
            if (x <= maxPQ.peek()) {
                maxPQ.add(x);
            } else {
                minPQ.add(x);
            }

            resizePQs();
        }
    }

    private void resizePQs() {
        if (minPQ.size() > maxPQ.size()) {
            maxPQ.add(minPQ.poll());
        } else if (maxPQ.size() > minPQ.size() + 1) {
            minPQ.add(maxPQ.poll());
        }
    }

    public int getMedian() {
        if (maxPQ.isEmpty()) return -1;
        return maxPQ.peek();
    }

    public int removeMedian() {
        if (maxPQ.isEmpty()) throw new UnsupportedOperationException("No item to remove");
        int median = maxPQ.poll();
        resizePQs();
        return median;
    }

}
