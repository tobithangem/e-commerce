package com.ecommerce.tgdd.repositories;

import com.ecommerce.tgdd.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long>, UserRepoCustom {
}
