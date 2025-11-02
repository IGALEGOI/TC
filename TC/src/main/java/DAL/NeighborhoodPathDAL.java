package DAL;

import Entities.NeighborhoodPathEntity;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class NeighborhoodPathDAL {
    private Connection connection;
    
    public NeighborhoodPathDAL(Connection connection) {
        this.connection = connection;
    }
    
    public NeighborhoodPathEntity getNeighborhoodPathByDirection(String _fromId, String _toId) {
        String sql = "{call GETNEIGHBORHOODPATH(?,?)}";
        NeighborhoodPathEntity neighborhoodPath = null;

        try (CallableStatement cstmt = connection.prepareCall(sql)) {

            cstmt.setString(1, _fromId);
            cstmt.setString(2, _toId);

            try (ResultSet rs = cstmt.executeQuery()) {
                if (rs.next()) {
                    neighborhoodPath = mapResultSetToTransport(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return neighborhoodPath;
    }

    public List<NeighborhoodPathEntity> getAllNeighborhoodPath() {
        String sql = "{call GETNEIGHBORHOODPATH(?,?)}";
        List<NeighborhoodPathEntity> neighborhoodPathList = new ArrayList<>();

        try (CallableStatement cstmt = connection.prepareCall(sql)) {
            
            cstmt.setNull(1, Types.NVARCHAR);
            cstmt.setNull(2, Types.NVARCHAR);

            try (ResultSet rs = cstmt.executeQuery()) {
                while (rs.next()) {
                    NeighborhoodPathEntity transport = mapResultSetToTransport(rs);
                    neighborhoodPathList.add(transport);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return neighborhoodPathList;
    }
    
    private NeighborhoodPathEntity mapResultSetToTransport(ResultSet _rs) throws SQLException {
        NeighborhoodPathEntity neighborhoodPathEntity = new NeighborhoodPathEntity();
        
        neighborhoodPathEntity.setId(_rs.getInt("ID"));
        neighborhoodPathEntity.setFromId(_rs.getString("FROM_ID"));
        neighborhoodPathEntity.setToId(_rs.getString("TO_ID"));
        neighborhoodPathEntity.setDistance(_rs.getInt("DISTANCE"));
        neighborhoodPathEntity.setTraffic(_rs.getInt("TRAFFIC"));
        neighborhoodPathEntity.setMaxSpeed(_rs.getInt("MAX_SPEED"));

        return neighborhoodPathEntity;
    }
}