package hw1;

public interface IBag<T> {
	
	public boolean add(T newItem);
	
	public boolean isEmpty();
	
	public boolean isFull();
	
	public T removeByIndex(int index);
	
	public T remove();
	
	public T remove(T item);
	
	public int getItemCount();
	
	public int getIndexOf(T item);
	
	public boolean contains(T item);
	
	public void displayItems();
	
	public void dump(); // removes all the items from the bag
	
	public boolean transferTo(IBag<T> targetBag, T item);
	
	public T getItem(int index);

	public boolean consume(T current_item, IBag<T>[] trashBags);
	

}
// 2 item(s) azalýp artmýyor. +
// Bag Display olurken Item 1 den Item3 e atlýyor. +
// Trash Baglar  ve PicnicBag --> Consume
// Menu kontrolü
// Menüye go picnic eklenmesi
// Remove Randomly methodu.
// TransferTo'da ve diðer bazý methodlarda önce contains kontrolü yapýlmalý.
// Methodlarýn pre-condition'larý ve post-conditionlarýnýn kontrolleri yapýlmalý.
// Remove Random'a Transfer To Methodu...
