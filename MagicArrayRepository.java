package classMagic;

import Exceptions.MagicNotFoundException;

public class MagicArrayRepository implements MagicRepositoryInterface{

	private Magic[] magics;
	private int cont;

	public MagicArrayRepository () {
		this.magics = new Magic [1];
		this.cont = 0;
	}


	public void insert(Magic magic) {
		if (cont<magics.length) {
			magics[cont] = magic;
			cont++;
		}else {
			Magic[] biggerArray = biggerArray(magics, magic);
			magics = biggerArray;
			cont++;
		}
	}

	public void remove(String name) throws MagicNotFoundException {
		boolean run = false;
		for ( int i = 0; i<magics.length && !run; i++) {
			if (magics[i].getName().equals(name)) {
				magics[i] = null;
				cont = cont - 1;
				run = true;


				Magic[] end = smallerArray(magics);

				magics = end;
			}
		}
	}

	public void update(Magic magic) throws MagicNotFoundException {
		boolean run = false;
		Magic aux = null;
		for ( int i = 0; i<magics.length && !run ; i++) {
			if (magics[i].getName().equals(magic.getName())){
				magics[i] = magic;
				aux = magics[i];
				run = true;
			}
		}if (aux == null) {

			MagicNotFoundException error = new MagicNotFoundException();	
			throw error;

		}
	}

	public boolean exists(String name) {
		boolean run = false;
		for (int i = 0; i < magics.length && !run; i++) {
			if (magics[i].getName().equals(name)) {
				run = true;
				return true;
			}
		}

		return false;
	}

	public Magic search(String name) throws MagicNotFoundException {
		boolean run = false;
		Magic aux = null;
		for (int i = 0; i < magics.length && !run; i++) {
			if (magics[i].getName().equals(name)) {
				run = true;
				aux = magics[i];
			}
		}
		if (aux != null) {
			return aux;
		}else {
			MagicNotFoundException error = new MagicNotFoundException();	
			throw error;
		}

	}

	private Magic[] biggerArray(Magic[] magics, Magic magic) {
		Magic[] biggerMagic = new Magic[this.magics.length+1];
		for (int i = 0; i<biggerMagic.length; i++) {
			if (i == this.magics.length) {
				biggerMagic[i] = magic;
			}else {
				biggerMagic[i] = this.magics[i];
			}
		}

		return biggerMagic;
	}

	public static Magic[] smallerArray (Magic [] array) {
		Magic [] smallerArray = new Magic [array.length-1];

		int cont = 0;
		for (int i = 0; i<array.length; i++) {
			if (array[i] != null) {
				smallerArray[cont] = array[i];
				cont = cont+1;
			}
		}
		return smallerArray;
	}


}
