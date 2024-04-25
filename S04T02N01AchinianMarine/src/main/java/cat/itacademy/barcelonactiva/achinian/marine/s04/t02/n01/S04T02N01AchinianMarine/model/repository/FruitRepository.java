package cat.itacademy.barcelonactiva.achinian.marine.s04.t02.n01.S04T02N01AchinianMarine.model.repository;

import cat.itacademy.barcelonactiva.achinian.marine.s04.t02.n01.S04T02N01AchinianMarine.model.domain.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FruitRepository extends JpaRepository<Fruit, Long> {
   List<Fruit> findById(int id);
   List<Fruit> findByName(String name);
}
