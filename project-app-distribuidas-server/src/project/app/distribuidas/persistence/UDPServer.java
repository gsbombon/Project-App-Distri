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
import model.Cliente;

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
                    //validamos
                    String validacion = validationUser(user, pass);
                    //enviamos respesta 
                    ObjectOutputStream respuesta = new ObjectOutputStream(clienteNuevo.getOutputStream());
                    respuesta.writeObject(validacion);
                    break;
                case "/tablaClientes":
                    ArrayList lista = tablalientes();
                    respuesta = new ObjectOutputStream(clienteNuevo.getOutputStream());
                    respuesta.writeObject(lista);
                    break;
                default : 
                    break;
            }

            //cerramos conexion
            clienteNuevo.close();
            servidor.close();
        }

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

    static ArrayList tablalientes() throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = MysqlConnect.ConnectDB();
        
        String sql = "SELECT CODIGO_CLI,RUC_CLI,NOM_CLI,DIR_CLI FROM cliente";
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        
        ArrayList<Cliente> listClientes = new ArrayList<Cliente>();
        int columns = 4;
        while (rs.next()) {
            
            Cliente cli = new Cliente();
            
            cli.setId(rs.getInt("CODIGO_CLI"));
            cli.setRuc(rs.getString("RUC_CLI"));
            cli.setNombre(rs.getString("NOM_CLI"));
            cli.setDireccion(rs.getString("DIR_CLI"));
            // y así sucesivamente con todos los campos del 
            // bean BeanNivelLlenado
            listClientes.add(cli);
        }

        return listClientes;

    }
}
