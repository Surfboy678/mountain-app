package com.mountainapp.repositories;

import com.mountainapp.models.Mountain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface MountainRepository extends JpaRepository<Mountain, Long>{

    @Query("select m from Mountain m where m.mountainName = ?1")
    Optional<Mountain> findMountainByMountainName(String mountainName);

    @Transactional
    @Modifying
    @Query("select m from Mountain m where m.mountainName = ?1")
    void deleteMountainByMountainName(String mountainName);

    @Query("select m from Mountain m where m.heightAboveSeaLevel <= ?1")
    List<Mountain> findMountainsByHeightAboveSeaLevel(Long height);
}
