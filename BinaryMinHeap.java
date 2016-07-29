
/*Quoc Le
COP 3503-0001
Huffman Compression
23 April 2016
*/
public class BinaryMinHeap<Any extends Comparable<Any>>
{
	private int size;
	private Any[] heap;
	public BinaryMinHeap() {
		size = 0;
		heap = (Any[]) new Comparable[256]; 
	}
	//add next value in queue and sort the array
	public void add(Any compare)
	{
		heap[size]= compare;
		sort();
		size++;
		
	}
	//return size of queue
	public int getSize()
	{
		return size;
	}
	//pop next value in the array
	public Any pop ()
	{
		moveDown();
		size--;
		return heap[0];
	}
	//shift the array down, when queue is pop
	public void moveDown()
	{
		if (size == 1)
			return;
		for (int i = 0; i < size; i++)
			heap[i] = heap [i+1];
		heap[size] = null;
	}
	//sort each value
	public void sort()
	{

		for (int i = size-1; i > 0; i-- )
		{
			if (heap[i].compareTo(heap[i+1]) >0)
			{
				Any temp = heap[i];
				heap[i] = heap[i+1];
				heap[i+1] = temp;
			}
		}
	}

}
