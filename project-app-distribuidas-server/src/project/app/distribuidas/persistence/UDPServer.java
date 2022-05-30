package project.app.distribuidas.persistence;

import com.mysql.cj.xdevapi.Client;
import project.app.distribuidas.DataBase.MysqlConnect;
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
import model.Articulo;
import model.Cliente;
import static project.app.distribuidas.DataBase.MysqlConnect.ConnectDB;

public class UDPServer {

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

        while (true) {
            // creamos el socker servidor
            ServerSocket servidor = new ServerSocket(4444);
            Socket clienteNuevo = servidor.accept();
            // leemos lo que esta trayendo el socket
            ObjectInputStream entrada = new ObjectInputStream(clienteNuevo.getInputStream());
            String mensaje = (String) entrada.readObject();
            System.out.println("" + mensaje);
            // separamos los datos
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
                case "/tablaClientes":
                    List lista = tablaClientes();
                    ObjectOutputStream objectOutput = new ObjectOutputStream(clienteNuevo.getOutputStream());
                    objectOutput.writeObject(lista);
                    break;
                case "/addClient":
                    String ruc = parts[1];
                    String nombre = parts[2];
                    String dir = parts[3];
                    int cuidad = 1;
                    String confir = addClient(ruc,nombre,dir,cuidad);
                    ObjectOutputStream res = new ObjectOutputStream(clienteNuevo.getOutputStream());
                    res.writeObject(confir);
                    break;
                case "/listarArticulos":
                     ArrayList<Articulo> Arti = infoArticulo();
                    System.out.println(Arti.get(2).getNombre());
                    for (int i = 0; i < Arti.size(); i++) {
                        System.out.println(Arti.get(i).getId() + " Id ");
                        System.out.println(Arti.get(i).getNombre() + " Nombre");
                        System.out.println(Arti.get(i).getPrecio() + " Precio");
                    }
                    ObjectOutputStream var = new ObjectOutputStream(clienteNuevo.getOutputStream());
                    var.writeObject(Arti);
                default : 
                    
                    break;
            }

            //cerramos conexion
            clienteNuevo.close();
            servidor.close();
        }

    }

    
    static public String addClient(String ruc,String nombre,String dir,int cuidad) throws SQLException{
        String result = "0";
        Connection conn = MysqlConnect.ConnectDB();
        PreparedStatement ps = null;
        int id = 4;
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
                System.out.println("Cerrar conexion registrar");
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

    static List tablaClientes() throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = MysqlConnect.ConnectDB();
        
        String sql = "SELECT CODIGO_CLI,RUC_CLI,NOM_CLI,DIR_CLI FROM cliente";
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        
        List<Cliente> listClientes = new ArrayList<Cliente>();
        
        int columns = 4;
        while (rs.next()) {
            Cliente cli = new Cliente();
            cli.setId(rs.getInt("CODIGO_CLI"));
            cli.setRuc(rs.getString("RUC_CLI"));
            cli.setNombre(rs.getString("NOM_CLI"));
            cli.setDireccion(rs.getString("DIR_CLI"));

            listClientes.add(cli);
        }

        return listClientes;

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
    
    
}
