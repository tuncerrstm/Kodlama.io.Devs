package Kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import Kodlama.io.Devs.dataAccess.abstracts.LanguageDao;
import Kodlama.io.Devs.entities.concretes.Language;

@Repository
public class InMemoryLanguageDao implements LanguageDao {
	
	List<Language> languages;

	public InMemoryLanguageDao() {
			languages = new ArrayList<Language>();
			languages.add(new Language(1,"C#"));
			languages.add(new Language(2,"Java"));
			languages.add(new Language(3,"Python"));
			languages.add(new Language(4,"C++"));
			languages.add(new Language(5,"JavaScript"));
	}

	@Override
	public List<Language> getAll() {
		return languages;
	}

	@Override
	public void create(Language language) {

		languages.add(language);
	}

	@Override
	public void delete(int id) {
		
		for(Language lang1: languages) {
			if(lang1.getId() == id) {
				languages.remove(id);
			}
		}
		
	}

	@Override
	public void update(Language language, int id) {

		Language lang1 = getById(language.getId());
		lang1.setName(language.getName());
		
	}

	@Override
	public Language getById(int id) {
		
		for(Language lang1: languages) {
			if(lang1.getId() == id) {
				return lang1;
			}
		}
		
		return null;
	}

	@Override
	public boolean isValid(Language language) {
		
		return false;
		
	}

	
}
