package pl.kwisniewska.recruitmenttask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.kwisniewska.recruitmenttask.entity.Answer;

import java.util.Set;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

  @Query("select a from Question q join q.answers a where q.id=:questionId")
  Set<Answer> findAnswersByQuestionId(@Param("questionId") Long questionId);
}
