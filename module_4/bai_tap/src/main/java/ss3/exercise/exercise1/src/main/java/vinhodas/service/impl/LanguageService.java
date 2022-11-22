package vinhodas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vinhodas.model.Language;
import vinhodas.repository.ILanguageRepository;
import vinhodas.service.ILanguageService;

import java.util.List;

@Service
public class LanguageService implements ILanguageService {
    @Autowired
    ILanguageRepository languageRepository;

    @Override
    public List<Language> findAll() {
        return languageRepository.findAll();
    }

    @Override
    public Language findById(Integer idLanguage) {
        return languageRepository.findById(idLanguage);
    }

    @Override
    public void edit(Integer id, Language language) {
        languageRepository.edit(id,language);
    }


}
