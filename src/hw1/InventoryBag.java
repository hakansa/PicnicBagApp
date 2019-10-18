package hw1;


public class InventoryBag<T> implements IBag<T> {

	
	private int numberOfItems;
	
	private T[] itemList;
	
	@SuppressWarnings("unchecked")
	public InventoryBag(){
		this.numberOfItems=0;
		itemList = (T[]) new Object[500];
		
	}
	
	/*add to Picnic Bag an item
	 *@param: item
	 *@return: if item added it returns true.Else it returns false
	 */

	@Override
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
		// TODO Auto-generated method stub
		return numberOfItems==500;
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
		// TODO Auto-generated method stub
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
				numberOfItems--;
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
		// TODO Auto-generated method stub
		return numberOfItems;
	}
	/* find an item's index
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
	/*check the item if it is in  Bag
	 * @param:Item
	 * @return:ýf the item in  Bag ,it returns true.Else it returns false
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
	/*to show items in  Bag
	 * @param:none
	 * @return:none
	 */
	@Override
	public void displayItems() {
		
		for(int i=0;i<500;i++){
			if (itemList[i]!=null) {
				System.out.println("Ýtem "+(i+1)+" -"+itemList[i].toString());	
			}
			
		}
		
	}
	/*all items removed from  Bag
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
	public T getItem(int index) {
		
		return itemList[index];
	}

	/* consider which items going to which  Bag
	 * @param:Item 
	 * @param:Trash Bag
	 * return:If transfer is succesfull, func retuns true
	 */

	@Override
	public boolean consume(T current_item, IBag<T>[] trashBags) {
		// TODO Auto-generated method stub
		return false;
	}



	

}
