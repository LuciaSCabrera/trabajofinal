package com.example.tpfinal;
mport java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EstudiantesDAO {

    public EstudiantesDAO obtenerPorIdPersona(int id) {
        String sql = "SELECT * FROM trabajofinal WHERE ID-PERSONA="+id;


        Connection con = AdministradorDeConexiones.getConnection();

        EstudiantesDAO estudianteFromDb = null;


        try {
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);


            if(rs.next()) {
                int id_persona = rs.getInt(1);
                String Nombre = rs.getString(2);
                String Apellido=rs.getString(3);
                int edad=rs.getInt(4);


                usuariosFromDb = new EstudiantesDAO(id_persona,Nombre,Apellido,edad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuariosFromDb;
    }



    public List<Estudiante> listarEstudiante() {
        String sql = "SELECT * FROM Estudiante ";


        Connection con = AdministradorDeConexiones.getConnection();

        List<Estudiante> list = new ArrayList<>();


        try {
            Statement st = con.createStatement();


            ResultSet rs = st.executeQuery(sql);



            while(rs.next()) {//

                int id_persona = rs.getInt(1);
                String Nombre = rs.getString(2);
                String Apellido= rs.getString(3);
                int edad=rs.getInt(4);


                EstudiantesDAO usuariosFromDb = new producto(id_persona,Nombre,Apellido,edad);


                list.add(usuariosFromDb);
            }


            con.close();
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return list;
    }


    public void crearusuarios(int id_persona, String Nombre, String Apellido, int edad) {

        Connection con = AdministradorDeConexiones.getConnection();

        if(con != null) {
            String sql = "INSERT INTO usuarios (id_persona, Nombre,Apellido,edad) ";
            sql += "VALUES(+id_persona+", +Nombre",'"+Apellido+"','"+edad+"')";


            try {
                Statement st = con.createStatement();
                st.execute(sql);


                con.close();

            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
