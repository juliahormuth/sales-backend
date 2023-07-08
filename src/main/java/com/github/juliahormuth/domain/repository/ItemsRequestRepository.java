package com.github.juliahormuth.domain.repository;

import com.github.juliahormuth.domain.entity.ItemRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsRequestRepository extends JpaRepository <ItemRequest, Integer> {
}
