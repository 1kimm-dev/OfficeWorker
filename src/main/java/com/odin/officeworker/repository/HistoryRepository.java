package com.odin.officeworker.repository;

import com.odin.officeworker.entity.HistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepository extends JpaRepository<HistoryEntity, String> {
}
