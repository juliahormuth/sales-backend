package com.github.juliahormuth.domain.repository;

import com.github.juliahormuth.domain.entity.Client;
import com.github.juliahormuth.domain.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestRepository extends JpaRepository <Request, Integer> {
    List<Request> findByClient(Client client);
}
