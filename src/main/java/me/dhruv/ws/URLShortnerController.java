package me.dhruv.ws;

import me.dhruv.model.ShortURL;
import me.dhruv.dao.URLShortnerRepository;
import me.dhruv.service.URLShortnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by dhruvkalaria on 4/29/18.
 */
@RestController
@RequestMapping("/")
public class URLShortnerController {

    @Autowired
    URLShortnerRepository urlShortnerRepository;

    @Autowired
    URLShortnerService urlShortnerService;

    @RequestMapping(value = "create",method = RequestMethod.POST)
    public String createShortURL(@RequestBody String originalURL) {
        ShortURL shortURL = new ShortURL();
        shortURL.setOriginalURL(originalURL);
        shortURL = urlShortnerRepository.save(shortURL);
        urlShortnerRepository.flush();
        String url = urlShortnerService.encode(shortURL.getId());
        shortURL.setShortURL(url);
        urlShortnerRepository.saveAndFlush(shortURL);
        return "localhost:8080/" + url;
    }

    @RequestMapping(value = "{url}",method = RequestMethod.GET)
    public ResponseEntity<Object> returnOriginalURL(@PathVariable String url) {
        Long id = urlShortnerService.decode(url);
        ShortURL obj = urlShortnerRepository.findOne(id);
        urlShortnerRepository.flush();
        try {
            URI uri = new URI(obj.getOriginalURL().trim());
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setLocation(uri);
            return new ResponseEntity<>(httpHeaders,HttpStatus.SEE_OTHER);
        } catch (URISyntaxException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}