package com.redis;

import com.redis.model.Todo;
import com.redis.repository.TodoRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class RedisExample2Application implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(RedisExample2Application.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

	}

	@Bean
	public CommandLineRunner loadData(TodoRepository repository){
		return  args -> {
			repository.deleteAll();
			Todo todo1=Todo.builder()
					.title("web developer")
					.completed(true)
					.url("neml.in")
					.build();

			Todo todo2=Todo.builder()
					.title("web designer")
					.completed(true)
					.url("persi.com")
					.build();

			Todo todo3=Todo.builder()
					.title("backend developer")
					.completed(true)
					.url("google.com")
					.build();

			repository.saveAll(List.of(todo1,todo2,todo3));

//			repository.save(Todo.builder().title("Wake up").build());
//			repository.save(Todo.builder().title("Fall out of bed").build());
//			repository.save(Todo.builder().title("Drag a comb across your head").build());

		};
	}
}
