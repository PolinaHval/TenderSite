package org.teachmeskills.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.teachmeskills.model.Tender;
import org.teachmeskills.model.Victory;

import java.util.List;
import java.util.Optional;
@Repository
public interface TenderRepository extends JpaRepository<Tender, Integer> {

  Tender getTenderById(int tenderId);

  Optional<Tender> findTenderById(int tenderId);

}
