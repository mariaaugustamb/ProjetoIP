package classMagic;

import Exceptions.MagicNotFoundException;

public interface MagicRepositoryInterface {
	void insert (Magic magic);
	void remove (String name) throws MagicNotFoundException;
	void update (Magic magic) throws MagicNotFoundException;
	boolean exists (String name);
	Magic search (String name) throws MagicNotFoundException;
}
