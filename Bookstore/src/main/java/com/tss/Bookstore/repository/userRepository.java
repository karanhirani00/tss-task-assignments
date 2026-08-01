package com.tss.Bookstore.repository;

import com.tss.Bookstore.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface userRepository  extends JpaRepository<User , Long> {

    boolean existsByEmail(String email);


    Optional<User> findByIdAndIsDeletedFalse(Long id);

    Page<User> findByIsDeletedFalse(Pageable pageable);
}
