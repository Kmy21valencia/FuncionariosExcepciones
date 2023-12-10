package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.EstadoCivil;
import modelo.Funcionario;
import modelo.TipoDocumento;
import util.ConnectionUtil;

public class FuncionarioDao {

    public static final String GET_FUNCIONARIOS = "select * from funcionarios";
    
    private static final String CREATE_FUNCIONARIO = "INSERT INTO funcionarios"
            + "(numero_id,nombes,apellidos,sexo,direccion,telefono,fecha_nacimiento,"
            + "estado_civil_id,tipo_doc_id) "
            + "values(?,?,?,?,?,?,?,?,?)"; 
            
    private static final String GET_FUNCIONARIO_BY_ID = "select * from funcionarios "
            + "where numero_id = ?";
    
    private static final String UPDATE_FUNCIONARIO = "UPDATE funcionarios SET nombres=?,"
            + "apellidos=?,sexo=?,dreccion=?,telefono=?,fecha_nacimiento=?,estado_civil_id=?,"
            + "tipo_doc_id=? where numero_id=?";
    
    private static final String DELETE_FUNCIONARIO = "delete from funcionarios "
            + "where numero_id = ?";
  
    
    public List<Funcionario> obtenerFuncionarios() throws SQLException {
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Funcionario> funcionarios = new ArrayList<>();
        
        try{
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_FUNCIONARIOS);
            resultSet = preparedStatement.executeQuery();
            
            while ( resultSet.next()){
                Funcionario funcionario = new Funcionario();
                funcionario.setFuncionarioId(resultSet.getInt("funcionario_id"));
                funcionario.setNumeroDocumento(resultSet.getString("numero_id"));
                funcionario.setNombre(resultSet.getString("nombres"));
                funcionario.setApellido(resultSet.getString("apellidos"));
                funcionario.setSexo(resultSet.getString("sexo"));
                funcionario.setDireccion(resultSet.getString("direccion"));
                funcionario.setTelefono(resultSet.getString("telefono"));
                funcionario.setFechaNacimiento(resultSet.getDate("fecha_nacimiento"));
                funcionario.setTipoDocumento(new TipoDocumento(resultSet.getInt("tipo_doc_id")));
                funcionario.setEstadoCivil(new EstadoCivil(resultSet.getInt("estado_civil")));
                funcionarios.add(funcionario);
            }
            return funcionarios;
            
        }finally {
            
            if (connection != null){
                connection.close();
            }
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(resultSet != null){
                resultSet.close();
            }
        
        
    }
    }
    
    public void CrearFuncionario(Funcionario funcionario) throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try{
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareCall(GET_FUNCIONARIOS);
            preparedStatement.setString(1, funcionario.getNumeroDocumento());
            preparedStatement.setString(2, funcionario.getNombre());
            preparedStatement.setString(3, funcionario.getApellido());
            preparedStatement.setString(4, funcionario.getSexo());
            preparedStatement.setString(5, funcionario.getDireccion());
            preparedStatement.setString(6, funcionario.getTelefono());
            preparedStatement.setString(7, funcionario.getFechaNacimiento().toString());          
            preparedStatement.setLong(8, funcionario.getTipoDocumento().getTipoDocumentoId());
             preparedStatement.setLong(9, funcionario.getEstadoCivil().getEstadoCivilId());
             preparedStatement.executeUpdate();
        }finally{
            
            
            if (connection != null){
                connection.close();
            }
            if(preparedStatement != null){
                preparedStatement.close();
            }
           
        }  
        
    }
    
    public Funcionario obtenerFuncionario(String numeroDocumento) throws SQLException{
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Funcionario funcionario = null;
        
        try{
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_FUNCIONARIOS);
            preparedStatement.setString(1, numeroDocumento);
            resultSet = preparedStatement.executeQuery();
            
            
            if ( resultSet.next()){
                funcionario = new Funcionario();
                funcionario.setFuncionarioId(resultSet.getInt("funcionario_id"));
                funcionario.setNumeroDocumento(resultSet.getString("numero_id"));
                funcionario.setNombre(resultSet.getString("nombres"));
                funcionario.setApellido(resultSet.getString("apellidos"));
                funcionario.setSexo(resultSet.getString("sexo"));
                funcionario.setDireccion(resultSet.getString("direccion"));
                funcionario.setTelefono(resultSet.getString("telefono"));
                funcionario.setFechaNacimiento(resultSet.getDate("fecha_nacimiento"));
                funcionario.setTipoDocumento(new TipoDocumento(resultSet.getInt("tipo_doc_id")));
                funcionario.setEstadoCivil(new EstadoCivil(resultSet.getInt("estado_civil")));
                
            }
            return funcionario;
            
        }finally {
            
            if (connection != null){
                connection.close();
            }
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(resultSet != null){
                resultSet.close();
            }
        
        
    }
        
    }
    
    public void actualizarFuncionario (Funcionario funcionario)throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try{
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareCall(UPDATE_FUNCIONARIO);
            preparedStatement.setString(1, funcionario.getNumeroDocumento());
            preparedStatement.setString(2, funcionario.getNombre());
            preparedStatement.setString(3, funcionario.getApellido());
            preparedStatement.setString(4, funcionario.getSexo());
            preparedStatement.setString(5, funcionario.getDireccion());
            preparedStatement.setString(6, funcionario.getTelefono());
            preparedStatement.setString(7, funcionario.getFechaNacimiento().toString());          
            preparedStatement.setLong(8, funcionario.getTipoDocumento().getTipoDocumentoId());
            preparedStatement.setLong(9, funcionario.getEstadoCivil().getEstadoCivilId());
            
            preparedStatement.executeUpdate();
        }finally{
            
            
            if (connection != null){
                connection.close();
            }
            if(preparedStatement != null){
                preparedStatement.close();
            }
           
        }  
    }
    
    public void eliminarFuncionario (String numeroDocumento) throws SQLException{
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try{
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareCall(DELETE_FUNCIONARIO);
            preparedStatement.setString(0, numeroDocumento);
            preparedStatement.executeUpdate();
        }finally{
            
             if (connection != null){
                connection.close();
            }
            if(preparedStatement != null){
                preparedStatement.close();
            }
        }
        
    }

    public void crearFuncionario (Funcionario funcionario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void actualizarFuncionario(String numeroDocumento, Funcionario funcionario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
