
package pettransport;

import java.sql.SQLException;
import pettransport.dao.Database;

/**
 *
 * @author masalas
 */
public class PetTransport {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        new Database();
    }
    
}
