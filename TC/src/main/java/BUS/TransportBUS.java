package BUS;

import DAL.TransportDAL;
import Entities.ConnectionEntity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Entities.TransportEntity;
import java.util.ArrayList;
import java.util.List;

public class TransportBUS {
    
    private ConnectionEntity connectionSQL;
    private Connection connection;
    
    public TransportBUS() {
        connectionSQL = ConnectionBUS.getConnectionSQL();
    }
    
    public List<TransportEntity> getAllTransport()
    {
        List<TransportEntity> transportList = new ArrayList<>();
       
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(connectionSQL.getJdbcUrl(), connectionSQL.getUserNameDB(), connectionSQL.getPasswordDB());
            
            TransportDAL transportDAL = new TransportDAL(connection);
            transportList = transportDAL.getAllTransport();
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
        
        return transportList;
    }
    
    public TransportEntity getTransportById(int _transportId)
    {
        TransportEntity transportEntity = null;

        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(connectionSQL.getJdbcUrl(), connectionSQL.getUserNameDB(), connectionSQL.getPasswordDB());
            
            TransportDAL transportDAL = new TransportDAL(connection);
            transportEntity = transportDAL.getTransportById(_transportId);
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
        
        return transportEntity;
    }
}
