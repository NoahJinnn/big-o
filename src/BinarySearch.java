public class BinarySearch {
    public int doBS(int[] arr, int expect) {
        int l = 0;
        int r = arr.length - 1; // [left,right] search interval
        while(l <= r) { // terminate when interval becomes [r+1,r] -> empty interval
            int mid = l + (r-l)/2;
            if(arr[mid] == expect) {
                return mid;
            } else if(arr[mid] > expect) {
                l = mid + 1;
            } else if(arr[mid] < expect) {
                r = mid - 1;
            }
        }
        return -1;
    }

    public int doBSRecur(int[] arr, int expect, int l, int r) {
        if(l <= r) {
            int mid = l + (r-l)/2;
            if(arr[mid] == expect) {
                return mid;
            } else if(arr[mid] > expect) {
                return doBSRecur(arr, expect, mid + 1, r);
            } else if(arr[mid] < expect) {
                return doBSRecur(arr, expect, l, mid - 1);
            }
        }
        return -1;
    }

    public int findLeftBorder(int[] arr, int expect) {
        int l = 0;
        int r = arr.length - 1;
        while(l <= r) {
            int mid = l + (r-l)/2;
            if(arr[mid] == expect) {
                r = mid - 1; // tighten right, lock left
            } else if(arr[mid] > expect) {
                r = mid - 1;
            } else if(arr[mid] < expect) {
                l = mid + 1;
            }
        }
        if(l >= arr.length || arr[l] != expect) return -1;
        return l;
    }

    public int findRightBorder(int[] arr, int expect) {
        int l = 0;
        int r = arr.length - 1;
        while(l <= r) {
            int mid = l + (r-l)/2;
            if(arr[mid] == expect) {
                l = mid + 1; // tighten left, lock right
            } else if(arr[mid] > expect) {
                r = mid - 1;
            } else if(arr[mid] < expect) {
                l = mid + 1;
            }
        }
        if(r < 0 || arr[r] != expect) return -1;
        return r;
    }

}
