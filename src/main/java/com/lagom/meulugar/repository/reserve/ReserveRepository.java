package com.lagom.meulugar.repository.reserve;

import com.lagom.meulugar.model.reserve.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReserveRepository extends JpaRepository<Reserve, Long> {
}
