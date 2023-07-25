package pl.kwisniewska.recruitmenttask.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kwisniewska.recruitmenttask.entity.Question;

import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

  @Override
  @EntityGraph(attributePaths = {"answers"})
  Optional<Question> findById(Long id);

}
