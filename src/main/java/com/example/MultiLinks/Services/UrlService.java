package com.example.MultiLinks.Services;

import com.example.MultiLinks.Model.Url;
import com.example.MultiLinks.Repositories.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class UrlService {

    @Autowired
    UrlRepository urlRepository;

    private String gerarUrl(){
        return UUID.randomUUID().toString().substring(0, 5);
    }


    public String encurtarUrl(String urlOriginal){

        if(!urlOriginal.startsWith("http://") || !urlOriginal.startsWith("https://")){
            urlOriginal = "http://" + urlOriginal;
        }

        String urlEncurtada = gerarUrl();

        Url url = new Url();
        url.setUrlOriginal(urlOriginal);
        url.setUrlEncurtada(urlEncurtada);
        url.setDataExpiracao(LocalDate.now().plusDays(30));
        urlRepository.save(url);

        return  urlEncurtada;
    }

}
