package com.codelover.repository;

<<<<<<< Updated upstream
=======
import java.util.List;
import java.util.Optional;

>>>>>>> Stashed changes
import org.springframework.data.jpa.repository.JpaRepository;

import com.codelover.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

<<<<<<< Updated upstream
=======
	List<Category> findByIsActiveTrueAndIsDeletedFalse();

	Optional<Category> findByIdAndIsDeletedFalse(Integer id);

	List<Category> findByIsDeletedFalse();

>>>>>>> Stashed changes
}
