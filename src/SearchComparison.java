public class SearchComparison {

    static int[] listArray = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200};

    public static void main(String[] args) {
        int[] keys = {30, 100, 170, 999};
        String[] keyLabels = {"30", "100", "170", "Not in List (999)"};

        System.out.printf("%-25s %-20s %-15s %-20s%n", "Search Key", "Search Type", "Step Count", "Execution Time (ns)");
        System.out.println("----------------------------------------------------------------------------------------");

        for (int i = 0; i < keys.length; i++) {
            int key = keys[i];
            String label = keyLabels[i];

            runAndPrint(label, "Linear Search", linearSearch(listArray, key));
            runAndPrint(label, "Binary Search", binarySearch(listArray, key));
            runAndPrint(label, "Interpolation Search", interpolationSearch(listArray, key));
            runAndPrint(label, "Exponential Search", exponentialSearch(listArray, key));
        }
    }

    static void runAndPrint(String label, String type, Result result) {
        System.out.printf("%-25s %-20s %-15d %-20d%n", label, type, result.steps, result.time);
    }

    static class Result {
        int steps;
        long time;

        Result(int steps, long time) {
            this.steps = steps;
            this.time = time;
        }
    }

    static Result linearSearch(int[] arr, int key) {
        int steps = 0;
        long start = System.nanoTime();
        for (int val : arr) {
            steps++;
            if (val == key) break;
        }
        long end = System.nanoTime();
        return new Result(steps, end - start);
    }

    static Result binarySearch(int[] arr, int key) {
        int steps = 0;
        int low = 0, high = arr.length - 1;
        long start = System.nanoTime();

        while (low <= high) {
            steps++;
            int mid = (low + high) / 2;
            if (arr[mid] == key) break;
            else if (arr[mid] < key) low = mid + 1;
            else high = mid - 1;
        }

        long end = System.nanoTime();
        return new Result(steps, end - start);
    }

    static Result interpolationSearch(int[] arr, int key) {
        int steps = 0;
        int low = 0, high = arr.length - 1;
        long start = System.nanoTime();

        while (low <= high && arr[low] != arr[high]) {
            steps++;
            int pos = low + ((high - low) * (key - arr[low])) / (arr[high] - arr[low]);
            if (pos < 0 || pos >= arr.length) break;
            if (arr[pos] == key) break;
            else if (arr[pos] < key) low = pos + 1;
            else high = pos - 1;
        }

        long end = System.nanoTime();
        return new Result(steps, end - start);
    }

    static Result exponentialSearch(int[] arr, int key) {
        int steps = 1;
        int i = 1;
        long start = System.nanoTime();

        if (arr[0] == key) return new Result(steps, System.nanoTime() - start);

        while (i < arr.length && arr[i] <= key) {
            steps++;
            i *= 2;
        }

        int low = i / 2;
        int high = Math.min(i, arr.length - 1);

        while (low <= high) {
            steps++;
            int mid = (low + high) / 2;
            if (arr[mid] == key) break;
            else if (arr[mid] < key) low = mid + 1;
            else high = mid - 1;
        }

        long end = System.nanoTime();
        return new Result(steps, end - start);
    }
}

