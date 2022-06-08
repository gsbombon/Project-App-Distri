package project.app.distribuidas.persistence;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            String path = parts[0];
            System.out.println(mensaje);
            switch (path) {
                case "/login":
                    String user = parts[1];
                    String pass = parts[2];
                    String validacion = validationUser(user, pass);
                    ObjectOutputStream respuesta = new ObjectOutputStream(clienteNuevo.getOutputStream());
                    respuesta.writeObject(validacion);
                    break;
                case "/addArticulo":
                    String nombre = parts[1];
                    String precio = parts[2];
                    int stock = Integer.parseInt(parts[3]);
                    String confir = addArticulo(nombre, precio, stock);
                    ObjectOutputStream res = new ObjectOutputStream(clienteNuevo.getOutputStream());
                    res.writeObject(confir);
                    break;
                case "/addTipoMov":
                    String nombreM = parts[1];
                    String signoM = parts[2];
                    String confirM = addTipoMov(nombreM, signoM);
                    ObjectOutputStream resM = new ObjectOutputStream(clienteNuevo.getOutputStream());
                    resM.writeObject(confirM);
                    break;

                case "/modArticulo":
                    int idMod = Integer.parseInt(parts[1]);
                    String nombreNew = parts[2];
                    String precioNew = parts[3];
                    int stockNew = Integer.parseInt(parts[4]);
                    String confirMod = modArticulo(idMod, nombreNew, precioNew, stockNew);
                    ObjectOutputStream resMod = new ObjectOutputStream(clienteNuevo.getOutputStream());
                    resMod.writeObject(confirMod);
                    break;
                case "/modTipoMov":
                    int idModM = Integer.parseInt(parts[1]);
                    String nombreMNew = parts[2];
                    String signoMNew = parts[3];
                    String confirModM = modTipoMov(idModM, nombreMNew, signoMNew);
                    ObjectOutputStream resModM = new ObjectOutputStream(clienteNuevo.getOutputStream());
                    resModM.writeObject(confirModM);
                    break;

                /* case "/delCliente":
                    int idDel = Integer.parseInt(parts[1]);
                    String delCli = delArticulo(idDel);
                    ObjectOutputStream resDel = new ObjectOutputStream(clienteNuevo.getOutputStream());
                    resDel.writeObject(delCli);
                    break;*/
                case "/delArticulo":
                    int idDelArt = Integer.parseInt(parts[1]);
                    String delArt = delArticulo(idDelArt);
                    ObjectOutputStream resDelArt = new ObjectOutputStream(clienteNuevo.getOutputStream());
                    resDelArt.writeObject(delArt);
                    break;
                case "/delTipoMov":
                    int idDelMov = Integer.parseInt(parts[1]);
                    String delMov = delTipoMov(idDelMov);
                    ObjectOutputStream resDelMov = new ObjectOutputStream(clienteNuevo.getOutputStream());
                    resDelMov.writeObject(delMov);
                    break;

            }

            clienteNuevo.close();
            servidor.close();
        }

    }

    static public String delArticulo(int id) {
        String result = "0";
        Connection conn = MysqlConnect.ConnectDB();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM articulo WHERE CODIGO_ART=?");
            ps.setInt(1, id);
            ps.execute();
            result = "1";

        } catch (SQLException ex) {
            System.out.println(ex.toString());
            result = "0";
        }

        return result;
    }

    static public String delTipoMov(int id) {
        String result = "0";
        Connection conn = MysqlConnect.ConnectDB();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM tipomovimiento WHERE CODIGO_TMOV=?");
            ps.setInt(1, id);
            ps.execute();
            result = "1";

        } catch (SQLException ex) {
            System.out.println(ex.toString());
            result = "0";
        }

        return result;
    }

    static public String modArticulo(int id, String nombre, String precio, int stock) {
        String result = "0";
        Connection conn = MysqlConnect.ConnectDB();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE articulo SET NOMBRE_ART=?, PRECIO_ART=? , STOCK_ART =? WHERE CODIGO_ART=?");
            ps.setString(1, nombre);
            ps.setString(2, precio);
            ps.setInt(3, stock);
            ps.setInt(4, id);
            ps.execute();
            System.out.println("QUERY: " + ps.toString());
            result = "1";
        } catch (SQLException ex) {
            System.out.println(ex);
            result = "0";
        }
        return result;
    }

    static public String modTipoMov(int id, String nombre, String signo) {
        String result = "0";
        Connection conn = MysqlConnect.ConnectDB();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE tipomovimiento SET NOMBRE_TMOV=?, SIGNO_TMOV=? WHERE CODIGO_TMOV=?");
            ps.setString(1, nombre);
            ps.setString(2, signo);
            ps.setInt(3, id);
            ps.execute();
            System.out.println("QUERY: " + ps.toString());
            result = "1";
        } catch (SQLException ex) {
            System.out.println(ex);
            result = "0";
        }
        return result;
    }

    static public String addArticulo(String nombre, String precio, int stock) throws SQLException {
        String result = "0";
        Connection conn = MysqlConnect.ConnectDB();
        PreparedStatement ps = null;
        String sql = "INSERT INTO articulo (`NOMBRE_ART`,`PRECIO_ART`,`STOCK_ART`) VALUES (?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, precio);
            ps.setInt(3, stock);
            ps.execute();
            result = "1";

        } catch (SQLException e) {
            System.err.println(e);
            result = "0";
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return result;
    }

    static public String addTipoMov(String nombre, String signo) throws SQLException {
        String result = "0";
        Connection conn = MysqlConnect.ConnectDB();
        PreparedStatement ps = null;
        String sql = "INSERT INTO tipomovimiento (`NOMBRE_TMOV`,`SIGNO_TMOV`) VALUES (?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, signo);
            ps.execute();
            result = "1";

        } catch (SQLException e) {
            System.err.println(e);
            result = "0";
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
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

}
