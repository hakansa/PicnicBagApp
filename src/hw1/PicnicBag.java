package hw1;

import java.util.Random;

public class PicnicBag<T> implements IBag<T> {
	
	
	private int size;
	private int numberOfItems;
	private  T[] itemList;
	

	@SuppressWarnings("unchecked")
	/* Create Picnic Bag
	 * @param size: Size of Picnic Bag.
	 * @return: none
	 */

	public PicnicBag(int size) {
		
		this.size=size;
		this.numberOfItems = 0;
		itemList = (T[]) new Object[size];
	}
	/*Get size of Picnic Bag
	 * @param none
	 * @return: size of Picnic Bag
	 */
	public int getBagSize() {
		return size;
	}
	/*Get the number of items in Picnic Bag
	 * @param: none
	 * @return: Number of item in Picnic Bag
	 */
	public int getNumberOfItems() {
		return numberOfItems;
	}
	/*add to Picnic Bag an item
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
	/*Checks Picnic Bag is empty or not
	 * @param:none
	 * @return:if number of the item in picnic bag is equals to 0 it returns true.Else it returns false
	 */
	@Override
	public boolean isEmpty() {
		return numberOfItems==0;
	}
	/*Check Picnic bag is full or not
	 * @param:none
	 * return:if the number of the items in picnic bag is equal to size of picnic bag ,it returns true.Else it retuns false
	 */
	@Override
	public boolean isFull() {
		return numberOfItems==size;
	}
	
	/*It removes from item list by index and it change the item null and last item in Picnic Bag change it location to this location
	 *@param:index 
	 *@return:if Picnic bag is empty and index is non-negative number it return result .Else it retuns null
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
	/* delete 1 item in Picnic Bag Randomly
	 * @param:none
	 * @return: if Picnic Bag isint empty it retuns Removed Item . Else it returns null
	 */
	@Override
	public T remove() {
		Random rand = new Random();
		if (!this.isEmpty()) {
			int random_index=rand.nextInt(numberOfItems);
			T removedItem= this.getItem(random_index);
			this.removeByIndex(random_index);
			
			return removedItem;
		}
		return null;
	}
	/* remove a specific item from Picnic Bag
	 * @param:Item
	 * @return: if item in Picnic bag it it retuns Removed Item.Else it retuns null
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
	/*count the ýtem in Picnic Bag
	 * @param:none
	 * @return:Number Of Items in Picnic Bag
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
	/*check the item if it is in Picnic Bag
	 * @param:Item
	 * @return:ýf the item in Picnic Bag ,it returns true.Else it returns false
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
	/*to show items in Picnic Bag
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
	/*all items removed from Picnic Bag
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
	 * @retun:if target bag is not full, it retuns true.
	 */
	@Override
	public boolean transferTo(IBag<T> targetBag, T item) {
		if(!targetBag.isFull()) {
			targetBag.add(item);
			this.remove(item);
			return true;
		}
		return false;
		
	}
	/*find item with index
	 * @param:Index
	 * @return:Item
	 */
	@Override
	public T getItem(int index) {
		
		return itemList[index];
	}
	/* consider which items going to which  Bag
	 * @param:Item 
	 * @param:Trash Bag
	 * return:If transfer is succesfull, func retuns true
	 */
	public boolean consume(T item, IBag<T>[] trashBags) {
		
		
		String item_type=item.toString();
		String[] itemAttrArr = item_type.split("/");			
		if (itemAttrArr[1].equals("paper")) {
			this.transferTo(trashBags[0], item);
			
			return true;
		}else if (itemAttrArr[1].equals("plastic")) {
			this.transferTo(trashBags[1], item);
			return true;
		}else if (itemAttrArr[1].equals("organic")){

			this.transferTo(trashBags[2], item);
			return true;
		 
		}
		return false;
	
	 }

}
