public class SearchAlgorithms {

    public void linearSearch(int[] arr, int key) {
        int count = 0;

        boolean found = false;

        for (int j : arr) {
            count++;

            if (j == key) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Liner Search of Step : " + count);
        } else {
            System.out.println("Value is Not Found");
        }
    }

    public void binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int count = 0;
        boolean found = false;

        int mid;

        while (low <= high) {
            count++;

            mid = (low + high) / 2;
            if (arr[mid] == key) {
                found = true;
                break;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (found) {
            System.out.println("Binary Search Step : " + count);
        } else {
            System.out.println("Value is Not Found");
        }
    }

    public void interpolation(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int count = 0;
        boolean found = false;

        int mid;

        while (low <= high) {
            count++;
            mid = low + (((high - low) * (key - arr[low])) / (arr[high] - arr[low]));
            if (arr[mid] == key) {
                found = true;
                break;
            } else {
                if (arr[mid] < key) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        if (found) {
            System.out.println("Interpolation Search Step : " + count);
        } else {
            System.out.println("Value is Not Found");
        }
    }

    public void exponentialSearch(int[] arr, int key) {
        int m, low = 0, high = arr.length - 1, mid = 0, i = 1, count = 0;
        m = (int) Math.pow(2, i);
        boolean found = false;

        if (arr[0] == key) {
            return;
        }

        while (arr[mid] <= key && m < arr.length) {
            i++;
            m = (int) Math.pow(2, i);
            count++;
            while (low <= high) {
                count++;
                mid = (low + high) / 2;
                if (arr[mid] == key) {
                    found = true;
                    break;
                } else if (arr[mid] < key) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        if (found) {
            System.out.println("Exponential Search Step : " + count);
        } else {
            System.out.println("Value is Not Found");
        }
    }

    //    Driver Method
    public static void main(String[] args) {
        int[] arr = new int[]{
                10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200};

        int key = 150;
        SearchAlgorithms searchAlgorithms = new SearchAlgorithms();
        searchAlgorithms.linearSearch(arr, key);
        searchAlgorithms.binarySearch(arr, key);
        searchAlgorithms.interpolation(arr, key);
        searchAlgorithms.exponentialSearch(arr, key);
    }
}
