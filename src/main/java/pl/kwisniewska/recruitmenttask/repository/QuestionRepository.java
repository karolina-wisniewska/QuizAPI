package pl.kwisniewska.recruitmenttask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kwisniewska.recruitmenttask.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

}
