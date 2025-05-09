package com.synthlab.synthlab_api.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synthlab.synthlab_api.Entities.Avatar;

public interface AvatarRepository extends JpaRepository<Avatar, Long>{
    Optional<Avatar> findByUserId(Long userId);
}
