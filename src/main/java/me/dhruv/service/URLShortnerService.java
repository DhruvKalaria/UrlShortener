package me.dhruv.service;

/**
 * Created by dhruvkalaria on 4/29/18.
 */
public interface URLShortnerService {
    public String encode(Long id);
    public Long decode(String encodedMessage);
}
