    package project.app.distribuidas.persistence;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Articulo;
import model.Cliente;
import model.Cobrador;
import project.app.distribuidas.DataBase.MysqlConnect;

public class UDPServer {

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

        while (true) {
            ServerSocket servidor = new ServerSocket(4444);
            Socket clienteNuevo = servidor.accept();

            ObjectInputStream entrada = new ObjectInputStream(clienteNuevo.getInputStream());
            String mensaje =     (String) entrada.readObject();
            System.out.println("" + mensaje);

            String[] parts = mensaje.split(";");
            String path = parts[0];
            
            switch (path) {
                case "/login":
                    String user = parts[1];
                    String pass = parts[2];
                    String validacion = validationUser(user, pass);
                    ObjectOutputStream respuesta = new ObjectOutputStream(clienteNuevo.getOutputStream());
                    respuesta.writeObject(validacion);
                    break;
                case "/addNewUser":
                    String userNew = parts[1];
                    String passNew = parts[2];
                    String strAddNewUser = addNewUser(userNew,passNew);
                    ObjectOutputStream resAddNewUser = new ObjectOutputStream(clienteNuevo.getOutputStream());
                    resAddNewUser.writeObject(strAddNewUser);
                    break;
                case "/addClient":
                    String ruc = parts[1];
                    String nombre = parts[2];
                    String dir = parts[3];
                    int cuidad = Integer.parseInt(parts[4]);
                    String confir = addClient(ruc,nombre,dir,cuidad);
                    ObjectOutputStream res = new ObjectOutputStream(clienteNuevo.getOutputStream());
                    res.writeObject(confir);
                    break;
                case "/modCliente":
                    int idMod = Integer.parseInt(parts[1]);
                    int id_cuidad = Integer.parseInt(parts[2]);
                    String rucNew = parts[3];
                    String nombreNew = parts[4];
                    String dirNew = parts[5];
                    
                    String confirMod = modClient(idMod,id_cuidad,rucNew,nombreNew,dirNew);
                    ObjectOutputStream resMod = new ObjectOutputStream(clienteNuevo.getOutputStream());
                    resMod.writeObject(confirMod);
                    break;
                case "/delCliente":
                    int idDel = Integer.parseInt(parts[1]);
                    String delCli = delClient(idDel);
                    ObjectOutputStream resDel = new ObjectOutputStream(clienteNuevo.getOutputStream());
                    resDel.writeObject(delCli);
                    break;
                case "/delArtFac":
                    int idArtDel = Integer.parseInt(parts[1]);
                    int codCabe = Integer.parseInt(parts[2]);
                    int codDetalle = Integer.parseInt(parts[3]);
                    String delArtFact = delArtFact(idArtDel,codCabe,codDetalle);
                    ObjectOutputStream resDelArtFact = new ObjectOutputStream(clienteNuevo.getOutputStream());
                    resDelArtFact.writeObject(delArtFact);
                    break;
                case "/modArtFac":
                    int idArtMod = Integer.parseInt(parts[1]);
                    int codCabeMod = Integer.parseInt(parts[2]);
                    int codDetalleMod = Integer.parseInt(parts[3]);
                    int cantMod = Integer.parseInt(parts[4]);
                    String modArtFactu = modArtFact(idArtMod,codCabeMod,codDetalleMod,cantMod);
                    ObjectOutputStream resModArtFact = new ObjectOutputStream(clienteNuevo.getOutputStream());
                    resModArtFact.writeObject(modArtFactu);
                    break;
                case "/addCiudad":
                    String nomCuidad = parts[1];
                    String addCiudad = addCiudad(nomCuidad);
                    ObjectOutputStream resAddCiudad = new ObjectOutputStream(clienteNuevo.getOutputStream());
                    resAddCiudad.writeObject(addCiudad);
                    break;    
                case "/modCiudad":
                    int idCiudad = Integer.parseInt(parts[1]);
                    String nomCiuNew = parts[2];
                    String modCiudad = modCiudad(idCiudad,nomCiuNew);
                    ObjectOutputStream resModCiudad = new ObjectOutputStream(clienteNuevo.getOutputStream());
                    resModCiudad.writeObject(modCiudad);
                    break;    
                case "/delCiudad":
                    int idCiuDel = Integer.parseInt(parts[1]);
                    String delCiudad = delCiudad(idCiuDel);
                    ObjectOutputStream resDelCiu = new ObjectOutputStream(clienteNuevo.getOutputStream());
                    resDelCiu.writeObject(delCiudad);
                    break;
            }

            clienteNuevo.close();
            servidor.close();
        }

    }

    static public String delCiudad(int id){
        String result = "0";
        Connection conn = MysqlConnect.ConnectDB();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM ciudad WHERE CODIGO_CIU=?");
            ps.setInt(1, id);
            ps.execute();
            result = "1";
        } catch (SQLException ex) {            
            System.out.println(ex.toString());
            result = "0";
        }
        return result;
    }
    
    static public String modCiudad(int id,String nombre){
        String result = "0";
        Connection conn = MysqlConnect.ConnectDB();
        PreparedStatement ps = null;
        try {            
            ps = conn.prepareStatement("UPDATE ciudad SET NOMBRE_CIU=? WHERE CODIGO_CIU=?");           
            ps.setString(1, nombre);
            ps.setInt(2, id);
            ps.execute();
            result = "1";
        } catch (SQLException ex) {
            System.out.println(ex);
            result = "0";
        }
        return result;
    }
    
    static public String addCiudad(String nombre) throws SQLException{
        String result = "0";
        Connection conn = MysqlConnect.ConnectDB();
        PreparedStatement ps = null;
        String sql = "INSERT INTO ciudad (`NOMBRE_CIU`) VALUES (?)";
        try{
            ps = conn.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.execute();
            result="1";
        }catch(SQLException e){
            System.err.println(e);
            result="0";
        }finally{
            try{
                conn.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
        return result;
    }
    
    static public String modArtFact(int codArt, int numCabecera, int codDetalle, int cantNew){
        String result = "0";
        Connection conn = MysqlConnect.ConnectDB();
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement("UPDATE detalle_comprobante_factura\n" +
                                        "SET CANTIDAD_DETALLE_COMPROBANTE_FACTURA = ?\n" +
                                        "WHERE CODIGO_ART = ? AND NUMERO_CABECERA_FACTU = ? AND CODIGO_DETALLE_COMPROBANTE_FACTURA = ?;");
            ps.setInt(1, cantNew);
            ps.setInt(2, codArt);
            ps.setInt(3, numCabecera);
            ps.setInt(4, numCabecera);
            
            ps.execute();
            result = "1";
        } catch (SQLException ex) {            
            System.out.println(ex.toString());
            result = "0";
        }
        
        return result;
    }
    
    static public String delArtFact(int codArt, int numCabecera, int codDetalle){
        String result = "0";
        Connection conn = MysqlConnect.ConnectDB();
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement("DELETE FROM detalle_comprobante_factura WHERE CODIGO_ART=? AND NUMERO_CABECERA_FACTU = ? AND CODIGO_DETALLE_COMPROBANTE_FACTURA = ?");
            ps.setInt(1, codArt);
            ps.setInt(2, numCabecera);
            ps.setInt(3, numCabecera);
            
            ps.execute();
            result = "1";
        } catch (SQLException ex) {            
            System.out.println(ex.toString());
            result = "0";
        }
        
        return result;
    }
    
    static public String delClient(int id){
        String result = "0";
        Connection conn = MysqlConnect.ConnectDB();
        PreparedStatement ps = null;        
        try {
            ps = conn.prepareStatement("DELETE FROM cliente WHERE CODIGO_CLI=?");
            ps.setInt(1, id);
            ps.execute();

            
            result = "1";
        } catch (SQLException ex) {            
            System.out.println(ex.toString());
            result = "0";
        }
        
        return result;
    }
    
    static public String modClient(int id,int id_cuidad,String ruc, String nombre, String direccion){
        String result = "0";
        Connection conn = MysqlConnect.ConnectDB();
        PreparedStatement ps = null;
        try {            
            ps = conn.prepareStatement("UPDATE cliente SET CODIGO_CIU=?, RUC_CLI=?, NOM_CLI=?, DIR_CLI=? WHERE CODIGO_CLI=?");
            
            ps.setInt(1, id_cuidad);
            ps.setString(2, ruc);
            ps.setString(3, nombre);
            ps.setString(4, direccion);
            ps.setInt(5, id);
            ps.execute();
            System.out.println("QUERY: "+ps.toString());
            result = "1";
        } catch (SQLException ex) {
            System.out.println(ex);
            result = "0";
        }
        return result;
    }
    
    static public String addClient(String ruc,String nombre,String dir,int cuidad) throws SQLException{
        String result = "0";
        Connection conn = MysqlConnect.ConnectDB();
        PreparedStatement ps = null;
        String sql = "INSERT INTO cliente (`CODIGO_CIU`,`RUC_CLI`,`NOM_CLI`,`DIR_CLI`) VALUES (?,?,?,?)";        
        try{
            ps = conn.prepareStatement(sql);
            ps.setInt(1, cuidad);
            ps.setString(2, ruc);
            ps.setString(3, nombre);
            ps.setString(4, dir);
            ps.execute();
            result="1";
        }catch(SQLException e){
            System.err.println(e);
            result="0";
        }finally{
            try{
                conn.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
        return result;
    }
    
    static public String validationUser(String user, String pass) {
        String result = "0";
        Connection conn = MysqlConnect.ConnectDB();
        String sql = "Select * from usuarios where user=? and pass=?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, user);
            pst.setString(2, pass);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                result = "1";
            } else {
                result = "0";
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
        return result;
    }
      
    public static ArrayList<Articulo> infoArticulo(){
        ArrayList<Articulo> arti=new ArrayList();
        Connection conn = MysqlConnect.ConnectDB();
        String sql = "Select * from articulo";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){  
                Articulo nuevoArt = new Articulo();
                nuevoArt.setId(rs.getInt(1));
                nuevoArt.setNombre(rs.getString(2));
                nuevoArt.setPrecio(rs.getString(3));
                arti.add(nuevoArt);
            }
    
         } catch (Exception e) {
             System.out.println("Error");

         }
     
          for(int i = 0; i<arti.size(); i++)
            {
                System.out.println(arti.get(i).getId()+ " Id");
                System.out.println(arti.get(i).getNombre()+ " Nombre");
                System.out.println(arti.get(i).getPrecio()+ " Precio");
            }
         return arti;
     }

    static private String addNewUser(String userNew, String passNew) {
        String result = "0";
        Connection conn = MysqlConnect.ConnectDB();
        PreparedStatement ps = null;
        String sql = "INSERT INTO `usuarios`(`USER`,`PASS`)VALUES(?,?)";
        try{
            ps = conn.prepareStatement(sql);
            ps.setString(1, userNew);
            ps.setString(2, passNew);
            ps.execute();
            result="1";
        }catch(SQLException e){
            System.err.println(e);
            result="0";
        }finally{
            try{
                conn.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
        return result;
    }
    
    
}
