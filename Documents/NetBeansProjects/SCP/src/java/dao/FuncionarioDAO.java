package dao;

import static dao.DAO.fecharConexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javaSCP.Funcionario;

/**
 *
 * @author Mayara Amanda
 */
public class FuncionarioDAO extends DAO {

    public static Funcionario obterFuncionario(int matricula) throws ClassNotFoundException,
            SQLException {
        Connection conexao = null;
        Statement comando = null;
        Funcionario funcionario = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery(
                    " select * from funcionario, pessoas, instituicao where funcionario.pessoas_codigo = pessoas.codigo and funcionario.instituicao_codigo=instituicao.codigoInstituicao and matricula = " + matricula);
            rs.first();
            funcionario = instanciarFuncionario(rs);
        } finally {
            fecharConexao(conexao, comando);
        }
        return funcionario;
    }

    public static List<Funcionario> obterFuncionarios()
            throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        Funcionario funcionario = null;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from funcionario, pessoas, instituicao where funcionario.pessoas_codigo = pessoas.codigo and funcionario.instituicao_codigo=instituicao.codigoInstituicao");
            while (rs.next()) {
                funcionario = instanciarFuncionario(rs);
                funcionarios.add(funcionario);
            }

        } finally {
            fecharConexao(conexao, comando);
        }
        return funcionarios;

    }

    public static Funcionario instanciarFuncionario(ResultSet rs)
            throws SQLException {
        Funcionario funcionario = new Funcionario(rs.getInt("matricula"), rs.getInt("codigo"), rs.getString("nome"), rs.getString("dataNascimento"),
                rs.getString("estadoCivil"), rs.getString("nacionalidade"), rs.getString("ufNascimento"), rs.getString("nomeMae"),
                rs.getString("nomePai"), rs.getString("naturalidade"), rs.getString("grupoSanguineo"), rs.getString("fatorRH"),
                rs.getString("sexo"), rs.getString("necessidadeEspecial"), rs.getString("cor"), rs.getString("escolaridade"),
                rs.getString("rua"), rs.getInt("numero"), rs.getString("complemento"), rs.getString("bairro"), rs.getString("cidade"),
                rs.getInt("cep"), rs.getString("uf"), rs.getString("pais"), rs.getString("email"),
                rs.getInt("rg"), rs.getString("orgaoExpedidor"), rs.getInt("tituloEleitor"), rs.getInt("numeroComprovanteMilitar"),
                rs.getInt("cpf"), rs.getInt("pisPasep"), rs.getString("dataExpedicaoRG"), rs.getInt("campus_codigo"), null, null);

        funcionario.setChavePessoa(rs.getInt("pessoas_codigo"));
        funcionario.setChaveInstituicao(rs.getInt("instituicao_codigo"));

        return funcionario;

    }

    public static void gravar(Funcionario funcionario) throws SQLException, ClassNotFoundException {
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
                    + " values(" + funcionario.getCodigo() + ", '"
                    + funcionario.getNome() + "', '"
                    + funcionario.getDataNascimento() + "','"
                    + funcionario.getEstadoCivil() + "', '"
                    + funcionario.getNacionalidade() + "', '"
                    + funcionario.getUfNascimento() + "', '"
                    + funcionario.getNomeMae() + "','"
                    + funcionario.getNomePai() + "', '"
                    + funcionario.getNaturalidade() + "', '"
                    + funcionario.getGrupoSanguineo() + "', '"
                    + funcionario.getFatorRH() + "', '"
                    + funcionario.getSexo() + "', '"
                    + funcionario.getNecessidadeEspecial() + "', '"
                    + funcionario.getCor() + "', '"
                    + funcionario.getEscolaridade() + "', '"
                    + funcionario.getRua() + "', "
                    + funcionario.getNumero() + ", '"
                    + funcionario.getComplemento() + "', '"
                    + funcionario.getBairro() + "', '"
                    + funcionario.getCidade() + "',"
                    + funcionario.getCep() + ", '"
                    + funcionario.getUf() + "', '"
                    + funcionario.getPais() + "', '"
                    + funcionario.getEmail() + "', "
                    + funcionario.getRg() + ", '"
                    + funcionario.getOrgaoExpedidor() + "', "
                    + funcionario.getTituloEleitor() + ", "
                    + funcionario.getNumeroComprovanteMilitar() + ", "
                    + funcionario.getCpf() + ", "
                    + funcionario.getPisPasep() + ", '"
                    + funcionario.getDataExpedicaoRG() + "'";

            if (funcionario.getCampus() == null) {
                stringSQL = stringSQL + ", " + null;
            } else {
                stringSQL = stringSQL + ", " + funcionario.getCampus().getCodigoCampus();
            }
            stringSQL = stringSQL + ")";
            comando.execute(stringSQL);
            
            stringSQL = "insert into funcionario(matricula, pessoas_codigo, instituicao_codigo) "
                    + " values(" + funcionario.getMatricula() + ","
                    + funcionario.getCodigo()+"";

            
            if (funcionario.getInstituicao() == null) {
                stringSQL = stringSQL + ", " + null;
            } else {
                stringSQL = stringSQL + ", " + funcionario.getInstituicao().getCodigoInstituicao();
            }

            stringSQL = stringSQL + ")";
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }

    }

    public static void editar(Funcionario funcionario) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();

            stringSQL = "update pessoas set "
                    + "cpf = " + funcionario.getCpf() + ", "
                    + "nome = '" + funcionario.getNome() + "', "
                    + "dataNascimento ='" + funcionario.getDataNascimento() + "',"
                    + "estadoCivil = '" + funcionario.getEstadoCivil() + "', "
                    + "nacionalidade = '" + funcionario.getNacionalidade() + "', "
                    + "ufNascimento='" + funcionario.getUfNascimento() + "', "
                    + "nomeMae = '" + funcionario.getNomeMae() + "',"
                    + "nomePai = '" + funcionario.getNomePai() + "', "
                    + "naturalidade ='" + funcionario.getNaturalidade() + "', "
                    + "grupoSanguineo = '" + funcionario.getGrupoSanguineo() + "', "
                    + "fatorRH = '" + funcionario.getFatorRH() + "', "
                    + "sexo ='" + funcionario.getSexo() + "', "
                    + "necessidadeEspecial = '" + funcionario.getNecessidadeEspecial() + "', "
                    + "cor = '" + funcionario.getCor() + "', "
                    + "escolaridade ='" + funcionario.getEscolaridade() + "', "
                    + "rua ='" + funcionario.getRua() + "', "
                    + "numero = " + funcionario.getNumero() + ", "
                    + "complemento ='" + funcionario.getComplemento() + "', "
                    + "bairro ='" + funcionario.getBairro() + "', "
                    + "cidade ='" + funcionario.getCidade() + "',"
                    + "cep=" + funcionario.getCep() + ", "
                    + "uf='" + funcionario.getUf() + "', "
                    + "pais='" + funcionario.getPais() + "', "
                    + "email='" + funcionario.getEmail() + "', "
                    + "rg =" + funcionario.getRg() + ", "
                    + "orgaoExpedidor ='" + funcionario.getOrgaoExpedidor() + "', "
                    + "tituloEleitor =" + funcionario.getTituloEleitor() + ", "
                    + "numeroComprovanteMilitar =" + funcionario.getNumeroComprovanteMilitar() + ", "
                    + "pisPasep =" + funcionario.getPisPasep() + ", "
                    + "dataExpedicaoRG ='" + funcionario.getDataExpedicaoRG() + "'";


            if (funcionario.getCampus() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + ", campus_codigo = " + funcionario.getCampus().getCodigoCampus();
            }

            stringSQL = stringSQL + " where codigo = " + funcionario.getCodigo();

            comando.execute(stringSQL);

            stringSQL = "update funcionario set "
                    + " matricula = " + funcionario.getMatricula() + "";

            
            if (funcionario.getInstituicao() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + ", instituicao_codigo = " + funcionario.getInstituicao().getCodigoInstituicao();
            }

            stringSQL = stringSQL + " where matricula = " + funcionario.getMatricula();

            comando.execute(stringSQL);

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(Funcionario funcionario)
            throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();

            stringSQL = "delete from funcionario where matricula = " + funcionario.getMatricula();
            comando.execute(stringSQL);
            stringSQL = "delete from pessoas where codigo = " + funcionario.getCodigo();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }

    }
}
