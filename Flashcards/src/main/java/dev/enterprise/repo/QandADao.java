package dev.enterprise.repo;

import dev.enterprise.util.ApplicationUtil;
import dev.enterprise.model.Participant;
import dev.enterprise.model.QandA;
import dev.enterprise.model.ReferenceLink;
import dev.enterprise.model.Topic;

import java.sql.*;
import java.util.*;

public class QandADao implements CrudRepository<QandA, Integer> {

    @Override
    public int save(QandA qandA) {
        try (Connection conn = ApplicationUtil.INSTANCE.getConnection()) {
            String sql = "insert into q_and_a (question, topic) values (?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, qandA.getQuestion());

            //ordinal begins counts at 0, so add 1 to keep in sync with db
            ps.setInt(2, qandA.getTopic().ordinal() + 1);

            //We don't care right now what it returns, could refactor this later on if we want
             return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int update(QandA qandA) {
        try (Connection conn = ApplicationUtil.INSTANCE.getConnection()) {

            // make it easier, clearer to get indexes of the string
            Map<String, Integer> indexes = new HashMap<>();
            indexes.put("question", 1);
            indexes.put("answer", 2);
            indexes.put("ref", 3);
            indexes.put("responsible", 4);
            indexes.put("topic", 5);
            indexes.put("id", 6);


            String sql = "update q_and_a set question = ?, answer = ?, reference_link = ?, responsible = ?, topic = ? where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            // set the values given by the indexes in the map
            ps.setString(indexes.get("question"), qandA.getQuestion());
            ps.setString(indexes.get("answer"), qandA.getAnswer());
            ps.setInt(indexes.get("ref"), qandA.getReferenceLink().getId());
            ps.setInt(indexes.get("responsible"), qandA.getResponsible().getId());
            ps.setInt(indexes.get("topic"), qandA.getTopic().ordinal() + 1);
            ps.setInt(indexes.get("id"), qandA.getId());

            //We don't care right now what it returns, could refactor this later on if we want
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public QandA findById(Integer integer) {
        QandA q = null;

        try (Connection conn = ApplicationUtil.INSTANCE.getConnection()) {

//            conn.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
//            Savepoint sp = conn.setSavepoint("beginning");

            String sql = "select q.id as id, q.question as question, q.answer as answer, " +
                    "q.reference_link as reference_link, q.responsible as responsible, " +
                    "r.topic as topic_id, r.address as address, r.subtopic as subtopic, " +
                    "p.name as participant_name, t.topic as topic_name from q_and_a q " +
                    "inner join reference_link r on " +
                    "q.reference_link = r.id inner join participant p on q.responsible = p.id " +
                    "inner join topic t on q.topic = t.id where q.id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, integer);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                q = new QandA(
                        rs.getInt("id"),
                        rs.getString("question"),
                        rs.getString("answer"),
                        new ReferenceLink(
                                rs.getInt("reference_link"),
                                rs.getString("address"),
                                Topic.valueOf(rs.getString("topic_name").replace(" ", "_").toUpperCase()),
                                rs.getString("subtopic")
                        ),
                        new Participant(
                                rs.getInt("responsible"),
                                rs.getString("participant_name")
                        ),
                        Topic.valueOf(rs.getString("topic_name").replace(" ", "_").toUpperCase())
                );
            }
//            conn.rollback(sp);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return q;
        }
    }


    @Override
    public List<QandA> findAll() {

        List<QandA> questions = new LinkedList<>();
        try (Connection conn = ApplicationUtil.INSTANCE.getConnection()) {

            String sql = "select q.id as id, q.question as question, q.answer as answer, " +
                    "a.reference_link as reference_link, r.responsible as responsible, " +
                    "r.topic as topic_id, r.address as address, r.subtopic as subtopic, " +
                    "p.name as participant_name, topic.topic as topic_name from q_and_a q " +
                    "inner join reference_link r where " +
                    "a.reference_link = r.id inner join participant p on a.responsible = p.id " +
                    "inner join topic t on a.topic = t.id";

            ResultSet rs = conn.prepareStatement(sql).executeQuery();
            while (rs.next()) {
                questions.add(new QandA(
                        rs.getInt("id"),
                        rs.getString("question"),
                        rs.getString("answer"),
                        new ReferenceLink(
                                rs.getInt("reference_link"),
                                rs.getString("address"),
                                Topic.valueOf(rs.getString("topic_name").replace(" ", "_").toUpperCase()),
                                rs.getString("subtopic")
                        ),
                        new Participant(
                                rs.getInt("responsible"),
                                rs.getString("participant_name")
                        ),
                        Topic.valueOf(rs.getString("topic_name").replace(" ", "_").toUpperCase())
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return questions;
        }
    }
}
