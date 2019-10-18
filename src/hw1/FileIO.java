package hw1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileIO {
	
	/* Read items from text file and create a Bag.
	 * @param: none
	 * @return: none
	 */
	public IBag<Item> readInventory(){
		
		IBag<Item> bag = new InventoryBag<Item>() ;

		BufferedReader reader;
		
		try {
			reader = new BufferedReader(new FileReader(
					"src/CENG112_Homework1_Bags_Inventory.txt"));
			
			String line = reader.readLine();
			
			while (line != null) {
				
				String[] itemArr=line.split(",");
				
				Item item_current = new Item(itemArr[0],itemArr[1]);
				for (int i=1;i<Integer.parseInt(itemArr[2]);i++) {
					bag.add(item_current);
				}
				
				bag.add(item_current);
				
				// read next line
				line = reader.readLine();
			}
			
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return bag;
		
		
	}
	
}
