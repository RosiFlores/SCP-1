/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaSCP;

import dao.FuncionarioDAO;
import dao.InstituicaoDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Angelo
 */
public class Funcionario extends Pessoa {
   
    private int matricula;
    private Pessoa pessoa;
    private int chavePessoa;
    private Instituicao instituicao;
    private int chaveInstituicao;
    
   
    public Funcionario(int matricula, int codigoPessoa, String nomePessoa,String dataNascimento, String estadoCivil, String nacionalidade, String ufNascimento, String nomeMae, String nomePai, String naturalidade, String grupoSanguineo, String fatorRH, String sexo, String necessidadeEspecial, String cor, String escolaridade, String rua, int numero, String complemento, String bairro, String cidade, int cep, String uf, String pais, String email, int rg, String orgaoExpedidor, int tituloEleitor, int numeroComprovanteMilitar, int cpf, int pisPasep, String dataExpedicaoRG,int chaveCampus, Pessoa pessoa, Instituicao instituicao) {
        super(codigoPessoa, nomePessoa, dataNascimento, estadoCivil, nacionalidade, ufNascimento, nomeMae, nomePai, naturalidade, grupoSanguineo, fatorRH, sexo, necessidadeEspecial, cor, escolaridade, rua, numero, complemento, bairro, cidade, cep, uf, pais,email, rg, orgaoExpedidor, tituloEleitor, numeroComprovanteMilitar, cpf, pisPasep, dataExpedicaoRG,chaveCampus);
        this.matricula = matricula;
        this.pessoa = pessoa;
        this.instituicao= instituicao;
    }
    

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getChavePessoa() {
        return chavePessoa;
    }

    public void setChavePessoa(int chavePessoa) {
        this.chavePessoa = chavePessoa;
    }

    public Pessoa getPessoa(){
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    public int getChaveInstituicao() {
        return chaveInstituicao;
    }

    public void setChaveInstituicao(int chaveInstituicao) {
        this.chaveInstituicao = chaveInstituicao;
    }
    

    public Instituicao getInstituicao()  throws ClassNotFoundException, SQLException {
         if (instituicao == null && chaveInstituicao!=0) {
             instituicao= InstituicaoDAO.obterInstituicao(chaveInstituicao);
        }
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    
    }
    
     public void gravar() throws SQLException, ClassNotFoundException {
                FuncionarioDAO.gravar(this);
    }
public void editar() throws SQLException, ClassNotFoundException{
  FuncionarioDAO.editar(this);
}
public void excluir() throws SQLException, ClassNotFoundException{
      FuncionarioDAO.excluir(this);
}    

    
    public static List<Funcionario> obterFuncionarios()
            throws ClassNotFoundException, SQLException {
        return FuncionarioDAO.obterFuncionarios();
    }
     public static Funcionario obterFuncionario(int codigoFuncionario) throws ClassNotFoundException, 
            SQLException {
         return FuncionarioDAO.obterFuncionario(codigoFuncionario);
     }
}
