package me.dhruv.dao;

import me.dhruv.model.ShortURL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by dhruvkalaria on 4/29/18.
 */
@Repository
public interface URLShortnerRepository extends JpaRepository<ShortURL, Long> {
}
