package dev.enterprise.repo;

import dev.enterprise.config.ConnectionUtil;
import dev.enterprise.model.Participant;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ParticipantDao implements CrudRepository<Participant, Integer> {
    @Override
    public void save(Participant participant) {
        try(Connection conn = ConnectionUtil.getInstance().getConnection()){

        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Participant participant) {
        try(Connection conn = ConnectionUtil.getInstance().getConnection()){

        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Participant findById(Integer integer) {
        try(Connection conn = ConnectionUtil.getInstance().getConnection()){

        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Participant> findAll() {
        try(Connection conn = ConnectionUtil.getInstance().getConnection()){

        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
