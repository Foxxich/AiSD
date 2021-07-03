public class PriorityQueue {
    private Task[] heap;
    private int heapSize, capacity;
    public int insertCompares = 0;
    public int priorityCompares = 0;
    public int printCompares = 0;
    public int heapifyCompares  = 0;
    public int removeCompares = 0;

    /** Constructor **/
    public PriorityQueue(int capacity)
    {
        this.capacity = capacity + 1;
        heap = new Task[this.capacity];
        heapSize = 0;
    }
    /** function to clear **/
    public void clear()
    {
        heap = new Task[capacity];
        heapSize = 0;
    }
    /** function to check if empty **/
    public boolean isEmpty()
    {
        return heapSize == 0;
    }
    /** function to get Size **/
    public int size()
    {
        return heapSize;
    }
    /** function to insert task **/
    public void insert(String job, double priority)
    {
        Task newJob = new Task(job, priority);

        heap[heapSize] = newJob;
        int pos = heapSize++;
        insertCompares++;
        while (pos != 0 && newJob.priority < heap[pos/2].priority)
        {
            heap[pos] = heap[pos/2];
            pos /=2;
            insertCompares++;
        }
        heap[pos] = newJob;
    }

    // Function to build a Max-Heap from the Array
    void buildHeap()
    {
        // Index of last non-leaf node
        int startIdx = (heapSize / 2) - 1;

        // Perform reverse level order traversal
        // from last non-leaf node and heapify
        // each node
        heapifyCompares = 0;
        for (int i = startIdx; i >= 0; i--) {
            heapify(i);
        }
    }
    /** function to remove task **/
    public Task remove()
    {
        int parent, child;
        Task item, temp;
        if (isEmpty() )
        {
            System.out.println("Heap is empty");
            return null;
        }

        item = heap[0];
        temp = heap[--heapSize];

        parent = 0;
        child = 1;
        while (child <= heapSize)
        {
            removeCompares+=2;
            if (child < heapSize && heap[child].priority > heap[child + 1].priority)
                child++;
            if (temp.priority <= heap[child].priority)
                break;

            heap[parent] = heap[child];
            parent = child;
            child *= 2;
        }
        heap[parent] = temp;
        buildHeap();
        removeCompares += heapifyCompares;
        return item;
    }

    public Task top()
    {
        if(isEmpty())
        {
            return null;
        }
        else
            return heap[0];
    }

    public Task pop()
    {
        if(isEmpty())
        {
            return null;
        }
        else
            return remove();
    }

    void heapify(int i)
    {
        int n = heapSize;
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        heapifyCompares++;
        if (l < n && heap[l].priority < heap[largest].priority)
            largest = l;

        heapifyCompares++;
        // If right child is larger than largest so far
        if (r < n && heap[r].priority < heap[largest].priority)
            largest = r;

        heapifyCompares++;
        // If largest is not root
        if (largest != i) {
            Task swap = heap[i];
            heap[i] = heap[largest];
            heap[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(largest);
        }
    }

    public void priority(String value, double priority) {
        for(int i = 0; i < heapSize; i++) {
            Task task = heap[i];
            priorityCompares++;
            if (task != null && task.name.equals(value) && task.priority > priority) {
                task.priority = priority;
            }
        }
        buildHeap();
        priorityCompares += heapifyCompares;
    }

    public void print() {
        printCompares++;
        for (int i = 0; i <= heapSize / 2; i++) {
            printCompares++;
            for (int j = 0; j < Math.pow(2, i) && j + Math.pow(2, i) <= heapSize; j++) { // Each row has 2^n nodes
                printCompares++;
                //System.out.print(heap[j + (int) Math.pow(2, i) - 1] + " ");
            }
            //System.out.println();
        }
    }

}

