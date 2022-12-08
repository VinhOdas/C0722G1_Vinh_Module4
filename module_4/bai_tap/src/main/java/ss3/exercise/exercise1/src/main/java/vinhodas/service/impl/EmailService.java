package vinhodas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vinhodas.model.Language;
import vinhodas.repository.IEmailRepository;
import vinhodas.service.IEmailService;

import java.util.List;

@Service
public class EmailService implements IEmailService {
    @Autowired
    IEmailRepository languageRepository;

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
        languageRepository.edit(id, language);
    }


}
