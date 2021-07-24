import java.util.ArrayList;
import java.util.Arrays;

public class Heap {
    ArrayList<Integer> heap;

    public Heap(Integer[] arr) {

        heap = new ArrayList<>(Arrays.asList(arr));
        int lastParentIdx = (heap.size() - 1) / 2;
        // create a heap from an array (a binary tree)
        for(int i = lastParentIdx; i >= 0; i--) { // loop through all parent node
            minifyHeap(i);
        }
    }

    private void minifyHeap(int i) {
        int minIdx = i;
        int smallest = heap.get(i);
        int left = 2*i+1;
        int right = 2*i+2;
        if(left < heap.size() - 1 && heap.get(left) <= smallest) {
            smallest = heap.get(left);
            minIdx = left;
        }
        if (right < heap.size() - 1 && heap.get(right) <= smallest) {
            minIdx = right;
        }
        if(minIdx != i) {
            // swap
            int temp = heap.get(i);
            heap.set(i, heap.get(minIdx));
            heap.set(minIdx, temp);
            minifyHeap(minIdx); // move up the smaller node
        }
    }

    public void addHeap(int val) {
        heap.add(val);
        int i = heap.size() - 1; // added node start with the last idx in array ( last node in the tree )
        while(i != 0 && val < heap.get((i - 1)/2) /*compare value with its parent*/) {
            int temp = heap.get((i - 1)/2);
            heap.set((i - 1)/2, val);
            heap.set(i, temp);
            i = (i - 1)/2; // shrink the heap size for next comparision
        }
    }

    public void deleteNode(int deleteIdx) {
        int largest = heap.get(heap.size() - 1);
        heap.set(deleteIdx, largest);
        int lastParentIdx = heap.size()/2 - 1;
        for(int i = 0; i < lastParentIdx; i++) {
            minifyHeap(i);
        }
        heap.remove(heap.size() - 1);
    }

    public void printHeap() {
        System.out.println(Arrays.toString(heap.toArray()));
    }
}
