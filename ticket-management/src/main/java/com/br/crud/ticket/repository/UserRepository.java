package com.br.crud.ticket.repository;

import java.util.UUID;
import java.util.List;
import com.br.crud.ticket.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    List<UserEntity> findById(boolean published);
}