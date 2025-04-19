public class ArrayProblem {

    public void rotateArray(int[] arr, int k) {
        int rotation = arr.length - k;

        int counter = 0;
        do {
            for (int i = 0; i < arr.length - 1; i++) {
                int temp = arr[i + 1];
                arr[i + 1] = arr[i];
                arr[i] = temp;
            }
            counter++;

        } while (counter != rotation);

        for (int j : arr) {
            System.out.print(j + " ");
        }
    }

    public void sortArray(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            
        }
    }

    public void removeDuplicates(int[] arr) {
        for (int i = 0; i < arr.length; i++) {

        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        ArrayProblem problem = new ArrayProblem();
        problem.rotateArray(arr, 2);
        System.out.println();
    }
}
