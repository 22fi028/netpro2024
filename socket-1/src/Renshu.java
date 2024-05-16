public class Renshu {
    // xを2倍にして返す関数
    public int doubleValue(int x) {
        return x * 2;
    }

    // ここに続きを実装していく。

    // 1からnまでの整数の合計値を返す。
    public int sumUpToN(int n) {

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }

        return sum;
    }

    // p から q までの整数の合計値を返す。
    public int sumFromPtoQ(int p, int q) {

        if (p > q) {
            return -1;
        }

        int sum = 0;

        for (int i = p; i <= q; i++) {
            sum += i;
        }

        return sum;
    }

    // 配列 a[] の指定された index から以降の要素の合計値を返す。
    // 不正な index の場合は -1 を返す。
    public int sumFromArrayIndex(int[] a, int index) {
        if (index >= a.length || index < 0)
            return -1;

        int sum = 0;

        for (int i = index; i <= a.length - 1; i++) {
            sum += a[i];
        }

        return sum;
    }

    // 配列 a の中で最小の値を返す。
    public int selectMinValue(int[] a) {

        int min = a[0];

        for (int i = 1; i < a.length; i++) {
            if (min > a[i])
                min = a[i];
        }

        return min;
    }

    // 配列 a の中で最大の値を返す。
    public int selectMaxValue(int[] a) {

        int max = a[0];

        for (int i = 1; i < a.length; i++) {
            if (max < a[i])
                max = a[i];
        }

        return max;
    }

    // 配列 a の中で最小の値が入っている要素の位置（index）を返す。
    // 最小値が複数の場合は最小のindexを返す。
    public int selectMinIndex(int[] a) {
        int min = a[0];
        int index = 0;

        for (int i = 1; i < a.length; i++) {
            if (min > a[i]) {
                min = a[i];
                index = i;
            }
        }

        return index;
    }

    // 配列 a の中で最大の値が入っている要素の位置（index）を返す。
    // 最大値が複数の場合は最小のindexを返す。
    public int selectMaxIndex(int[] a) {
        int max = a[0];
        int index = 0;

        for (int i = 1; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
                index = i;
            }
        }

        return index;
    }

    // 配列 p の i 番目と j 番目の要素を入れ替える。
    
    public void swapArrayElements(int[] p, int i, int j) {
        int temp = p[j];
        p[j] = p[i];
        p[i] = temp;
    }

    // 同じ長さの二つの配列 a と b の内容を入れ替える。
    public boolean swapTwoArrays(int[] a, int[] b) {
        if (a.length != b.length) {
            return false;
        } else {
            int[] temp = new int[a.length];
            for (int i = 0; i < a.length; i++) {
                temp[i] = a[i];
            }
            for (int i = 0; i < a.length; i++) {
                a[i] = b[i];
            }
            for (int i = 0; i < a.length; i++) {
                b[i] = temp[i];
            }
            return true;
        }
    }

    // BubbleSort
    public void bubbleSort(int[] a) {

        for (int j = 0; j < a.length - 1; j++) {
            for (int i = a.length - 1; i > j; i--) {
                if (a[i] < a[i - 1]) {
                    int tmp = a[i];
                    a[i] = a[i - 1];
                    a[i - 1] = tmp;
                }
            }
        }
    }

    // QuickSort
    public void quickSort(int[] a){
        quickSort(0, a.length-1, a);
    }
    private void quickSort(int start, int end, int[] a) {
        int l = start;
        int r = end;
        int mid = (start + end) / 2;
        int pivot = a[mid];
        int tmp = 0;

        while (l < r) {
            while (a[l] < pivot) {
                l++;
            }
            while (a[r] > pivot) {
                r--;
            }
            if (l <= r) {
                tmp = a[l];
                a[l] = a[r];
                a[r] = tmp;
                l++;
                r--;
            }
        }

        if (start < r) {
            quickSort(start, r, a);
        }
        if (l < end) {
            quickSort(l, end, a);
        }
    }
}
