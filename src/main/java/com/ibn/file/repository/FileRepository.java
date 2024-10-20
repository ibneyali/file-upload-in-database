package com.ibn.file.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ibn.file.entity.File;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {
    
}
