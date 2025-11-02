package BUS;

import DAL.NeighborhoodDAL;
import Entities.ConnectionEntity;
import Entities.NeighborhoodEntity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class NeighborhoodBUS {
    private ConnectionEntity connectionSQL;
    private Connection connection;
    
    public NeighborhoodBUS() {
        connectionSQL = ConnectionBUS.getConnectionSQL();
    }
    
    public List<NeighborhoodEntity> getAllNeighborhood()
    {
        List<NeighborhoodEntity> neighborhoodList = new ArrayList<>();
       
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(connectionSQL.getJdbcUrl(), connectionSQL.getUserNameDB(), connectionSQL.getPasswordDB());
            
            NeighborhoodDAL neighborhoodDAL = new NeighborhoodDAL(connection);
            neighborhoodList = neighborhoodDAL.getAllNeighborhood();
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
        
        return neighborhoodList;
    }
    
    public NeighborhoodEntity getNeighborhoodByName(String _name)
    {
        NeighborhoodEntity neighborhoodEntity = null;

        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(connectionSQL.getJdbcUrl(), connectionSQL.getUserNameDB(), connectionSQL.getPasswordDB());
            
            NeighborhoodDAL neighborhoodDAL = new NeighborhoodDAL(connection);
            neighborhoodEntity = neighborhoodDAL.getNeighborhoodByName(_name);
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
        
        return neighborhoodEntity;
    }
}
