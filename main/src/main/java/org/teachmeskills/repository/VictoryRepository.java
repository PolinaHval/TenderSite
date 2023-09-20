package org.teachmeskills.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.teachmeskills.model.Victory;
@Repository
public interface VictoryRepository extends JpaRepository<Victory, Integer> {


}
