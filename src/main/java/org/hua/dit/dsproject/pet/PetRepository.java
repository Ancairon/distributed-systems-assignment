package org.hua.dit.dsproject.pet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer> {

    @Query(value = "select count(n) from PET n where n.serialNumber= :serialNumber")
    int PetExists(@Param("serialNumber") int serialNumber);
}
