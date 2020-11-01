package com.magicbox.repository;

import com.magicbox.domain.PersistentAuditEvent;
import java.time.Instant;
import java.util.List;
import org.neo4j.springframework.data.repository.Neo4jRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Spring Data Neo4j repository for the {@link PersistentAuditEvent} entity.
 */
public interface PersistenceAuditEventRepository extends Neo4jRepository<PersistentAuditEvent, String> {
    List<PersistentAuditEvent> findByPrincipal(String principal);

    List<PersistentAuditEvent> findByPrincipalAndAuditEventDateAfterAndAuditEventType(String principal, Instant after, String type);

    Page<PersistentAuditEvent> findAllByAuditEventDateBetween(Instant fromDate, Instant toDate, Pageable pageable);

    List<PersistentAuditEvent> findByAuditEventDateBefore(Instant before);
}
