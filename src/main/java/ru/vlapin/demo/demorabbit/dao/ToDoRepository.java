package ru.vlapin.demo.demorabbit.dao;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.vlapin.demo.demorabbit.model.ToDo;

public interface ToDoRepository extends JpaRepository<ToDo, UUID> {
}
