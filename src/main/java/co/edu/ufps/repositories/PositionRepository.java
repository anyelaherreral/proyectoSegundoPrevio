package co.edu.ufps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ufps.entities.Position;

public interface PositionRepository extends JpaRepository<Position,Integer>{

}
