
/*Quoc Le
COP 3503-0001
Huffman Compression
23 April 2016
*/
//store all value in the node
public class HuffmanTreeNode implements Comparable<HuffmanTreeNode> {
	HuffmanTreeNode left, right, parent;
	private char store;
	private int freq;
	private String Byte;
	public HuffmanTreeNode(int freq, char store) {
		// TODO Auto-generated constructor stub
		this.freq = freq; 
		this.store = store;
		Byte = "";
	}
	public char getStore()
	{
		return store;
	}
	
	public int getFreq()
	{
		return freq;
	}
	public void setByte(String Byte)
	{
		this.Byte = Byte;
	}
	public String getByte()
	{
		return Byte;
	}
	@Override
	public int compareTo(HuffmanTreeNode node) {
		// TODO Auto-generated method stub
		return freq-node.getFreq();
	}
	
	
}
