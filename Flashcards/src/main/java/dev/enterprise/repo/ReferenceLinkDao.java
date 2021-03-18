package dev.enterprise.repo;

import dev.enterprise.config.ConnectionUtil;
import dev.enterprise.model.ReferenceLink;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ReferenceLinkDao implements CrudRepository<ReferenceLink, Integer> {
    @Override
    public void save(ReferenceLink referenceLink) {
        try(Connection conn = ConnectionUtil.getInstance().getConnection()){

        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(ReferenceLink referenceLink) {
        try(Connection conn = ConnectionUtil.getInstance().getConnection()){

        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public ReferenceLink findById(Integer integer) {
        try(Connection conn = ConnectionUtil.getInstance().getConnection()){

        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ReferenceLink> findAll() {
        try(Connection conn = ConnectionUtil.getInstance().getConnection()){

        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
