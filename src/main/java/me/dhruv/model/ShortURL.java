package me.dhruv.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by dhruvkalaria on 4/29/18.
 */
@Entity
@Data @Builder @NoArgsConstructor @AllArgsConstructor @ToString
public class ShortURL {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String shortURL;
    String originalURL;
}
