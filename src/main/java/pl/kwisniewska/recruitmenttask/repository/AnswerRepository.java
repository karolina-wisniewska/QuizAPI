package pl.kwisniewska.recruitmenttask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kwisniewska.recruitmenttask.entity.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

}
