package javaSCP;

import dao.NucleoDAO;
import dao.OrientadorDAO;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author Mayara Amanda
 */
public class Orientador extends Pessoa {
    
    private int matricula;
    private String homepageLattes;
    private Nucleo nucleo;
    private int codigoNucleo;
    private Pessoa pessoa;
    private int chavePessoa;
           
    public Orientador( int matricula, String homepageLattes, int codigoPessoa, String nomePessoa, String dataNascimento, String estadoCivil, String nacionalidade, String ufNascimento, String nomeMae, String nomePai, String naturalidade, String grupoSanguineo, String fatorRH, String sexo, String necessidadeEspecial, String cor, String escolaridade, String rua, int numero, String complemento, String bairro, String cidade, int cep, String uf, String pais, String email, int rg, String orgaoExpedidor, int tituloEleitor, int numeroComprovanteMilitar, int cpf, int pisPasep, String dataExpedicaoRG, int chaveCampus, Nucleo nucleo,Pessoa pessoa) {
        super(codigoPessoa, nomePessoa, dataNascimento, estadoCivil, nacionalidade, ufNascimento, nomeMae, nomePai, naturalidade, grupoSanguineo, fatorRH, sexo, necessidadeEspecial, cor, escolaridade, rua, numero, complemento, bairro, cidade, cep, uf, pais, email, rg, orgaoExpedidor, tituloEleitor, numeroComprovanteMilitar, cpf, pisPasep, dataExpedicaoRG,chaveCampus);
        
        this.matricula = matricula;
        this.homepageLattes = homepageLattes;
        this.nucleo = nucleo;
        this.pessoa =  pessoa;
    }   
    
    public int getMatricula() {
        return matricula;
    }
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    public String getHomepageLattes() {
        return homepageLattes;
    }
    public void setHomepageLattes(String homepageLattes) {
        this.homepageLattes = homepageLattes;
    }
    
    public int getCodigoNucleo() {
        return codigoNucleo;
    }

    public void setCodigoNucleo(int codigoNucleo) {
        this.codigoNucleo = codigoNucleo;
    }

    public Nucleo getNucleo() throws  SQLException, ClassNotFoundException {
        if ((nucleo == null && codigoNucleo != 0 )){
             nucleo = NucleoDAO.obterNucleo(codigoNucleo);
        }
             return nucleo;
    }

    public void setNucleo(Nucleo nucleo) {
        this.nucleo = nucleo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public int getChavePessoa() {
        return chavePessoa;
    }

    public void setChavePessoa(int chavePessoa) {
        this.chavePessoa = chavePessoa;
    }
   
    public void gravar() throws SQLException, ClassNotFoundException {
                OrientadorDAO.gravar(this);
    }
public void editar() throws SQLException, ClassNotFoundException{
    OrientadorDAO.editar(this);
}
public void excluir() throws SQLException, ClassNotFoundException{
      OrientadorDAO.excluir(this);
}
   public static List<Orientador> obterOrientadores()
            throws ClassNotFoundException, SQLException {
        return OrientadorDAO.obterOrientadores();
    }
    
    public static Orientador obterOrientador(int matricula) throws ClassNotFoundException, 
            SQLException {
    return OrientadorDAO.obterOrientador(matricula);
}

  
}