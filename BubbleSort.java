public class BubbleSort {
    private static void swap ( int [] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void bubbleSort(int[] array){
        boolean swaped = true;
        int n = array.length;
        while ( swaped ) {
            swaped = false;
            for (int i = 1; i < n; i++) {
                if(array[i - 1] > array[i]){
                    swap(array, i - 1, i);
                    swaped = true;
                }
            }
            n--;
        }
    }
}
