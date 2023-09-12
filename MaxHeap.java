import java.util.*;
public class MaxHeap {
    private List<Integer> heap;
    private int x;

    public MaxHeap(int x) {
        this.heap = new ArrayList<>();
        this.x = x;
    }

    public void insert(int value) {
        if (heap.size() >= Math.pow(2, x)) {
            System.out.println("Heap is full. Cannot insert.");
            return;
        }

        heap.add(value);
        heapifyUp(heap.size() - 1);
    }

    public int popMax() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty.");
        }

        int max = heap.get(0);
        int lastElement = heap.remove(heap.size() - 1);

        if (!isEmpty()) {
            heap.set(0, lastElement);
            heapifyDown(0);
        }

        return max;
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;

        while (index > 0 && heap.get(index) > heap.get(parentIndex)) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    private void heapifyDown(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int largest = index;

        if (leftChildIndex < heap.size() && heap.get(leftChildIndex) > heap.get(largest)) {
            largest = leftChildIndex;
        }

        if (rightChildIndex < heap.size() && heap.get(rightChildIndex) > heap.get(largest)) {
            largest = rightChildIndex;
        }

        if (largest != index) {
            swap(index, largest);
            heapifyDown(largest);
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
	
	public static void main(String [] args)
	{
		
	}
}