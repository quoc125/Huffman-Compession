
/*Quoc Le
COP 3503-0001
Huffman Compression
23 April 2016
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Iterator;

public class Huffman {
	static int freq[] = new int[256];
	static HashMap<Character, String> hm ;
	public static void main(String[] args) 
	{
		//store input
		File file = new File("input.dat");
		Scanner scanner;
		String input  = "";
		try {
			scanner = new Scanner(file);
			input += scanner.nextLine();
			while (scanner.hasNextLine())
			{
				//allow compression of new line character
				freq[(byte)'\n']++; //increase the freq of the newline char
				input += '\n';
				
				input += scanner.nextLine(); 
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//calculate the freq
		calculateFreqs(input);
		
		System.out.println(input);
		
		//get root of Huffman tree
		HuffmanTree tree = new HuffmanTree(freq);
		HuffmanTreeNode node = tree.getRoot();
		
		//Create a hash map that match a char to a correspond compress byte
		hm = new HashMap<Character, String>();
		setByte(node, "");
		Iterator iterate = hm.keySet().iterator();
		while (iterate.hasNext())
		{
			char tempChar = (char) iterate.next();
			String tempByte = hm.get(tempChar);
			System.out.println(tempChar + ": " + tempByte);
		}
		
		//print out the compressed output
		String output ="";
		for (int i = 0; i < input.length(); i++)
		{
			 output += hm.get(input.charAt(i));
		}
		
		System.out.println(output);
		
	}
	public static void calculateFreqs(String input) // create a freq table
	{
		//go through the byte array, and increase the count in the corresponding char
		byte Byte[] = input.getBytes();
		for (int i = 0; i < Byte.length; i++)
		{
			freq[Byte[i]]++;
		}
	}
	//set the compressed byte
	public static void setByte(HuffmanTreeNode node, String compress)
	{
		if (node == null) 
			return;
		
		//if both child node are empty, set the byte
		if (node.left == null && node.right == null)
		{
			if(node.getByte().length() > compress.length() || node.getByte().length() == 0)
				node.setByte(compress);
			
			hm.put(node.getStore(), node.getByte());
		}
		//add 1 if the node goes to right and 0 if the node go to the left
		setByte(node.right, compress + "1");
		setByte(node.left, compress+ "0");
	}
}
