/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gibson
 */
public class Paciente {
    
    private Long id;
    private String nome;
    private String sexo;

    public Paciente(Long id, String nome, String sexo, Exame exame) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.exames.add(exame);
    }

    public List<Exame> getExames() {
        return exames;
    }
    
    List<Exame> exames = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSexo() {
        return sexo;
    }

    @Override
    public String toString() {
        return "Paciente{" + "id=" + id + ", nome=" + nome + ", sexo=" + sexo + ", exames=" + exames.toString() + '}';
    }
    
    
}
