package com.example.MultiLinks.Repositories;

import com.example.MultiLinks.Model.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UrlRepository extends JpaRepository<Url, UUID> {
    Url findByUrlEncurtada(String urlEncurtada);
}
