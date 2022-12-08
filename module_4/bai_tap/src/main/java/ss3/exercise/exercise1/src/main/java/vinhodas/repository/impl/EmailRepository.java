package vinhodas.repository.impl;

import org.springframework.stereotype.Repository;
import vinhodas.model.Language;
import vinhodas.repository.IEmailRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmailRepository implements IEmailRepository {
    private static List<Language> languageList = new ArrayList<>();

    static {
        languageList.add(new Language(1, "English", "25", true, "f"));
        languageList.add(new Language(2, "English", "25", false, "Thor"));

    }

    @Override
    public List<Language> findAll() {
        return languageList;
    }

    @Override
    public Language findById(Integer idLanguage) {
        for (Language language : languageList) {
            if (language.getId() == idLanguage) {
                return language;
            }
        }
        return null;
    }

    @Override
    public void edit(Integer id, Language language) {
        int index = findIndex(id);
        languageList.remove(index);
        languageList.add(index, language);
    }

    public int findIndex(int id) {
        for (int i = 0; i < languageList.size(); i++) {
            if (languageList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

}
