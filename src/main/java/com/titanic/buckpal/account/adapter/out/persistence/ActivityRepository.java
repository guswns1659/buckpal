package com.titanic.buckpal.account.adapter.out.persistence;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ActivityRepository extends JpaRepository<ActivityJpaEntity, Long> {

    @Query("select a from ActivityJpaEntity a where a.ownerAccountId = :ownerAccountId and a.timestamp >= :since")
    List<ActivityJpaEntity> findByOwnerSince(
        @Param("ownerAccountId") Long ownerAccountId,
        @Param("since") LocalDateTime since
    );
}
