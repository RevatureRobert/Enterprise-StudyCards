package dev.enterprise.service;

import dev.enterprise.model.QandA;
import dev.enterprise.repo.CrudRepository;
import dev.enterprise.util.ApplicationUtil;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * The service class to work with the dao object and any other java
 *      related logic.
 */
public class QuestionService {

    ApplicationUtil util = ApplicationUtil.INSTANCE;
    CrudRepository<QandA, Integer> questionDao;

    public QuestionService(CrudRepository<QandA, Integer> questionDao) {
        this.questionDao = questionDao;
    }

    public QandA getById(int id) {
        return questionDao.findById(id);
    }

    public Integer save(QandA question){
        System.out.println("in the save of service");
        return questionDao.save(question);

    }

    public Future<Integer> update(QandA question) {
        return util.getThreadActivatah().submit(() -> questionDao.update(question));
    }
}
