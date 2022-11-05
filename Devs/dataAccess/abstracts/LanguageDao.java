package Kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;

import Kodlama.io.Devs.entities.concretes.Language;

public interface LanguageDao {

	List<Language> getAll();
	void create(Language language);
	void delete(int id);
	void update(Language language, int id);
	Language getById(int Id);
	boolean isValid(Language language);
}
