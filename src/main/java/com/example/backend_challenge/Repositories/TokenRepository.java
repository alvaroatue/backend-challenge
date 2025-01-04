package com.example.backend_challenge.Repositories;

import com.example.backend_challenge.Entities.TokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TokenRepository extends JpaRepository<TokenEntity, Long> {


    @Query("""
        select t from TokenEntity t inner join UserEntity u on t.user.id = u.id
        where u.id = :userId and (t.expired = false or t.revoked = false)
    """)
    List<TokenEntity> findAllValidTokenByUser(Long userId);
}
