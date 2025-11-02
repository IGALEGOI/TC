package BUS;

import DAL.NeighborhoodPathDAL;
import Entities.ConnectionEntity;
import Entities.NeighborhoodPathEntity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class NeighborhoodPathBUS {
    private ConnectionEntity connectionSQL;
    private Connection connection;
    
    public NeighborhoodPathBUS() {
        connectionSQL = ConnectionBUS.getConnectionSQL();
    }
    
    public List<NeighborhoodPathEntity> getAllNeighborhood()
    {
        List<NeighborhoodPathEntity> neighborhoodPathList = new ArrayList<>();
       
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(connectionSQL.getJdbcUrl(), connectionSQL.getUserNameDB(), connectionSQL.getPasswordDB());
            
            NeighborhoodPathDAL neighborhoodPathDAL = new NeighborhoodPathDAL(connection);
            neighborhoodPathList = neighborhoodPathDAL.getAllNeighborhoodPath();
        }
        catch(SQLException | ClassNotFoundException e)
        {
            JOptionPane.showMessageDialog(null, "Erro na conexão!! ","SQL Exceção", JOptionPane.ERROR_MESSAGE);
        }
        finally
        {
            if(connection != null)
            {
                try
                {
                    connection.close();
                }
                catch(SQLException e)
                {
                    JOptionPane.showMessageDialog(null, "Erro ao finalizar a conexão!!","SQL Exceção", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        
        return neighborhoodPathList;
    }
    
    public NeighborhoodPathEntity getNeighborhoodByDirection(String _fromId, String _toId)
    {
        NeighborhoodPathEntity neighborhoodPathEntity = null;

        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(connectionSQL.getJdbcUrl(), connectionSQL.getUserNameDB(), connectionSQL.getPasswordDB());
            
            NeighborhoodPathDAL neighborhoodPathDAL = new NeighborhoodPathDAL(connection);
            neighborhoodPathEntity = neighborhoodPathDAL.getNeighborhoodPathByDirection(_fromId, _toId);
        }
        catch(SQLException | ClassNotFoundException e)
        {
            JOptionPane.showMessageDialog(null, "Erro na conexão!! ","SQL Exceção", JOptionPane.ERROR_MESSAGE);
        }
        finally
        {
            if(connection != null)
            {
                try
                {
                    connection.close();
                }
                catch(SQLException e)
                {
                    JOptionPane.showMessageDialog(null, "Erro ao finalizar a conexão!!","SQL Exceção", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        
        return neighborhoodPathEntity;
    }
}
