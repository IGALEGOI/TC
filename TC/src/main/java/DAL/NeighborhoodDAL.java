package DAL;

import Entities.NeighborhoodEntity;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class NeighborhoodDAL {
    private Connection connection;
    
    public NeighborhoodDAL(Connection connection) {
        this.connection = connection;
    }
    
    public NeighborhoodEntity getNeighborhoodByName(String _name) {
        String sql = "{call GETNEIGHBORHOOD(?)}";
        NeighborhoodEntity neighborhood = null;

        try (CallableStatement cstmt = connection.prepareCall(sql)) {

            cstmt.setString(1, _name);

            try (ResultSet rs = cstmt.executeQuery()) {
                if (rs.next()) {
                    neighborhood = mapResultSetToTransport(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return neighborhood;
    }

    public List<NeighborhoodEntity> getAllNeighborhood() {
        String sql = "{call GETNEIGHBORHOOD(?)}";
        List<NeighborhoodEntity> neighborhoodList = new ArrayList<>();

        try (CallableStatement cstmt = connection.prepareCall(sql)) {
            
            cstmt.setNull(1, Types.NVARCHAR);

            try (ResultSet rs = cstmt.executeQuery()) {
                while (rs.next()) {
                    NeighborhoodEntity transport = mapResultSetToTransport(rs);
                    neighborhoodList.add(transport);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return neighborhoodList;
    }
    
    private NeighborhoodEntity mapResultSetToTransport(ResultSet _rs) throws SQLException {
        NeighborhoodEntity neighborhoodEntity = new NeighborhoodEntity();
        
        neighborhoodEntity.setName(_rs.getNString("NAME"));
        neighborhoodEntity.setAxisX(_rs.getInt("AXIS_X"));
        neighborhoodEntity.setAxisY(_rs.getInt("AXIS_Y"));
        
        return neighborhoodEntity;
    }
}