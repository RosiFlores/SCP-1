package javaSCP;

import dao.BolsistaDAO;
import dao.CursoDAO;
import dao.ProjetoDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Angelo
 */
public class Bolsista extends Pessoa {

    private int matricula;
    private String nomeBanco;
    private int agencia;
    private int contaCorrente;
    private Pessoa pessoa;
    private int codigoPessoa;
    private Curso curso;
    private int codigoCurso;
    private Projeto projeto;
    private int codigoProjeto;

    public Bolsista(int matricula, int contaCorrente, String nomeBanco, int agencia, int codigo, String nome, String dataNascimento, String estadoCivil, String nacionalidade, String ufNascimento, String nomeMae, String nomePai, String naturalidade, String grupoSanguineo, String fatorRH, String sexo, String necessidadeEspecial, String cor, String escolaridade, String rua, int numero, String complemento, String bairro, String cidade, int cep, String uf, String pais, String email, int rg, String orgaoExpedidor, int tituloEleitor, int numeroComprovanteMilitar, int cpf, int pisPasep, String dataExpedicaoRG, int chaveCampus, Pessoa pessoa, Curso curso, Projeto projeto) {
        super(codigo, nome, dataNascimento, estadoCivil, nacionalidade, ufNascimento, nomeMae, nomePai, naturalidade, grupoSanguineo, fatorRH, sexo, necessidadeEspecial, cor, escolaridade, rua, numero, complemento, bairro, cidade, cep, uf, pais, email, rg, orgaoExpedidor, tituloEleitor, numeroComprovanteMilitar, cpf, pisPasep, dataExpedicaoRG,chaveCampus);
        this.matricula = matricula;
        this.nomeBanco = nomeBanco;
        this.agencia = agencia;
        this.contaCorrente = contaCorrente;
        this.pessoa = pessoa;
        this.curso = curso;
        this.projeto = projeto;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNomeBanco() {
        return nomeBanco;
    }

    public void setNomeBanco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(int contaCorrente) {
        this.contaCorrente = contaCorrente;
    }

    public int getCodigoPessoa() {
        return codigoPessoa;
    }

    public void setCodigoPessoa(int codigoPessoa) {
        this.codigoPessoa = codigoPessoa;
    }

    public int getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(int codigo) {
        this.codigoCurso = codigo;
    }

    public Curso getCurso() throws ClassNotFoundException, SQLException {
        if ((curso == null) && (codigoCurso != 0)) {
            curso = CursoDAO.obterCurso(codigoCurso);
        }
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Projeto getProjeto() throws ClassNotFoundException, SQLException {
        if ((projeto == null) && (codigoProjeto != 0)) {
            projeto = ProjetoDAO.obterProjeto(codigoProjeto);

        }
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public int getCodigoProjeto() {
        return codigoProjeto;
    }

    public void setCodigoProjeto(int codigoProjeto) {
        this.codigoProjeto = codigoProjeto;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    

    public static List<Bolsista> obterBolsistas()
            throws ClassNotFoundException, SQLException {
        return BolsistaDAO.obterBolsistas();

    }

    public static Bolsista obterBolsista(int codigoBolsista) throws ClassNotFoundException,
            SQLException {
        return BolsistaDAO.obterBolsista(codigoBolsista);
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        BolsistaDAO.gravar(this);
    }
    public void editar() throws SQLException, ClassNotFoundException{
      BolsistaDAO.editar(this);
    }
    public void excluir() throws SQLException, ClassNotFoundException{
     BolsistaDAO.excluir(this);
    }
}
