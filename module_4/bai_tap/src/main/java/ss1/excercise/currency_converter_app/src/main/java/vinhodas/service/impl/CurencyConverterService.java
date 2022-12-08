package vinhodas.service.impl;

import org.springframework.stereotype.Service;
import vinhodas.service.ICurrencyConverterService;

@Service
public class CurencyConverterService implements ICurrencyConverterService {

    @Override
    public Object change(String usd, String rate) {
        return Double.parseDouble(usd) * Double.parseDouble(rate);
    }
}
