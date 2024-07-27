package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class CategoriaDAO {
    PreparedStatement ps;
    ResultSet rs;
    Conexion c = new Conexion();
    Connection con;

    public List<Categoria> mostrar() {
        List<Categoria> mostrar = new ArrayList<>();
        String sql = "SELECT * FROM FIDE_CATEGORIAS_TB";
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Categoria cat = new Categoria();
                cat.setIdCategoria(rs.getInt("ID_CATEGORIA"));
                cat.setNombreCategoria(rs.getString("NOMBRE_CATEGORIA"));
                cat.setDescripcionCategoria(rs.getString("DESCRIPCION_CATEGORIA"));
                cat.setImagen(rs.getString("IMAGEN"));
                mostrar.add(cat);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            c.desconectar();
        }
        return mostrar;
    }
}