package vinhodas.service.impl;

import org.springframework.stereotype.Service;
import vinhodas.service.IDictionaryService;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class DictionarySerivce implements IDictionaryService {

    @Override
    public Map<String, String> translate() {
        Map<String, String> stringMap = new LinkedHashMap<>();
        stringMap.put("Vinh", "đẹp trai");
        stringMap.put("Hoàng", "xạo chó");
        stringMap.put("Danh", "ngu nữ");

        return stringMap;
    }
}
