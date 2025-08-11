package com.example.TarmaLimpia.Basurero;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasureroRepository extends JpaRepository<Basurero,Long> {
}
