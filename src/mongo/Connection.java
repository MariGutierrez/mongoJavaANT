package mongo;





import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;


import java.net.UnknownHostException; //error de servidor 
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mongodb.MongoClient;
import java.util.List;
/**
 *
 * @author kika
 */
public class Connection {
    DB BaseDatos;
    DBCollection coleccion;
    BasicDBObject document = new BasicDBObject(); //recibe informacion 
    
    
    public Connection() throws UnknownHostException{
 
        Mongo mongo = new Mongo("localhost",27017);
        BaseDatos = mongo.getDB("escuela");
        coleccion = BaseDatos.getCollection("dsm501");
        System.out.println("Conexion exitosa");
    }

        
    public boolean insertar(String accion){        
        document.put("accion", accion);
        coleccion.insert(document);
        return true;
    }
    
    public void mostrar(){
        DBCursor cursor =  coleccion.find();
        while (cursor.hasNext()) {
            System.out.println(cursor.next());            
        }
    }
    
    public boolean actualizar(String accionVieja, String accionNueva){
        document.put("accion", accionVieja);//bbjsca
        BasicDBObject docNuevo = new BasicDBObject();
        docNuevo.put("accion", accionNueva);
        coleccion.findAndModify(document, docNuevo);
        return true;
    }
    
    public boolean eliminar(String accion){
        document.put("accion", accion);
        coleccion.remove(document);
        return true;    
    }
}
