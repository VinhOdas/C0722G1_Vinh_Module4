package vinhodas.repository;

import vinhodas.model.Language;

import java.util.List;

public interface IEmailRepository {
    List<Language> findAll();


    Language findById(Integer idLanguage);


    void edit(Integer id, Language language);
}
