package dev.enterprise.service;

import dev.enterprise.model.QandA;
import dev.enterprise.repo.CrudRepository;
import dev.enterprise.repo.QandADao;
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

    public Future<QandA> getById(int id) throws ExecutionException, InterruptedException {
        Callable<QandA> call = () -> questionDao.findById(id);
        return util.getThreadActivatah().submit(call);
    }

    public Future<Integer> save(QandA question){
        return util.getThreadActivatah().submit(() -> questionDao.save(question));

    }

    public Future<Integer> update(QandA question) {
        return util.getThreadActivatah().submit(() -> questionDao.update(question));
    }
}
