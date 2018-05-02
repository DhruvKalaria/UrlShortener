package me.dhruv.service;

import me.dhruv.helper.DataConverterHelper;
import org.springframework.stereotype.Service;

/**
 * Created by dhruvkalaria on 4/30/18.
 */
@Service
public class URLShortnerServiceImpl implements URLShortnerService {

    public String encode(Long id) {
        return DataConverterHelper.idToShortURL(id);
    }

    public Long decode(String encodedMessage) {
        return DataConverterHelper.shortURLtoId(encodedMessage);
    }
}