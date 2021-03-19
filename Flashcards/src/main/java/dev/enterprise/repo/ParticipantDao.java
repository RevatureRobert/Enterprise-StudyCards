package dev.enterprise.repo;

import dev.enterprise.util.ApplicationUtil;
import dev.enterprise.model.Participant;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ParticipantDao implements CrudRepository<Participant, Integer> {
    @Override
    public int save(Participant participant) {
        int num = -1;
        try(Connection conn = ApplicationUtil.INSTANCE.getConnection()){

        } catch(SQLException e){
            e.printStackTrace();
        } finally {
            return num;
        }
    }

    @Override
    public int update(Participant participant) {
        int num = -1;
        try(Connection conn = ApplicationUtil.INSTANCE.getConnection()){

        } catch(SQLException e){
            e.printStackTrace();
        } finally {
            return num;
        }
    }

    @Override
    public Participant findById(Integer integer) {
        try(Connection conn = ApplicationUtil.INSTANCE.getConnection()){

        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Participant> findAll() {
        try(Connection conn = ApplicationUtil.INSTANCE.getConnection()){

        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
