package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.TipoDocumento;
import util.ConnectionUtil;


public class TipoDocumentoDao {
    
     private static final String GET_TIPOS_DOCUMENTOS = "select * from estados_civiles";
    
    public List<TipoDocumento> ObtenerTipoDocumento() throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<TipoDocumento> tiposDocumentos = new ArrayList<>();
        
        try {

            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_TIPOS_DOCUMENTOS
            
            );
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                TipoDocumento tipoDocumento = new TipoDocumento(0);
                tipoDocumento.setTipoDocumentoId(resultSet.getInt("tipo_doc_id"));
                tipoDocumento.setNombre(resultSet.getString("nombre"));
                tiposDocumentos.add(tipoDocumento);
            }
            return tiposDocumentos;

        } finally {
            
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
    
}
