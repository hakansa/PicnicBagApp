package hw1;

import java.util.Random;

public class OrganicTrashBag<T> implements IBag<T> {
	
	private final String type="organic";
	private int size;
	private int numberOfItems;
	private  T[] itemList;
	
	/* Create Trash Bag
	 * @param size: Size of Trash Bag.
	 * @return: none
	 */

	@SuppressWarnings("unchecked")
	public OrganicTrashBag(int size) {
		
		this.size=size;
		this.numberOfItems = 0;
		itemList = (T[]) new Object[size];
	}
	/*Get size of Trash Bag
	 * @param none
	 * @return: size of Trash Bag
	 */
	public int getBagSize() {
		return size;
	}
	/*Get the number of items in Trash Bag
	 * @param: none
	 * @return: Number of item in Trash Bag
	 */
	public int getNumberOfItems() {
		return numberOfItems;
	}
	/*add to Trash Bag an item
	 *@param: item
	 *@return: if item added it returns true.Else it returns false
	 */
	public boolean add(T newItem) {
		
		if(!this.isFull()) {	
			itemList[numberOfItems] = newItem;
			numberOfItems++;

			return true;
		}
		
		
		return false;
	}
	/*Checks Trash Bag is empty or not
	 * @param:none
	 * @return:if number of the item in Trash bag is equals to 0 it returns true.Else it returns false
	 */
	@Override
	public boolean isEmpty() {
		return numberOfItems==0;
	}
	/*Check Trash bag is full or not
	 * @param:none
	 * return:if the number of the items in Trash bag is equal to size of Trash bag ,it returns true.Else it retuns false
	 */
	@Override
	public boolean isFull() {
		return numberOfItems==size;
	}
	
	/*It removes from item list by index and it change the item null and last item in Trash Bag change it location to this location
	 *@param:index 
	 *@return:if Trash bag is empty and index is non-negative number it return result .Else it retuns null
	 */
	@Override
	public T removeByIndex(int index) {
		T result=null;
		if(!isEmpty() && index>=0) {
			result=itemList[index];
			itemList[index]=itemList[numberOfItems-1];
			itemList[numberOfItems-1]=null;
			numberOfItems--;
			return result;
		}

		return null;
	}
	/* delete 1 item in Trash Bag Randomly
	 * @param:none
	 * @return: if Trash Bag isint empty it retuns Removed Item . Else it returns null
	 */
	@Override
	public T remove() {
		Random rand = new Random();
		int random_index=rand.nextInt(numberOfItems);
		T removedItem= this.getItem(random_index);
		this.removeByIndex(random_index);
		
		return removedItem;
	}
	/* remove a specific item from Trash Bag
	 * @param:Item
	 * @return: if item in Trash bag it it retuns Removed Item.Else it retuns null
	 */
	@Override
	public T remove(T item) {
		for (int i=0;i<numberOfItems;i++) {
			if (itemList[i].equals(item)) {
				T removedItem=this.removeByIndex(i);
				return removedItem;
			}
		}
		return null;
	}
	/*count the ýtem in Trash Bag
	 * @param:none
	 * @return:Number Of Items in Trash Bag
	 */
	@Override
	public int getItemCount() {
		return numberOfItems;
	}
	/*to find an item's ýndex
	 * @param:Item
	 * @return:Index
	 */
	@Override
	public int getIndexOf(T item) {
		int where=-1;
		boolean found=false;
		int index=0;
		while (!found && (index<numberOfItems)) {
			
			if (item.equals(itemList[index])) {
				found=true;
				where=index;
			}
			index++;
		}

		return where;
	}
	/*check the item if item is in Trash Bag
	 * @param:Item
	 * @return:ýf the item in Trash Bag ,it returns true.Else it returns false
	 */
	@Override
	public boolean contains(T item) {
		for (int i=0;i<numberOfItems;i++) {
			if(itemList[i].equals(item)){
				return true;
			}
		}
		
		return false;
	}
	/*to show items in Trash Bag
	 * @param:none
	 * @return:none
	 */
	@Override
	public void displayItems() {
		for(int i=0;i<this.numberOfItems;i++){
			if (itemList[i]!=null) {
				System.out.println("Ýtem "+(i+1)+" -"+itemList[i].toString());

				
			}
			
		}
		
	}
	/*all items removed from Trash Bag
	 * @param:none
	 * @return:none
	 */
	@Override
	public void dump() {
		for (int i=0;i<numberOfItems;i++) {
			itemList[i]=null;
		}
		
		
	}
	/*transfer an ýtem to target bag
	 * @param:target bag 
	 * @param:ýtem
	 * @retun:if target bag is not full, it retuns true.Else it retuns false
	 */
	@Override
	public boolean transferTo(IBag<T> targetBag, T item) {
		targetBag.add(item);
		this.remove(item);
		return true;
	}
	/*find ýtem with ýtem's ýndex
	 * @param:Index
	 * @return:Item
	 */
	@Override
	public T getItem(int index) {
		
		return itemList[index];
	}
	/*to consider which ýtems going yo which Trash Bags
	 * @param:Item 
	 * @param:Trash Bag
	 * return:If trasnsfer is succesfull, it retuns true.Else it returns false
	 */
	@Override
	public boolean consume(T current_item, IBag<T>[] trashBags) {
		// TODO Auto-generated method stub
		return false;
	}
	

	
	

}
