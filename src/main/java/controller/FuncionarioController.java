package controller;

import dao.FuncionarioDao;
import java.sql.SQLException;
import java.util.List;
import modelo.Funcionario;

public class FuncionarioController {
    
    private FuncionarioDao funcionarioDao;
    
    public FuncionarioController(){
        funcionarioDao = new FuncionarioDao();
    }
    
    public List<Funcionario> obtenerFuncionarios() throws SQLException {
        return funcionarioDao.obtenerFuncionarios();
    }
     public void crearFuncionario(Funcionario funcionario) throws SQLException {
        funcionarioDao.crearFuncionario(funcionario);
    }
    
    public Funcionario obtenerFuncionario(String numeroDocumento) throws SQLException {
        return funcionarioDao.obtenerFuncionario(numeroDocumento);
    }
    
    public void actualizarFuncionario(String numeroDocumento, Funcionario funcionario) throws SQLException {
        funcionarioDao.actualizarFuncionario(numeroDocumento, funcionario);
    }
    
    public void eliminarFuncionario(String numeroDocumento) throws SQLException {
        funcionarioDao.eliminarFuncionario(numeroDocumento);
    }
}
