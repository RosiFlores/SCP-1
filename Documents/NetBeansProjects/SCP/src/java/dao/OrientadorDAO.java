package dao;
import static dao.DAO.fecharConexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javaSCP.Orientador;

/**
 *
 * @author Mayara Amanda
 */
public class OrientadorDAO extends DAO {
     
       
    public static Orientador obterOrientador(int matricula) throws ClassNotFoundException,
            SQLException {
        Connection conexao = null;
        Statement comando = null;
        Orientador orientador = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
              ResultSet rs = comando.executeQuery("select * from orientador, pessoas where orientador.pessoas_codigo = pessoas.codigo and matricula = " +matricula);
            rs.first();
            orientador = instanciarOrientador(rs);


        } finally {
            fecharConexao(conexao, comando);
        }
        return orientador;
    }

    public static List<Orientador> obterOrientadores()
            throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Orientador> orientadores = new ArrayList<Orientador>();
        Orientador orientador = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from orientador, pessoas, nucleo, campus where orientador.pessoas_codigo = pessoas.codigo and orientador.nucleo_codigo = nucleo.codigoNucleo and pessoas.campus_codigo=campus.codigoCampus");
            while (rs.next()) {
                orientador = instanciarOrientador(rs);
                orientadores.add(orientador);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return orientadores;
        
        
    }
    public static  Orientador instanciarOrientador(ResultSet rs)
            throws SQLException{
        Orientador orientador = new Orientador(rs.getInt("matricula"), rs.getString("homepageLattes"), rs.getInt("codigo") ,rs.getString("nome") , rs.getString("dataNascimento"), rs.getString("estadoCivil"), rs.getString("nacionalidade") ,
                rs.getString("ufNascimento") , rs.getString("nomeMae") , rs.getString("nomePai") , rs.getString("naturalidade") , rs.getString("grupoSanguineo") , 
                rs.getString("fatorRH") , rs.getString("sexo") , rs.getString("necessidadeEspecial") , rs.getString("cor") ,
                rs.getString("escolaridade") , rs.getString("rua") , rs.getInt("numero") , rs.getString("complemento") , rs.getString("bairro") , 
                rs.getString("cidade") , rs.getInt("cep"), rs.getString("uf") , rs.getString("pais"), rs.getString("email") , rs.getInt("rg"), rs.getString("orgaoExpedidor") , 
                rs.getInt("tituloEleitor"), rs.getInt("numeroComprovanteMilitar"), rs.getInt("cpf"), rs.getInt("pisPasep") , rs.getString("dataExpedicaoRG"),rs.getInt("campus_codigo"), null,null);
 
        orientador.setChavePessoa(rs.getInt("pessoas_codigo"));
        orientador.setCodigoNucleo(rs.getInt("nucleo_codigo"));
        
        
        return orientador;
        
    }    
    
    public static void gravar(Orientador orientador) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            
            
            stringSQL = "insert into pessoas(codigo, nome, dataNascimento, estadoCivil, nacionalidade,  ufNascimento, nomeMae, "
                    + "nomePai, naturalidade, grupoSanguineo, fatorRH, sexo, necessidadeEspecial, cor, escolaridade, rua, numero, "
                    + "complemento, bairro, cidade, cep, uf, pais, email, rg, orgaoExpedidor, tituloEleitor, numeroComprovanteMilitar, "
                    + "cpf, pisPasep, dataExpedicaoRG, campus_codigo)"
                    + " values(" + orientador.getCodigo() + ", '"
                    + orientador.getNome() + "', '"
                    + orientador.getDataNascimento() + "','"
                    + orientador.getEstadoCivil() + "', '"
                    + orientador.getNacionalidade() + "', '"
                    + orientador.getUfNascimento() + "', '"
                    + orientador.getNomeMae() + "','"
                    + orientador.getNomePai() + "', '"
                    + orientador.getNaturalidade() + "', '"
                    + orientador.getGrupoSanguineo() + "', '"
                    + orientador.getFatorRH() + "', '"
                    + orientador.getSexo() + "', '"
                    + orientador.getNecessidadeEspecial() + "', '"
                    + orientador.getCor() + "', '"
                    + orientador.getEscolaridade() + "', '"
                    + orientador.getRua() + "', "
                    + orientador.getNumero() + ", '"
                    + orientador.getComplemento() + "', '"
                    + orientador.getBairro() + "', '"
                    + orientador.getCidade() + "',"
                    + orientador.getCep() + ", '"
                    + orientador.getUf() + "', '"
                    + orientador.getPais() + "', '"
                    + orientador.getEmail() + "', "
                    + orientador.getRg() + ", '"
                    + orientador.getOrgaoExpedidor() + "', "
                    + orientador.getTituloEleitor() + ", "
                    + orientador.getNumeroComprovanteMilitar() + ", "
                    + orientador.getCpf() + ", "
                    + orientador.getPisPasep() + ", '"
                    + orientador.getDataExpedicaoRG() + "'";
                    
                    if (orientador.getCampus() == null) {
                    stringSQL = stringSQL + null;
                    } else {
                    stringSQL = stringSQL + ", " + orientador.getCampus().getCodigoCampus();
                    }

                    stringSQL = stringSQL + ")";
                    comando.execute(stringSQL);    
            
            stringSQL = "insert into orientador( matricula, homepageLattes, pessoas_codigo, nucleo_codigo)"
                    + "values(" +  orientador.getMatricula() + ",'"
                    + orientador.getHomepageLattes() + "',"
                    + orientador.getCodigo() + "";
                    
                     
                     
                    
                    if (orientador.getNucleo() == null) {
                    stringSQL = stringSQL + ", " + null;
                    } else {
                    stringSQL = stringSQL + ", " + orientador.getNucleo().getCodigoNucleo();
                    }

             stringSQL = stringSQL + ")";
            comando.execute(stringSQL);
  
            
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    
    public static void editar (Orientador orientador) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            
            stringSQL = "update pessoas set "
                    + "cpf = " + orientador.getCpf() + ", "
                    + "nome = '" + orientador.getNome() + "', "
                    + "dataNascimento ='" + orientador.getDataNascimento() + "',"
                    + "estadoCivil = '" + orientador.getEstadoCivil() + "', "
                    + "nacionalidade = '" + orientador.getNacionalidade() + "', "
                    + "ufNascimento='" + orientador.getUfNascimento() + "', "
                    + "nomeMae = '" + orientador.getNomeMae() + "',"
                    + "nomePai = '" + orientador.getNomePai() + "', "
                    + "naturalidade ='" + orientador.getNaturalidade() + "', "
                    + "grupoSanguineo = '" + orientador.getGrupoSanguineo() + "', "
                    + "fatorRH = '" + orientador.getFatorRH() + "', "
                    + "sexo ='" + orientador.getSexo() + "', "
                    + "necessidadeEspecial = '" + orientador.getNecessidadeEspecial() + "', "
                    + "cor = '" + orientador.getCor() + "', "
                    + "escolaridade ='" + orientador.getEscolaridade() + "', "
                    + "rua ='" + orientador.getRua() + "', "
                    + "numero = " + orientador.getNumero() + ", "
                    + "complemento ='" + orientador.getComplemento() + "', "
                    + "bairro ='" + orientador.getBairro() + "', "
                    + "cidade ='" + orientador.getCidade() + "',"
                    + "cep=" + orientador.getCep() + ", "
                    + "uf='" + orientador.getUf() + "', "
                    + "pais='" + orientador.getPais() + "', "
                    + "email='" + orientador.getEmail() + "', "
                    + "rg =" + orientador.getRg() + ", "
                    + "orgaoExpedidor ='" + orientador.getOrgaoExpedidor() + "', "
                    + "tituloEleitor =" + orientador.getTituloEleitor() + ", "
                    + "numeroComprovanteMilitar =" + orientador.getNumeroComprovanteMilitar() + ", "
                    + "pisPasep =" + orientador.getPisPasep() + ", "
                    + "dataExpedicaoRG ='" + orientador.getDataExpedicaoRG() + "'";

                      
            if (orientador.getCampus() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + ", campus_codigo = " + orientador.getCampus().getCodigoCampus();
            }

            stringSQL = stringSQL + " where codigo = " + orientador.getCodigo();
            
            comando.execute(stringSQL);
            
            stringSQL = "update orientador set "
                    
                    + " homepageLattes = '" +orientador.getHomepageLattes() + "'";
                    
                      
                                    
                    if(orientador.getNucleo().getCodigoNucleo() == 0){
                        stringSQL = stringSQL + null;
                    }else{
                    stringSQL = stringSQL +  " , nucleo_codigo = " +orientador.getNucleo().getCodigoNucleo();
                    }
                    
                    
                    stringSQL = stringSQL + " where matricula = "+orientador.getMatricula();
            
                    comando.execute(stringSQL);
            
             
            
                    }finally{
            fecharConexao(conexao,comando);
        }
    }
    
    public static void excluir(Orientador orientador)
            throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from orientador where matricula = " + orientador.getMatricula();
            comando.execute(stringSQL);
            stringSQL = "delete from pessoas where codigo = " + orientador.getCodigo();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }

    }
    
    
    
}