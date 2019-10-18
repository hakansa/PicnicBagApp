package hw1;

public class Item {
	private String item_name;
	private String dispasoble_type;

	
	public Item(String item_name, String dispasoble_type) {
		this.item_name=item_name;
		this.dispasoble_type=dispasoble_type;
	}
	
	
	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getDispasoble_type() {
		return dispasoble_type;
	}

	public void setDispasoble_type(String dispasoble_type) {
		this.dispasoble_type = dispasoble_type;
	}


	public String toString(){
		return " Name: "+ this.item_name+"/"+this.dispasoble_type;
		
	}
	
	public boolean equals(Item item) {
		if (this.item_name==item.item_name && this.dispasoble_type==item.dispasoble_type) {
			
			return true;
		}
		
		return false;
		
	}

}
