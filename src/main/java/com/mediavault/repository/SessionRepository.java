package com.mediavault.repository;

import com.mediavault.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface SessionRepository extends JpaRepository<Session, Long>{
    Optional<Session> findByAccessToken(String accessToken);
    Optional<Session> findByUserId(Long userId);

    void deleteByAccessToken(String accessToken);
}
