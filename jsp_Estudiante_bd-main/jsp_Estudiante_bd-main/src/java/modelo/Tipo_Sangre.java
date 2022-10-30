
package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;


public class Tipo_Sangre {  
        private int id_tipo_sangre;
    private String sangre;
    Conexion cn;
    public Tipo_Sangre(){}

    public int getId_tipo_sangre() {
        return id_tipo_sangre;
    }

    public void setId_tipo_sangre(int id_tipo_sangre) {
        this.id_tipo_sangre = id_tipo_sangre;
    }

    public String getTipo_sangre() {
        return sangre;
    }

    public void setTipo_sangre(String tipo_sangre) {
        this.sangre = tipo_sangre;
    }
    public Tipo_Sangre(int id_tipo_sangre, String tipo_sangre) {
        this.id_tipo_sangre = id_tipo_sangre;
        this.sangre = tipo_sangre;
    }

  
    public HashMap drop_sangre(){
    HashMap<String,String> drop = new HashMap();
    try{
        String query ="Select id_tipo_sangre as id,tipo_sangre from sangre";
         cn = new Conexion();
         cn.abrir_conexion();
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            while (consulta.next()){
            drop.put(consulta.getString("id"),consulta.getString("sangre") );
            }
         cn.cerrar_conexion();
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    return drop;
    }
    
}

}
