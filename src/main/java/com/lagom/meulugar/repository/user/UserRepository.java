package com.lagom.meulugar.repository.user;

import com.lagom.meulugar.model.user.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserAccount, Long> {
}
