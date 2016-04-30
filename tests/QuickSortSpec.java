import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class QuickSortSpec {


    @Test
    public void shouldSortCorrect() {

        List<Integer> list = Arrays.asList(9, 2, 5, 8, 6, 1, 7, 4, 3);

        QuickSort quickSorter = new QuickSort(list);

        List<Integer> result = quickSorter.result();

        Assert.assertArrayEquals("Sort correctly", result.toArray(), new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
    }

    @Test
    public void shouldSortCorrectWhenSomeAreEaual() {

        List<Integer> list = Arrays.asList(4, 5, 2, 2, 1, 4, 3, 2);

        QuickSort quickSorter = new QuickSort(list);

        List<Integer> result = quickSorter.result();

        Assert.assertArrayEquals("Sort correctly", result.toArray(), new Integer[]{1, 2, 2, 2, 3, 4, 4, 5});
    }

    @Test
    public void shouldSupport100Element() {
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> actual = new ArrayList<Integer>();

        for (int i = 0; i < 100000; i++) {
            int randomNum = 1 + (int) (Math.random() * 10000);

            list.add(randomNum);

            actual.add(randomNum);
        }

        Collections.sort(actual);

        QuickSort quickSorter = new QuickSort(list);

        List<Integer> result = quickSorter.result();

        Assert.assertArrayEquals("Sort correctly", result.toArray(), actual.toArray());
    }
}