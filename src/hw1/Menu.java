package hw1;

import java.util.Scanner;

public class Menu {
	private static boolean flagPicnicBagSize=true;
	private static boolean flagAddItem=true;
	private static boolean flagMainMenu=true;
	private static IBag<Item> UserPicnicBag;
	static FileIO fileIO = new FileIO();
	static IBag<Item> inventoryBag = fileIO.readInventory();
	
	// MAIN MENU DESIGN
	public static void init() {
		
		System.out.println("__________WELCOME TO PICNIC BAG APP__________");
		
		setPicnicBagSize();

	}
	
	public static void setPicnicBagSize() {
	
		while(flagPicnicBagSize) {
			
			
			System.out.println("\nChoose A Picnic Bag Size:");
			System.out.println("1)Small (Up to 5 items)\n2)Medium (Up to 10 items)\n3)Large (Up to 15 items)");
			
			Scanner BagSizeScanner = new Scanner(System.in);  // Create a Scanner object
		    System.out.println("Bag size:");
		    
		    int bagSize = BagSizeScanner.nextInt();  // Read user input
			if (bagSize==1 || bagSize==2 || bagSize==3) {
				flagPicnicBagSize=false;
				System.out.println("Bag was created!");
				UserPicnicBag = new PicnicBag<Item>(bagSize*5);
				while (flagMainMenu) {
					mainMenu();
					Scanner mainMenuScanner = new Scanner(System.in);  // Create a Scanner object
				    System.out.println("Select an option:");
				    String mainMenuOption = mainMenuScanner.nextLine();
				    System.out.println(mainMenuOption);
				    switch (mainMenuOption) {
				    case "1":
				    	
				    	AddItem();
				    	break;
				    case "2":
				    	
				    	RemoveItem();
				    	break;
				    case "3":
				    	RandomRemoveItemFromPicnicBag();
				    	
				    	break;
				    case "4":
						int picnicBagItemNumber=((PicnicBag<Item>) UserPicnicBag).getNumberOfItems();
						if (picnicBagItemNumber!=0) {
							UserPicnicBag.dump();
					    	System.out.println("All items removed from Picnic Bag.");
						}
				    	System.out.println("The Picnig Bag is empty now. You cannot remove an item. ");
				    	break;
				    case "5":
				    	DisplayItemsInPicnicBag();
				    	break;
				    case "6":
				    	// case 6
				    	inventoryBag.displayItems();
				    	break;
				    	
				    case "7":
				    	IsPicnicBagEmpty();
				    	DisplayItemsInPicnicBag();
				    	break;	
				    	
				    case "8":
				    	//case 8
				    	IsPicnicBagFull();
			    		DisplayItemsInPicnicBag();
				    	break;
				    case "9":
				    	GoToPicnic();						
				    	flagMainMenu=false;
				    	break;
				    case "e":
				    	
				    	// case e
				    	flagMainMenu=false;
				    	break;
				    default:
				    	System.out.println("Please enter a valid option.");
				    	continue;
				    }
				}
				
			}else {
				System.out.println("You should select a valid option!Please enter 1, 2 or 3...");
			}
			

		}
		
	}
	public static void mainMenu() {
		System.out.println("Select an Option:");
		System.out.println("1)Add Item to Picnic Bag\n2)Remove An Item from Picnic Bag\n3)Remove An Item Randomly from Picnic Bag");
		System.out.println("4)Remove All Items from Picnic Bag\n5)Display Items in Picnic Bag\n6)Display Items in Inventory");
		System.out.println("7)Check if Picnic Bag is empty\n8)Check if Picnic Bag is full\n9)Go to Picnic\n (Press 'e' to exit.)");
		


	}
	public static void AddItem() {
		
		inventoryBag.displayItems();
		int picnicBagSize=((PicnicBag<Item>) UserPicnicBag).getBagSize();
		int picnicBagItemNumber=((PicnicBag<Item>) UserPicnicBag).getNumberOfItems();
		int emptyBagField=picnicBagSize-picnicBagItemNumber;
		if (emptyBagField==0) {
			System.out.println("\nThe Picnic Bag is full. You cannot add items anymore.\n");
			
		}else {
			System.out.println("You can select "+emptyBagField+" item(s).");
			
			flagAddItem=true;
			while (flagAddItem) {
				Scanner addItemScanner = new Scanner(System.in);  // Create a Scanner object
			    System.out.println("Select an item:");
			    String newItemIndex = addItemScanner.nextLine();
			    int newItemIndexInt = (Integer.parseInt(newItemIndex)-1);
			 
			    if (newItemIndexInt < 0 || newItemIndexInt > picnicBagItemNumber) {
			    	System.out.println("Please enter a valid value!");
			    	continue;
			    	
			    }
			    else {
			    	Item newItem=inventoryBag.getItem(newItemIndexInt);
			    	
			    	inventoryBag.transferTo(UserPicnicBag, newItem);
			    	DisplayItemsInPicnicBag();
			    	
				    flagAddItem=false;

			    }
				
			}
			
		}
		
		
	}
	public static void RemoveItem() {
		
		int picnicBagItemNumber=((PicnicBag<Item>) UserPicnicBag).getNumberOfItems();
		if (picnicBagItemNumber!=0) {
			DisplayItemsInPicnicBag();
			while (true) {
				Scanner removeItemScanner = new Scanner(System.in);  // Create a Scanner object
			    System.out.println("Select An Item Number:");
			    int removedItemIndex = Integer.parseInt(removeItemScanner.nextLine());
				
					if(removedItemIndex <= picnicBagItemNumber && removedItemIndex>0) {
						Item removedItem= UserPicnicBag.getItem(removedItemIndex-1);
						UserPicnicBag.transferTo(inventoryBag, removedItem);
						System.out.println("Item removed.Updated Bag:\n");
					    DisplayItemsInPicnicBag();
					    break;
					}else {
						System.out.println("Please enter a valid value!");
					}
			}
		}else {
			System.out.println("Picnic Bag is empty. You cannot rmeove an item now.");
		}
		
		
		
		
	    
	    
	}
	public static void DisplayItemsInPicnicBag() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~ ITEMS IN PICNIC BAG ~~~~~~~~~~~~~~~~~~~~");
    	UserPicnicBag.displayItems();
    	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
	public static void RandomRemoveItemFromPicnicBag() {
		int picnicBagItemNumber=((PicnicBag<Item>) UserPicnicBag).getNumberOfItems();
		if (picnicBagItemNumber==0) {
			System.out.println("Bag is empty.You cannot remove an item now!");
		}else {
			Item random_removed_item =UserPicnicBag.remove();
	    	UserPicnicBag.transferTo(inventoryBag, random_removed_item);
	    	inventoryBag.add(random_removed_item);
	    	System.out.println(random_removed_item.getItem_name()+" was deleted from Picnic Bag.");
	    	DisplayItemsInPicnicBag();
		}
		
    	
	}
	public static void IsPicnicBagEmpty() {
		boolean isPicnicBagEmpty=UserPicnicBag.isEmpty();
    	if(isPicnicBagEmpty==true) {
    		System.out.println("Bag is empty.");
    	}else {
    		System.out.println("Bag is NOT empty.");
    	}
	}
	public static void IsPicnicBagFull() {
		boolean isPicnicBagFull=UserPicnicBag.isFull();
    	if(isPicnicBagFull==true) {
    		System.out.println("Bag is full.");
    	}else {
    		int picnicBagSize=((PicnicBag<Item>) UserPicnicBag).getBagSize();
    		int picnicBagItemNumber=((PicnicBag<Item>) UserPicnicBag).getNumberOfItems();
    		int emptyBagField=picnicBagSize-picnicBagItemNumber;
    		System.out.println("Bag is NOT full.You can add "+emptyBagField+" item(s).");
    	}
	}
	@SuppressWarnings("unchecked")
	public static void GoToPicnic() {
		IBag<Item> TrashBag_Organic=new OrganicTrashBag<Item>(15);
		IBag<Item> TrashBag_Plastic=new PlasticTrashBag<Item>(15);
		IBag<Item> TrashBag_Paper =new PaperTrashBag<Item>(15);
		IBag<Item>[] trashBags=new IBag[3];
		trashBags[0]=TrashBag_Paper;
		trashBags[1]=TrashBag_Plastic;
		trashBags[2]=TrashBag_Organic;
		int picnicBagItemNumber=((PicnicBag<Item>) UserPicnicBag).getNumberOfItems();
		for(int i=0;i<picnicBagItemNumber;i++) {
			Item current_item=UserPicnicBag.getItem(0);
			UserPicnicBag.consume(current_item,trashBags);
			
			
		}
		System.out.println("Paper Trash Bag:");
		trashBags[0].displayItems();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\nPlastic Trash Bag:");
		trashBags[1].displayItems();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\nOrganic Trash Bag:");
		trashBags[2].displayItems();

		
	}
}
