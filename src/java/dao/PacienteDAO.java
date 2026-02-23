/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Exame;
import model.Paciente;

/**
 *
 * @author Gibson
 */
public class PacienteDAO {

    public List<Paciente> findAll() throws SQLException {
        ConnectionDAO connectionDAO = new ConnectionDAO();

        Connection connection = connectionDAO.connect();
        
        Statement statement = connection.createStatement();

        String query = "SELECT * FROM paciente p INNER JOIN exame e on p.id = e.paciente_id";

        ResultSet result = statement.executeQuery(query);
                
        List<Paciente> pacientes = new ArrayList<>();

        while (result.next()) {
            Exame exame;
            exame = new Exame(
                    result.getLong("id"),
                    result.getLong("paciente_id"),
                    result.getString("num_acesso"),
                    result.getString("visita"),
                    result.getDate("data_exame"),
                    result.getString("modalidade"),
                    result.getString("tipo_exame"),
                    result.getString("numero"),
                    result.getString("estado"),
                    result.getString("medico_solicitante"),
                    result.getString("laudo"),
                    result.getString("especial"),
                    result.getString("urgente"),
                    result.getString("restaurado")
            );
                  
            Paciente pacienteComExame = new Paciente(result.getLong("id"), result.getString("nome"), result.getString("sexo"), exame);

            pacientes.add(pacienteComExame);
        }

        return pacientes;
    }
}
