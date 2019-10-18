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
// 2 item(s) azal�p artm�yor. +
// Bag Display olurken Item 1 den Item3 e atl�yor. +
// Trash Baglar  ve PicnicBag --> Consume
// Menu kontrol�
// Men�ye go picnic eklenmesi
// Remove Randomly methodu.
// TransferTo'da ve di�er baz� methodlarda �nce contains kontrol� yap�lmal�.
// Methodlar�n pre-condition'lar� ve post-conditionlar�n�n kontrolleri yap�lmal�.
// Remove Random'a Transfer To Methodu...
