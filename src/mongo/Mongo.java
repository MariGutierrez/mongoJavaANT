package mongo;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoIterable;



import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 *
 * @author kika
 */
public class Mongo {

    public static void main(String[] args) throws UnknownHostException {
        
     Connection con = new Connection();
     con.mostrar();
    }
    
}
