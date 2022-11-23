package vinhodas.service;

import vinhodas.model.Language;

import java.util.List;

public interface IEmailService {
    List<Language> findAll();


    Language findById(Integer idLanguage);


    void edit(Integer id, Language language);
}
