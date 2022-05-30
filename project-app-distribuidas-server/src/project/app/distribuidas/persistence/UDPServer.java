package project.app.distribuidas.persistence;

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

public class UDPServer {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

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
                    //validamos
                    String validacion = validationUser(user, pass);
                    //enviamos respesta 
                    ObjectOutputStream respuesta = new ObjectOutputStream(clienteNuevo.getOutputStream());
                    respuesta.writeObject(validacion);
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
}
