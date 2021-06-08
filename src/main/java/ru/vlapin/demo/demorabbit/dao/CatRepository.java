package ru.vlapin.demo.demorabbit.dao;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.vlapin.demo.demorabbit.model.Cat;

public interface CatRepository extends JpaRepository<Cat, UUID> {
}
