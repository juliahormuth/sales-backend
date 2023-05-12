package com.github.juliahormuth.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.github.juliahormuth.domain.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    // Query Methods
    // List<Client> findByNameLike(String name);

    @Query(value = "select  * from Client c where c.name like '%:name' ", nativeQuery = true)
    List<Client> findByName(@Param("name") String name);

    @Query("delete from Client c where c.name =:name ")
    @Modifying
    void DeleteByName(String name);

    boolean existsByName(String name);

}
