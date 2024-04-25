package cat.itacademy.barcelonactiva.achinian.marine.s04.t02.n01.S04T02N01AchinianMarine;

import cat.itacademy.barcelonactiva.achinian.marine.s04.t02.n01.S04T02N01AchinianMarine.model.domain.Fruit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import cat.itacademy.barcelonactiva.achinian.marine.s04.t02.n01.S04T02N01AchinianMarine.model.repository.FruitRepository;

@SpringBootApplication
public class S04T02N01AchinianMarineApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext configurableApplicationContext =
				SpringApplication.run(S04T02N01AchinianMarineApplication.class, args);
		FruitRepository fruitRepository =   configurableApplicationContext.getBean(FruitRepository.class);
		Fruit myFruit = new Fruit("Apple", 45);
		fruitRepository.save(myFruit);

	}

}
