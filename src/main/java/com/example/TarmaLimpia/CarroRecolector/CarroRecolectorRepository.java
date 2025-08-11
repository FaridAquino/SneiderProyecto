package com.example.TarmaLimpia.CarroRecolector;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRecolectorRepository extends JpaRepository<CarroRecolector,Long> {
}
