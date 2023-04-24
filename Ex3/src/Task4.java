import java.util.Arrays;

/*
 * Реализовать алгоритм сортировки слиянием
 */
public class Task4 {
    public static void main(String[] args) {
        int[] array = new int[] {12, 6, 4, 1, 15, 10};
        int[] result = mergeSort(array);
        System.out.println(Arrays.toString(result));
    }
    static int[] mergeSort(int[] array) {
        int[] temp1 = Arrays.copyOf(array, array.length);
        int[] temp2 = new int[array.length];
        return mergeSortInner(temp1, temp2, 0, array.length);
    }

    static int[] mergeSortInner(int[] temp1, int[] temp2, int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return temp1;
        }
        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted1 = mergeSortInner(temp1, temp2, startIndex, middle);
        int[] sorted2 = mergeSortInner(temp1, temp2, middle, endIndex);

        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        int[] result = sorted1 == temp1 ? temp2 : temp1;
        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sorted1[index1] < sorted2[index2]
                    ? sorted1[index1++] : sorted2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sorted2[index2++];
        }
        return result;
    }
}


