package com.redsea.mas.repository;

import com.redsea.mas.domain.Faculty;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacultyRepository extends CrudRepository<Faculty,Long> {
    Faculty findByEmail(String email);

    @Query(value = "select TOP 10 * from faculty ",nativeQuery = true)
    List<Faculty> getFirstTen();

}
