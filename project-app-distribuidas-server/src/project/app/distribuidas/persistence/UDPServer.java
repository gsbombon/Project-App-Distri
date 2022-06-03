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
import model.Articulo;
import model.Cliente;
import model.Cobrador;
import project.app.distribuidas.DataBase.MysqlConnect;

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
            String user = parts[0];
            String pass = parts[1];
            String path = parts[2];
            

            switch (path) {
                case "/login":
                   /* String user = parts[1];
                    String pass = parts[2];*/
                    String validacion = validationUser(user, pass);
                    ObjectOutputStream respuesta = new ObjectOutputStream(clienteNuevo.getOutputStream());
                    respuesta.writeObject(validacion);
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
<<<<<<< Updated upstream
<<<<<<< Updated upstream
                case "/findClientes":
                    String ruc_find = parts[1];
                    ArrayList<Cliente> listaClientes = findClients(ruc_find);
                    for(int i = 0; i < listaClientes.size(); i++) {
                            System.out.println(listaClientes.get(i).getNombre());
                            System.out.println(listaClientes.get(i).getRuc());
                    }
                    ObjectOutputStream resCli = new ObjectOutputStream(clienteNuevo.getOutputStream());
                    resCli.writeObject(listaClientes);
                    break;
                case "/tablaCobrador":
                    ArrayList<Cobrador> Cobras = infoCobrador();
                    for (int i = 0; i < Cobras.size(); i++) {
                        System.out.println(Cobras.get(i).getId_cobrador() + " Id Case");
                        System.out.println(Cobras.get(i).getCedula_cobrador() + " Cedula");
                        System.out.println(Cobras.get(i).getNombre_cobrador() + " Nombre");
                        System.out.println(Cobras.get(i).getDireccion_cobrador() + " Direccion Case");
                    }
                    ObjectOutputStream resCobra = new ObjectOutputStream(clienteNuevo.getOutputStream());
                    resCobra.writeObject(Cobras);
                    break;
                case "/listarArticulos":
=======
                case "listarArticulos":
>>>>>>> Stashed changes
=======
                case "listarArticulos":
                     ArrayList<Articulo> Arti = infoArticulo();
                    System.out.println(Arti.get(1).getNombre());
                    for (int i = 0; i < Arti.size(); i++) {
                        System.out.println(Arti.get(i).getId() + " Codigo");
                        System.out.println(Arti.get(i).getNombre() + " Nombre");
                        System.out.println(Arti.get(i).getPrecio() + " Precio");
                    }
                    ObjectOutputStream var = new ObjectOutputStream(clienteNuevo.getOutputStream());
                    var.writeObject(Arti);
                    break;
                default : 
                    
                    break;
            }

            clienteNuevo.close();
            servidor.close();
        }

    }

    public static ArrayList<Cobrador> infoCobrador(){
        ArrayList<Cobrador> cobradores=new ArrayList();
        Connection conn = MysqlConnect.ConnectDB();
        String sql = "Select * from cobra";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){  
                Cobrador nuevoCobra = new Cobrador();
                nuevoCobra.setId_cobrador(rs.getInt(1));
                nuevoCobra.setCedula_cobrador(rs.getString(2));
                nuevoCobra.setNombre_cobrador(rs.getString(3));
                nuevoCobra.setDireccion_cobrador(rs.getString(4));
                cobradores.add(nuevoCobra);
            }
    
         } catch (Exception e) {
             System.out.println("Error");

         }
     
          for(int i = 0; i<cobradores.size(); i++)
            {
                System.out.println(cobradores.get(i).getId_cobrador()+ " Id Info");
                System.out.println(cobradores.get(i).getCedula_cobrador()+ " Cedula");
                System.out.println(cobradores.get(i).getNombre_cobrador()+ " Nombre");
                 System.out.println(cobradores.get(i).getDireccion_cobrador()+ " Direccion");
            }
         return cobradores;
     }
    
    static public ArrayList<Cliente> findClients(String ruc) throws SQLException{
        ArrayList<Cliente> lista = new ArrayList<Cliente>();
        String where = "";
        if (!"".equals(ruc)) {
            where = "WHERE RUC_CLI = '" + ruc + "'";
        }
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = MysqlConnect.ConnectDB();
        
        
        String sql = "SELECT * FROM cliente " + where;
        System.out.println(sql);
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();

        while(rs.next()){  
            Cliente new_client = new Cliente();
            new_client.setId(rs.getInt(1));
            new_client.setId_cuidad(rs.getInt(2));
            new_client.setRuc(rs.getString(3));
            new_client.setNombre(rs.getString(4));
            new_client.setDireccion(rs.getString(5));
            lista.add(new_client);
        }
    
        return lista;
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
        String sql = "Select * from ARTICULO";
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
             System.out.println("Error listar");

         }
         return arti;
     }
    
    
}
