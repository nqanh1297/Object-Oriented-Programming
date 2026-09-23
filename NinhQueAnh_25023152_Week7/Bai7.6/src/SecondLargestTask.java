import java.util.concurrent.Callable;

public class SecondLargestTask implements Callable<Integer> {
    private int[] arr;
    private int index;

    public SecondLargestTask(int[] arr, int index) {
        this.arr = arr;
        this.index = index;
    }

    @Override
    public Integer call() throws Exception {
        if (arr == null || arr.length < 2) {
            throw new Exception("Mảng " + index + " không đủ phần tử để tìm số lớn thứ hai.");
        }

        Integer max = null;
        Integer second = null;

        for (int num : arr) {
            if (max == null || num > max) {
                second = max;
                max = num;
            } else if (num != max && (second == null || num > second)) {
                second = num;
            }
        }

        if (second == null) {
            throw new Exception("Mảng " + index + " không có số lớn thứ hai hợp lệ.");
        }

        return second;
    }
}