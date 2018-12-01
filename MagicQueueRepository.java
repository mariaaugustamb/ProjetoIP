package classMagic;

import  Exceptions.MagicNotFoundException;

public class MagicQueueRepository implements MagicRepositoryInterface {

	private Magic magic;
	private MagicQueueRepository next;

	public MagicQueueRepository() {
		magic = null;
		next = null;
	}

	public MagicQueueRepository(Magic magic, MagicQueueRepository next) {
		this.magic = magic;
		this.next = next;
	}

	public void insert(Magic magic) {
		if (this.next!=null) {
			this.next.insert(magic);
		}else {
			this.magic = magic;
			this.next = new MagicQueueRepository();
		}

	}


	public void remove(String name) throws MagicNotFoundException {
		if (this.magic.getName().equals(name)) {
			this.magic = this.next.magic;
			this.next = this.next.next;
		}else if (this.next != null) {
			this.next.remove(name);
		}else {
			MagicNotFoundException error = new MagicNotFoundException();	
			throw error;

		}

	}


	public void update(Magic magic) throws MagicNotFoundException {
		
		if (this.magic.getName().equals(magic.getName())) {
			this.magic = magic;
		}else if (this.next != null) {
			this.next.update(magic);
		}else {
			MagicNotFoundException error = new MagicNotFoundException();	
			throw error;
		}

	}


	public boolean exists(String name) {
		if (this.magic.getName().equals(name)) {
			return true;
		}else if (this.next != null) {
			return this.next.exists(name);
		}else {
			return false;
		}
	}


	public Magic search(String name) throws MagicNotFoundException{
		if (this.magic.getName().equals(name)) {
			return this.magic;
		}else if (this.next != null) {
			return this.next.search(name);
		}else {
			MagicNotFoundException error = new MagicNotFoundException();	
			throw error;

		}
	}

}
