package DAL;

import Entities.TransportEntity;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class TransportDAL {
    
    private Connection connection;
    
    public TransportDAL(Connection connection) {
        this.connection = connection;
    }
    
    public TransportEntity getTransportById(int _id) {
        String sql = "{call GETTRANSPORT(?)}";
        TransportEntity transport = null;

        try (CallableStatement cstmt = connection.prepareCall(sql)) {

            cstmt.setInt(1, _id);

            try (ResultSet rs = cstmt.executeQuery()) {
                if (rs.next()) {
                    transport = mapResultSetToTransport(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transport;
    }

    public List<TransportEntity> getAllTransport() {
        String sql = "{call GETTRANSPORT(?)}";
        List<TransportEntity> transportList = new ArrayList<>();

        try (CallableStatement cstmt = connection.prepareCall(sql)) {
            
            cstmt.setNull(1, Types.INTEGER);

            try (ResultSet rs = cstmt.executeQuery()) {
                while (rs.next()) {
                    TransportEntity transport = mapResultSetToTransport(rs);
                    transportList.add(transport);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transportList;
    }
    
    private TransportEntity mapResultSetToTransport(ResultSet _rs) throws SQLException {
        TransportEntity transportEntity = new TransportEntity();
        
        transportEntity.setId(_rs.getInt("ID"));
        transportEntity.setModel(_rs.getString("MODEL"));
        transportEntity.setMaxSpeed(_rs.getInt("MAX_SPEED"));
        
        return transportEntity;
    }

}