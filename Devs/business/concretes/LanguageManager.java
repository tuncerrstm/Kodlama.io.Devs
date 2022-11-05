package Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.LanguageService;
import Kodlama.io.Devs.dataAccess.abstracts.LanguageDao;
import Kodlama.io.Devs.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {

	private LanguageDao languageDao;

	@Autowired
	public LanguageManager(LanguageDao languageDao) {
		
		this.languageDao = languageDao;
		
	}

	@Override
	public List<Language> getAll() {
		
		return languageDao.getAll();
		
	}

	@Override
	public void create(Language language) throws Exception {
		
		if(language.getName().isEmpty()) {
			throw new Exception("İsim sekmesi boş bırakılamaz!");
		}
		else if(!this.isValid(language)) {
			throw new Exception("Bu dil zaten mevcut!");
		}
		else {
			languageDao.create(language);
		}
		
	}

	@Override
	public void delete(int id) {
		
		languageDao.delete(id);
		
	}

	@Override
	public void update(Language language, int id) {
		
		languageDao.update(language, id);
		
	}

	@Override
	public Language getById(int Id) {
		
		return languageDao.getById(Id);
	}

	@Override
	public boolean isValid(Language language) {

		for(Language lang1: getAll()) {
			if(lang1.getName().equalsIgnoreCase(language.getName())) {
				
				return false;
			}
		}
		return true;
	}
	
	
}
