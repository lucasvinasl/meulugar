package com.lagom.meulugar.repository.table;

import com.lagom.meulugar.model.table.Tables;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TableRepository extends JpaRepository<Tables, Long> {

    @Query("""
        SELECT tb FROM Tables tb WHERE lower(tb.tableIdentifier) = lower(:identifier)
        """)
    Optional<Tables> findByTableIdentifier(@Param("identifier") String identifier);

    String id(Long id);
}
