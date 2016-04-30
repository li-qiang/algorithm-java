import java.util.ArrayList;
import java.util.List;

public class QuickSort {

    private List<Integer> originList;
    private boolean reversed = false;
    private int prevIndex = 0;
    private int nextIndex;
    private int baseIndex;


    public QuickSort(List<Integer> list) {
        originList = list;
        baseIndex = list.size() - 1;
        nextIndex = list.size() - 1;
    }

    public List<Integer> result() {

        if (originList.size() == 0 || originList.size() == 1) return originList;

        if (originList.size() == 2) {
            if (originList.get(0) > originList.get(1)) change(originList, 0, 1);
            return originList;
        }

        return actuallySort();
    }

    private int getBase() {
        return originList.get(baseIndex);
    }

    private List<Integer> actuallySort() {
        for (int i = 0; i < originList.size(); i++) {
            sortPartial(originList);
        }

        List<Integer> prev = new ArrayList(originList.subList(0, baseIndex));
        List<Integer> next = new ArrayList(originList.subList(baseIndex+1, originList.size()));

        if (prev.size() > 1) prev = new QuickSort(prev).result();
        if (next.size() > 1) next = new QuickSort(next).result();

        prev.add(getBase());
        prev.addAll(next);
        return prev;
    }

    private void sortPartial(List<Integer> arr) {
        int base = getBase();
        if (reversed) {
            Integer item = arr.get(nextIndex);
            if (base < item) {
                nextIndex--;
                return;
            }
            prevIndex++;
            this.change(arr, nextIndex, baseIndex);
            baseIndex = nextIndex;
            reversed = false;
        } else {
            Integer item = arr.get(prevIndex);
            if (base > item) {
                prevIndex++;
                return;
            }
            nextIndex--;
            change(arr, baseIndex, prevIndex);
            baseIndex = prevIndex;
            reversed = true;
        }
    }

    private void change(List<Integer> arr, int i, int j) {
        int first = arr.get(i);
        int second = arr.get(j);
        arr.set(i, second);
        arr.set(j, first);
    }

}
