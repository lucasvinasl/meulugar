package com.lagom.meulugar.repository.profile;

import com.lagom.meulugar.model.profile.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
