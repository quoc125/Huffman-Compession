
/*Quoc Le
COP 3503-0001
Huffman Compression
23 April 2016
*/
public class HuffmanTree {
	private int freq[];
	HuffmanTreeNode root;
	
	public HuffmanTree(int Freq[]) {
		root = null;
		freq = Freq;
	}
	
	public HuffmanTreeNode getRoot()
	{
		
		BinaryMinHeap<HuffmanTreeNode> queue = new BinaryMinHeap<HuffmanTreeNode>();
		//add a temp value that will disappear because of shifted down 
		queue.add(new HuffmanTreeNode(0, '*'));
		
		//add all value in the queue from frequency table
		for (int i = 0; i < 256; i++)
		{
			if (freq[i] != 0)
			{
				queue.add(new HuffmanTreeNode(freq[i], (char)i));
			}
		}
		//connected each node until queue has only two node left
		while(queue.getSize() >3)
		{
			//get the next two node
			HuffmanTreeNode node1 = queue.pop();
			HuffmanTreeNode node2 = queue.pop();
			
			//create parent node
			HuffmanTreeNode temp = new HuffmanTreeNode(node1.getFreq() + node2.getFreq(), '*');
			
			//determine if the node is going to be the right or left node
			//the node with the greater value is on the right
			if (node1.getFreq() > node2.getFreq())
			{
				temp.right = node1;
				temp.left = node2;
				node1.parent = temp;
				node2.parent = temp;
			}
			else
			{
				temp.right = node2;
				temp.left = node1;
				node1.parent = temp;
				node2.parent = temp;
			}
			//add the parent to the queue
			queue.add(temp);
		}
		
		//repeat the same thing as before, 
		//but the parent node will be the root node
		HuffmanTreeNode node1 = queue.pop();
		HuffmanTreeNode node2 = queue.pop();
		root = new HuffmanTreeNode(node1.getFreq() + node2.getFreq(), '*');
		if (node1.getFreq() > node2.getFreq())
		{
			root.right = node1;
			root.left = node2;
			node1.parent = root;
			node2.parent = root;
		}
		else
		{
			root.right = node2;
			root.left = node1;
			node1.parent = root;
			node2.parent = root;
		}
		return root;
	}
}
