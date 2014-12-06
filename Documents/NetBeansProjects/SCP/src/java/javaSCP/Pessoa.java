/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaSCP;

import dao.CampusDAO;
import java.sql.SQLException;


/**
 *
 * @author Angelo
 */
public class Pessoa {
    private int codigo;
    private String nome;
    private String dataNascimento;
    private String estadoCivil;
    private String nacionalidade;
    private String ufNascimento;
    private String nomeMae;
    private String nomePai;
    private String naturalidade;
    private String grupoSanguineo;
    private String fatorRH;
    private String sexo;
    private String necessidadeEspecial;
    private String cor;
    private String escolaridade;
    private String rua;
    private int numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private int cep;
    private String uf;
    private String pais;
    private String email;
    private int rg;
    private String orgaoExpedidor;
    private int tituloEleitor;
    private int numeroComprovanteMilitar;
    private int cpf;
    private int pisPasep;
    private String dataExpedicaoRG;
    private Campus campus;
    private int chaveCampus;

    public Pessoa(int codigo, String nome, String dataNascimento, String estadoCivil, String nacionalidade, String ufNascimento, String nomeMae, String nomePai, String naturalidade, String grupoSanguineo, String fatorRH, String sexo, String necessidadeEspecial, String cor, String escolaridade, String rua, int numero, String complemento, String bairro, String cidade, int cep, String uf, String pais, String email, int rg, String orgaoExpedidor, int tituloEleitor, int numeroComprovanteMilitar, int cpf, int pisPasep, String dataExpedicaoRG,int chaveCampus) {
        this.codigo = codigo;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.estadoCivil = estadoCivil;
        this.nacionalidade = nacionalidade;
        this.ufNascimento = ufNascimento;
        this.nomeMae = nomeMae;
        this.nomePai = nomePai;
        this.naturalidade = naturalidade;
        this.grupoSanguineo = grupoSanguineo;
        this.fatorRH = fatorRH;
        this.sexo = sexo;
        this.necessidadeEspecial = necessidadeEspecial;
        this.cor = cor;
        this.escolaridade = escolaridade;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.uf = uf;
        this.pais = pais;
        this.email = email;
        this.rg = rg;
        this.orgaoExpedidor = orgaoExpedidor;
        this.tituloEleitor = tituloEleitor;
        this.numeroComprovanteMilitar = numeroComprovanteMilitar;
        this.cpf = cpf;
        this.pisPasep = pisPasep;
        this.dataExpedicaoRG = dataExpedicaoRG;
        this.chaveCampus = chaveCampus;
    }
    

    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getUfNascimento() {
        return ufNascimento;
    }

    public void setUfNascimento(String ufNascimento) {
        this.ufNascimento = ufNascimento;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    public String getFatorRH() {
        return fatorRH;
    }

    public void setFatorRH(String fatorRH) {
        this.fatorRH = fatorRH;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNecessidadeEspecial() {
        return necessidadeEspecial;
    }

    public void setNecessidadeEspecial(String necessidadeEspecial) {
        this.necessidadeEspecial = necessidadeEspecial;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public String getOrgaoExpedidor() {
        return orgaoExpedidor;
    }

    public void setOrgaoExpedidor(String orgaoExpedidor) {
        this.orgaoExpedidor = orgaoExpedidor;
    }

    public int getTituloEleitor() {
        return tituloEleitor;
    }

    public void setTituloEleitor(int tituloEleitor) {
        this.tituloEleitor = tituloEleitor;
    }

    public int getNumeroComprovanteMilitar() {
        return numeroComprovanteMilitar;
    }

    public void setNumeroComprovanteMilitar(int numeroComprovanteMilitar) {
        this.numeroComprovanteMilitar = numeroComprovanteMilitar;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getPisPasep() {
        return pisPasep;
    }

    public void setPisPasep(int pisPasep) {
        this.pisPasep = pisPasep;
    }

    public String getDataExpedicaoRG() {
        return dataExpedicaoRG;
    }

    public void setDataExpedicaoRG(String dataExpedicaoRG) {
        this.dataExpedicaoRG = dataExpedicaoRG;
    }

    public int getChaveCampus() {
        return chaveCampus;
    }

    public void setChaveCampus(int chaveCampus) {
        this.chaveCampus = chaveCampus;
    }

    public Campus getCampus()  throws ClassNotFoundException, SQLException {
         if (campus == null && chaveCampus!=0) {
             campus= CampusDAO.obterCampus(chaveCampus);
        }
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    
}

