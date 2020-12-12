package Controller;

import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import java.awt.Font;

public class MainController {
    public static final String url = "jdbc:mysql://localhost:3306/traumatologiaDrGalarza?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static final String username = "root";
    public static final String pass = "";
    public static Connection con = null;
    PreparedStatement ps =null;
    Statement instruccion=null;
    Statement instruccion2=null;
    Boolean consulta = false;
    int columnas;
    int columnas2;
    int columnas3;
    int columnas4;
    int columnas5;
    int columnas6;
    int columnas7;
    int columnas8;
    
    ArrayList nombreCampos = null;
    ArrayList listaNombres = null;
    String mesConvertido = null;
    String stockOut = null;
    String cedula;
    Map<String, String> mapa = new HashMap<>();
    String fechaIngreso = null;
    String error = null;
    String anterior=null;
    //FUENTE
    public Font fuente;

    public int getColumnas7() {
        return columnas7;
    }

    public void setColumnas7(int columnas7) {
        this.columnas7 = columnas7;
    }

    public int getColumnas8() {
        return columnas8;
    }

    public void setColumnas8(int columnas8) {
        this.columnas8 = columnas8;
    }

    public int getColumnas6() {
        return columnas6;
    }

    public void setColumnas6(int columnas6) {
        this.columnas6 = columnas6;
    }

    public int getColumnas5() {
        return columnas5;
    }

    public void setColumnas5(int columnas5) {
        this.columnas5 = columnas5;
    }

    public int getColumnas4() {
        return columnas4;
    }

    public void setColumnas4(int columnas4) {
        this.columnas4 = columnas4;
    }

    public int getColumnas3() {
        return columnas3;
    }

    public void setColumnas3(int columnas3) {
        this.columnas3 = columnas3;
    }

    public int getColumnas2() {
        return columnas2;
    }

    public void setColumnas2(int columnas2) {
        this.columnas2 = columnas2;
    }
    
    public static Connection getCon() {
        return con;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public static void setCon(Connection con) {
        MainController.con = con;
    }

    public PreparedStatement getPs() {
        return ps;
    }

    public void setPs(PreparedStatement ps) {
        this.ps = ps;
    }

    public Statement getInstruccion() {
        return instruccion;
    }

    public void setInstruccion(Statement instruccion) {
        this.instruccion = instruccion;
    }

    public Boolean getConsulta() {
        return consulta;
    }

    public void setConsulta(Boolean consulta) {
        this.consulta = consulta;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public ArrayList getNombreCampos() {
        return nombreCampos;
    }

    public void setNombreCampos(ArrayList nombreCampos) {
        this.nombreCampos = nombreCampos;
    }

    public ArrayList getListaNombres() {
        return listaNombres;
    }

    public void setListaNombres(ArrayList listaNombres) {
        this.listaNombres = listaNombres;
    }

    public String getMesConvertido() {
        return mesConvertido;
    }

    public void setMesConvertido(String mesConvertido) {
        this.mesConvertido = mesConvertido;
    }

    public String getStockOut() {
        return stockOut;
    }

    public void setStockOut(String stockOut) {
        this.stockOut = stockOut;
    }

    public Map<String, String> getMapa() {
        return mapa;
    }

    public void setMapa(Map<String, String> mapa) {
        this.mapa = mapa;
    }

  public Connection conexion()
    {
       try
       {
        con = getConection();   
       }
       catch(Exception e)
       {
           System.out.println(e);
       }
       return con;
    }
   
         public static Connection getConection()
    {
        
        try
        {
             Class.forName("com.mysql.cj.jdbc.Driver");
             con =(Connection) DriverManager.getConnection(url, username, pass);
        }
        catch(ClassNotFoundException | SQLException E)
        {
            System.out.println(E);
        }
        return con;
    }
         //INSERCIÓN DE DATOS
         
         public void insertarPaciente(String ced, String apeNom, String sex, String res, String estCiv, String ocu,String edad, String fec, String tel)
         {
             conexion();
             try
             {
                ps=con.prepareStatement("INSERT INTO paciente(cedula, nombre_paciente,sexo,reside,estado_civil,ocupacion,edad,fecha,telefono) VALUES (?,?,?,?,?,?,?,?,?)");
                ps.setString(1, ced);
                ps.setString(2, apeNom);
                ps.setString(3, sex);
                ps.setString(4, res);
                ps.setString(5, estCiv);
                ps.setString(6, ocu);
                ps.setString(7, edad);
                ps.setString(8, fec);
                ps.setString(9,tel);
                ps.executeUpdate();
             }
             catch(SQLException e)
             {
                 throw new RuntimeException(e);
             }
         }
         
         public void insertarConsulta(String motCon, String exaFis, String exa, String traInd, String diag, String diaRep,String diaRepTex, String ced, String proximaConsulta,String cie10)
         {
             conexion();
             try
             {
                ps=con.prepareStatement("INSERT INTO consulta(mot_consulta, exa_fisico, examenes, tra_ind, diagnostico, dias_reposo,dias_reposo_texto, cedula_paciente, proxima_consulta,cie10) VALUES (?,?,?,?,?,?,?,?,?,?)");
                ps.setString(1, motCon);
                ps.setString(2, exaFis);
                ps.setString(3, exa);
                ps.setString(4, traInd);
                ps.setString(5, diag);
                ps.setString(6, diaRep);
                ps.setString(7, diaRepTex);
                ps.setString(8, ced);
                ps.setString(9, proximaConsulta);
                ps.setString(10, cie10);
                ps.executeUpdate();
                instruccion2 = con.createStatement();
             }
             catch(SQLException e)
             {
                 throw new RuntimeException(e);
             }
         }
         
         
         
         public void insertarCertificadoMedico(String his, String fecIng, String ultVis, String ant, String cedula, String nombre, String cie10)
         {
             fechaIngreso = fecIng;
             conexion();
             try
             {
                ps=con.prepareStatement("INSERT INTO historia_clinica(id_his_cli,fecha_ingreso,ultima_visita,antecedentes,cedula,apellidos_nombres) VALUES (?,?,?,?,?,?)");
                ps.setString(1, his);
                ps.setString(2, fecIng);
                ps.setString(3, null);
                ps.setString(4, ant);
                ps.setString(5, cedula);
                ps.setString(6, nombre);
                ps.executeUpdate();
                
             }
             catch(SQLException e)
             {
                 Component cmpnt = null;
                 JOptionPane.showMessageDialog(cmpnt, "Error: Ya existe esa historia clínica");
                 throw new RuntimeException(e);
             }
         }
     
         
         //CONSULTAS
         //LOGIN CONSULTA
       
        public ArrayList consultaProximaVisita(String nombres_apellidos)
        {
             conexion();
             ArrayList lista = new ArrayList<>();
             try
             {
                instruccion = con.createStatement();
                ResultSet resultado = instruccion.executeQuery("select rx_ref_dis_od_esf, rx_ref_dis_od_cil, rx_ref_dis_od_eje,rx_ref_dis_od_dnp from consulta where apellidos_nombres LIKE '%"+nombres_apellidos+"%'");
                columnas = resultado.getMetaData().getColumnCount();
                       while(resultado.next())
                       {
                           lista.add("DISTANCIA");
                           lista.add("OD");
                           for(int i=1; i<=columnas ; i++)
                           {
                               lista.add(resultado.getString(i));
                           }
                       }
             }
             catch(SQLException e)
             {
                 throw new RuntimeException(e);
             }
             return lista;
        }
        public ArrayList consultaDatosPaciente(String nombres_apellidos)
        {
             conexion();
             ArrayList lista = new ArrayList<>();
             try
             {
                instruccion = con.createStatement();
                ResultSet resultado = instruccion.executeQuery("select nombre_paciente, telefono, edad, cedula from paciente where nombre_paciente LIKE '%"+nombres_apellidos+"%'");
                columnas2 = resultado.getMetaData().getColumnCount();
                       while(resultado.next())
                       {
                           for(int i=1; i<=columnas2 ; i++)
                           {
                               lista.add(resultado.getString(i));
                           }
                       }
             }
             catch(SQLException e)
             {
                 throw new RuntimeException(e);
             }
             return lista;
         
        }
        public ArrayList consultaHistorialMedicoAdd(String nombres_apellidos)
        {
             conexion();
             ArrayList lista = new ArrayList<>();
             try
             {
                instruccion = con.createStatement();
                ResultSet resultado = instruccion.executeQuery("select rx_ref_add_od_esf, rx_ref_add_od_cil, rx_ref_add_od_eje,altura from consulta where apellidos_nombres LIKE '%"+nombres_apellidos+"%'");
                columnas3 = resultado.getMetaData().getColumnCount();
                       while(resultado.next())
                       {
                           lista.add("ADD");
                           lista.add("OD");
                           for(int i=1; i<=columnas3 ; i++)
                           {
                               lista.add(resultado.getString(i));
                           }
                       }
             }
             catch(SQLException e)
             {
                 throw new RuntimeException(e);
             }
             return lista;
        }
        public ArrayList consultaHistorialMedicoAddOi(String nombres_apellidos)
        {
             conexion();
             ArrayList lista = new ArrayList<>();
             try
             {
                instruccion = con.createStatement();
                ResultSet resultado = instruccion.executeQuery("select rx_ref_add_oi_esf, rx_ref_add_oi_cil, rx_ref_add_oi_eje from consulta where apellidos_nombres LIKE '%"+nombres_apellidos+"%';");
                columnas4 = resultado.getMetaData().getColumnCount();
                       while(resultado.next())
                       {
                           lista.add("");
                           lista.add("OI");
                           for(int i=1; i<=columnas4 ; i++)
                           {
                               lista.add(resultado.getString(i));
                           }
                           lista.add("ALTURA");
                       }
             }
             catch(SQLException e)
             {
                 throw new RuntimeException(e);
             }
             return lista;
        }
        public ArrayList consultaHistorialMedicoLectura(String nombres_apellidos)
        {
             conexion();
             ArrayList lista = new ArrayList<>();
             try
             {
                instruccion = con.createStatement();
                ResultSet resultado = instruccion.executeQuery("select rx_ref_lec_od_esf, rx_ref_lec_od_cil, rx_ref_lec_od_eje from consulta where apellidos_nombres LIKE '%"+nombres_apellidos+"%';");
                columnas5 = resultado.getMetaData().getColumnCount();
                       while(resultado.next())
                       {
                           lista.add("LECTURA");
                           lista.add("OD");
                           for(int i=1; i<=this.columnas5 ; i++)
                           {
                               lista.add(resultado.getString(i));
                               System.out.println(resultado.getString(i));
                           }
                       }
             }
             catch(SQLException e)
             {
                 throw new RuntimeException(e);
             }
             return lista;
        }
         public ArrayList consultaHistorialMedicoLecturaOi(String nombres_apellidos)
        {
             conexion();
             ArrayList lista = new ArrayList<>();
             try
             {
                instruccion = con.createStatement();
                ResultSet resultado = instruccion.executeQuery("select rx_ref_lec_oi_esf, rx_ref_lec_oi_cil, rx_ref_lec_oi_eje from consulta where apellidos_nombres LIKE '%"+nombres_apellidos+"%';");
                columnas6 = resultado.getMetaData().getColumnCount();
                       while(resultado.next())
                       {
                           lista.add("");
                           lista.add("OI");
                           for(int i=1; i<=columnas6 ; i++)
                           {
                               lista.add(resultado.getString(i));
                               System.out.println(resultado.getString(i));
                           }
                       }
             }
             catch(SQLException e)
             {
                 throw new RuntimeException(e);
             }
             return lista;
        }
        public ArrayList consultaHistorialMedicoAguOd(String nombres_apellidos)
        {
             conexion();
             ArrayList lista = new ArrayList<>();
             try
             {
                instruccion = con.createStatement();
                ResultSet resultado = instruccion.executeQuery("select agu_dc_od, agu_cc_od from consulta where apellidos_nombres LIKE '%"+nombres_apellidos+"%';");
                columnas7 = resultado.getMetaData().getColumnCount();
                       while(resultado.next())
                       {
                           lista.add("AGUDEZA");
                           lista.add("OD");
                           for(int i=1; i<=columnas7 ; i++)
                           {
                               lista.add(resultado.getString(i));
                               System.out.println(resultado.getString(i));
                           }
                       }
             }
             catch(SQLException e)
             {
                 throw new RuntimeException(e);
             }
             return lista;
        }
        public ArrayList consultaHistorialMedicoAguOi(String nombres_apellidos)
        {
             conexion();
             ArrayList lista = new ArrayList<>();
             try
             {
                instruccion = con.createStatement();
                ResultSet resultado = instruccion.executeQuery("select agu_dc_oi, agu_cc_oi from consulta where apellidos_nombres LIKE '%"+nombres_apellidos+"%';");
                columnas8 = resultado.getMetaData().getColumnCount();
                       while(resultado.next())
                       {
                           lista.add("VISUAL");
                           lista.add("OI");
                           for(int i=1; i<=columnas8 ; i++)
                           {
                               lista.add(resultado.getString(i));
                               System.out.println(resultado.getString(i));
                           }
                       }
             }
             catch(SQLException e)
             {
                 throw new RuntimeException(e);
             }
             return lista;
        }
        public ArrayList consultaTodo(String apeNom)
        {
            ArrayList lista = new ArrayList<>();
            nombreCampos = new ArrayList<>();
             conexion();
             try
             {
                instruccion = con.createStatement();
                ResultSet resColumnas = instruccion.executeQuery("select historia,altura,fecha,rx_ref_dis_od_esf ,rx_ref_dis_od_cil ,rx_ref_dis_od_eje ,rx_ref_dis_od_dnp ,rx_ref_dis_oi_esf ,rx_ref_dis_oi_cil, rx_ref_dis_oi_eje ,rx_ref_dis_oi_dnp ,rx_ref_add_od_esf ,rx_ref_add_od_cil ,rx_ref_add_od_eje ,rx_ref_add_oi_esf ,rx_ref_add_oi_cil, rx_ref_add_oi_eje ,rx_ref_lec_od_esf, rx_ref_lec_od_cil ,rx_ref_lec_od_eje ,rx_ref_lec_oi_esf ,rx_ref_lec_oi_cil ,rx_ref_lec_oi_eje ,esq_av_od_sc ,esq_av_od_cc ,esq_av_od_esf ,esq_av_od_cil ,esq_av_od_eje ,esq_av_oi_eje ,esq_av_oi_cil ,esq_av_oi_esf ,esq_av_oi_cc ,esq_av_oi_sc ,agu_dc_od,agu_cc_od,agu_dc_oi,agu_cc_oi ,material ,armazon ,observacion ,atendido ,causa,apellidos_nombres from consulta  where apellidos_nombres LIKE '%"+apeNom+"%'");
                columnas = resColumnas.getMetaData().getColumnCount();
                 while(resColumnas.next())
                            {
                                for(int i=1; i<=columnas ; i++)
                                {
                                    //mapa.put(resColumnas.getMetaData().getColumnName(i),resColumnas.getString(i));
                                    lista.add(resColumnas.getString(i));
                                    nombreCampos.add(resColumnas.getMetaData().getColumnName(i));
                                }
                            }
             }
             catch(SQLException e)
             {
                 throw new RuntimeException(e);
             }
             return lista;
         
        }
       
         
         public ArrayList consultarPersona(String hisCli)
         {
             conexion();
             ArrayList lista = new ArrayList<>();
             try
             {
                instruccion = con.createStatement();
                ResultSet resultado = instruccion.executeQuery("SELECT DISTINCT per.cedula, per.apellidos_nombres, per.direccion, per.motivo_consulta, per.edad, per.telefono, per.estado_civil, per.sexo, per.especialidad,his.antecedentes FROM persona as per, historia_clinica as his WHERE per.id_his_cli ='"+hisCli+"' && his.id_his_cli='"+hisCli+"'");
                columnas = resultado.getMetaData().getColumnCount();
                 while(resultado.next())
                            {
                                for(int i=1; i<=columnas ; i++)
                                {
                                    //mapa.put(resColumnas.getMetaData().getColumnName(i),resColumnas.getString(i));
                                    lista.add(resultado.getString(i));
                                }
                            }
                ResultSet resultado2 = instruccion.executeQuery("SELECT MAX(fecha) FROM consulta WHERE historia='"+hisCli+"' limit 1;");
                while(resultado2.next())
                {
                    lista.add(resultado2.getString(1));
                }
                
                
             }
             catch(SQLException e)
             {
                 throw new RuntimeException(e);
                 
             }
             return lista;
         }
         
         public ArrayList consultarPersonaApeNom(String apeNom)
         {
             conexion();
             ArrayList lista = new ArrayList<>();
             try
             {
                instruccion = con.createStatement();
                ResultSet resultado = instruccion.executeQuery("SELECT DISTINCT per.cedula, per.apellidos_nombres, per.direccion, per.motivo_consulta, per.edad, per.telefono, per.estado_civil, per.sexo, per.especialidad,his.antecedentes,his.id_his_cli FROM persona as per, historia_clinica as his WHERE per.apellidos_nombres LIKE '%"+apeNom+"%' && his.apellidos_nombres LIKE '%"+apeNom+"%'");
                columnas = resultado.getMetaData().getColumnCount();
                 while(resultado.next())
                            {
                                for(int i=1; i<=columnas ; i++)
                                {
                                    //mapa.put(resColumnas.getMetaData().getColumnName(i),resColumnas.getString(i));
                                    lista.add(resultado.getString(i));
                                }
                            }
                
             }
             catch(SQLException e)
             {
                 throw new RuntimeException(e);
                 
             }
             return lista;
         }
        public ArrayList consultaTodoPersona()
        {
            ArrayList lista = new ArrayList<>();
            nombreCampos = new ArrayList<>();
             conexion();
             try
             {
                instruccion = con.createStatement();
                ResultSet resColumnas = instruccion.executeQuery("select per.id_his_cli, per.cedula, per.apellidos_nombres, per.direccion, per.motivo_consulta, per.edad, per.telefono, per.estado_civil, per.sexo, per.especialidad, his.fecha_ingreso, his.antecedentes from persona as per, historia_clinica as his where per.cedula = his.cedula order by id_his_cli;");
                columnas = resColumnas.getMetaData().getColumnCount();
                 while(resColumnas.next())
                            {
                                for(int i=1; i<=columnas ; i++)
                                {
                                    //mapa.put(resColumnas.getMetaData().getColumnName(i),resColumnas.getString(i));
                                    lista.add(resColumnas.getString(i));
                                    nombreCampos.add(resColumnas.getMetaData().getColumnName(i));
                                }
                            }
             }
             catch(SQLException e)
             {
                 throw new RuntimeException(e);
             }
             return lista;
         
        }
         public ArrayList consultaPersonaCedula(String ced)
        {
            ArrayList lista = new ArrayList<>();
            nombreCampos = new ArrayList<>();
             conexion();
             try
             {
                instruccion = con.createStatement();
                ResultSet resColumnas = instruccion.executeQuery("select per.id_his_cli, per.cedula, per.apellidos_nombres, per.direccion, per.motivo_consulta, per.edad, per.telefono, per.estado_civil, per.sexo, per.especialidad, his.fecha_ingreso, his.antecedentes from persona as per, historia_clinica as his where per.cedula ="+ced+" and  his.cedula="+ced +" order by id_his_cli;");
                columnas = resColumnas.getMetaData().getColumnCount();
                 while(resColumnas.next())
                            {
                                for(int i=1; i<=columnas ; i++)
                                {
                                    //mapa.put(resColumnas.getMetaData().getColumnName(i),resColumnas.getString(i));
                                    lista.add(resColumnas.getString(i));
                                    nombreCampos.add(resColumnas.getMetaData().getColumnName(i));
                                }
                            }
             }
             catch(SQLException e)
             {
                 throw new RuntimeException(e);
             }
             return lista;
         
        }
         public ArrayList consultarPersonaAntSig(String cedula)
        {
            ArrayList lista = new ArrayList<>();
            nombreCampos = new ArrayList<>();
             conexion();
             try
             {
                instruccion = con.createStatement();
                ResultSet resColumnas = instruccion.executeQuery("SELECT DISTINCT per.cedula, per.apellidos_nombres, per.direccion, per.motivo_consulta, per.edad, per.telefono, per.estado_civil, per.sexo, per.especialidad,his.antecedentes,his.id_his_cli,his.ultima_visita FROM persona as per, historia_clinica as his where per.cedula='"+cedula+"' and his.cedula='"+cedula+"';");
                columnas = resColumnas.getMetaData().getColumnCount();
                while(resColumnas.next())
                            {    
                                for(int i=1;i<=columnas;i++)
                                 {
                                     lista.add(resColumnas.getString(i));
                                 }
                            }
             }
             catch(SQLException e)
             {
                 System.out.println(e.getMessage());
                 System.out.println(e.getErrorCode());
                 throw new RuntimeException(e);
             }
             return lista;
         
        }
         
        public ArrayList consultarCedulaAntSig()
        {
            ArrayList lista = new ArrayList<>();
             conexion();
             try
             {
                instruccion = con.createStatement();
                ResultSet resColumnas = instruccion.executeQuery("SELECT cedula FROM historia_clinica");
                 while(resColumnas.next())
                            {
                                    lista.add(resColumnas.getString("cedula"));
                            }
             }
             catch(SQLException e)
             {
                 throw new RuntimeException(e);
             }
             return lista;
        }
         
         //ELIMINACIÓN
                //Historia
         public void eliminarHistoria(String ref, String apeNom)
         {
             conexion();
             try
             {
                ps=con.prepareStatement("DELETE FROM consulta WHERE rx_ref_dis_od_esf='"+ref+"' && apellidos_nombres LIKE '%"+apeNom+"%' ;");
                int confirm=ps.executeUpdate();
                if(confirm==1)
                {
                    Component cmpnt = null;
                    JOptionPane.showMessageDialog(cmpnt, "Consulta eliminada correctamente");
                }
                else
                {
                    Component cmpnt = null;
                    JOptionPane.showMessageDialog(cmpnt, "Por favor seleccione la fila OD y columna ESFERA de la consulta a eliminar");

                }
              }
             catch(SQLException e)
             {
                 throw new RuntimeException(e);
             }
         }
            //CLiente
         public void eliminarPersona(String hisCli)
         {
             conexion();
             try
             {
                ps=con.prepareStatement("delete from historia_clinica where id_his_cli ="+hisCli+";");
                ps.executeUpdate();
                ps=con.prepareStatement("delete from persona where id_his_cli="+hisCli+";");
                ps.executeUpdate();
                ps=con.prepareStatement("delete from consulta where historia="+hisCli+";");
                ps.executeUpdate();
                
             }
             catch(SQLException e)
             {
                 throw new RuntimeException(e);
             }
         }
           
         
         //UPDATES
         //CLIENTE
         public void editarPersona(String cedula, String nombres, String telefono, String direccion)
         {
             conexion();
             try
             {
                ps=con.prepareStatement("UPDATE persona SET nombres = '"+nombres+"', telefono= '"+"' , direccion= '"+direccion+"' WHERE cedula = '"+cedula+"';");
                ps.executeUpdate();
             }
             catch(SQLException e)
             {
                 throw new RuntimeException(e);
             }
         }
         


         
         

}
