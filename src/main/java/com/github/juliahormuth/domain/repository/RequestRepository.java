package com.github.juliahormuth.domain.repository;

import com.github.juliahormuth.domain.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository <Request, Integer> {
}
