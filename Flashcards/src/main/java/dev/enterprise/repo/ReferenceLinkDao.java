package dev.enterprise.repo;

import dev.enterprise.util.ApplicationUtil;
import dev.enterprise.model.ReferenceLink;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ReferenceLinkDao implements CrudRepository<ReferenceLink, Integer> {
    @Override
    public int save(ReferenceLink referenceLink) {
        int num = -1;
        try(Connection conn = ApplicationUtil.INSTANCE.getConnection()){

        } catch(SQLException e){
            e.printStackTrace();
        } finally {
            return num;
        }
    }

    @Override
    public int update(ReferenceLink referenceLink) {
        int num = -1;
        try(Connection conn = ApplicationUtil.INSTANCE.getConnection()){

        } catch(SQLException e){
            e.printStackTrace();
        } finally {
            return num;
        }
    }

    @Override
    public ReferenceLink findById(Integer integer) {
        try(Connection conn = ApplicationUtil.INSTANCE.getConnection()){

        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ReferenceLink> findAll() {
        try(Connection conn = ApplicationUtil.INSTANCE.getConnection()){

        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
