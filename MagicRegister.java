package classMagic;

import Exceptions.*;

public class MagicRegister {
	
	private MagicRepositoryInterface magicRepository;
	
	public MagicRegister (boolean type) {
		
		if (type) {
			this.magicRepository = new MagicArrayRepository();
		}else {
			this.magicRepository = new MagicQueueRepository();
		}
	}
	
	public void insert (Magic insertedMagic) throws MagicAlreadyRegisteredException {
		if (!magicRepository.exists(insertedMagic.getName())) {
			magicRepository.insert(insertedMagic);
		}else {
			MagicAlreadyRegisteredException error = new MagicAlreadyRegisteredException();
			throw error;
		}
	}
	
	public void remove (Magic insertedMagic) throws MagicNotFoundException {
		if (magicRepository.exists(insertedMagic.getName())) {
			magicRepository.remove(insertedMagic.getName());
		}else {
			MagicNotFoundException error = new MagicNotFoundException();
			throw error;
			}
	}
	
	public void update (Magic insertedMagic) throws MagicNotFoundException {
		if (magicRepository.exists(insertedMagic.getName())) {
			magicRepository.update(insertedMagic);
		}else {
			MagicNotFoundException error = new MagicNotFoundException();
					throw error;
		}
	}

	public Magic search (String magicName) throws MagicNotFoundException {
		if (magicRepository.exists(magicName)) {
			return magicRepository.search(magicName);
		}else {
			MagicNotFoundException error = new MagicNotFoundException();
			throw error;
		}
	}
	
	public boolean exists (String magicName) {
		return magicRepository.exists(magicName);
	}
	
}
