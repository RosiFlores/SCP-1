package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javaSCP.Edital;
import javaSCP.Orientador;
import javaSCP.Projeto;
import javaSCP.SubArea;
import javaSCP.TipoBolsa;

/**
 *
 * @author Angelo
 */
public class ProjetoDAO extends DAO {

    public static Projeto obterProjeto(int codigoProjeto) throws ClassNotFoundException,
            SQLException {
        Connection conexao = null;
        Statement comando = null;
        Projeto projeto = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from projeto, tipobolsa, edital, subareaconhecimento where projeto.tipobolsa_codigo = tipobolsa.codigoTipoBolsa and projeto.edital_codigo = edital.codigoEdital and projeto.subareaconhecimento_codigo = subareaconhecimento.codigoSubArea and codigoProjeto=" + codigoProjeto);
            rs.first();
            projeto = instanciarProjeto(rs);

        } finally {
            fecharConexao(conexao, comando);
        }
        return projeto;
    }

    public static List<Projeto> obterProjetos()
            throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Projeto> projetos = new ArrayList<Projeto>();
        Projeto projeto = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from projeto, tipobolsa, edital, subareaconhecimento where projeto.tipobolsa_codigo = tipobolsa.codigoTipoBolsa and projeto.edital_codigo = edital.codigoEdital and projeto.subareaconhecimento_codigo =subareaconhecimento.codigoSubArea ");
            while (rs.next()) {
                projeto = instanciarProjeto(rs);
                projetos.add(projeto);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return projetos;
    }

    public static Projeto instanciarProjeto(ResultSet rs)
            throws SQLException {
        Projeto projeto = new Projeto(rs.getInt("codigoProjeto"), rs.getString("nomeProjeto"), rs.getInt("cargaHoraria"), rs.getString("palavraChave"), rs.getInt("duracaoProjeto"), rs.getString("dataInicio"), rs.getString("dataTermino"), rs.getFloat("valorFinanciamento"), rs.getString("dataFinanciamento"), rs.getString("programa"), rs.getString("agenciaFomento"), rs.getInt("quantidadeBolsa"), rs.getString("instituicaoParceira"), rs.getString("grupoPesquisaCNPq"), rs.getString("coOrientador"), null, null, null, null);
     
        projeto.setCodigoTipoBolsa(rs.getInt("tipoBolsa_codigo"));
        projeto.setCodigoEdital(rs.getInt("edital_codigo"));
        projeto.setCodigoSubArea(rs.getInt("subareaconhecimento_codigo"));
        projeto.setCodigoCoordenador(rs.getInt("orientador_codigo"));
        return projeto;
    }

    public static void gravar(Projeto projeto) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "insert into projeto(codigoProjeto, nomeProjeto, cargaHoraria, palavrachave, duracaoProjeto, dataInicio, dataTermino, valorFinanciamento, dataFinanciamento, programa, agenciaFomento, quantidadeBolsa, instituicaoParceira, coOrientador, grupoPesquisaCNPq, tipobolsa_codigo, edital_codigo, orientador_codigo, subareaconhecimento_codigo )"
                    + "values(" + projeto.getCodigoProjeto() + ",'"
                    + projeto.getNomeProjeto() + "',"
                    + projeto.getCargaHoraria() + ",'"
                    + projeto.getPalavraChave() + "',"
                    + projeto.getDuracao() + ",'"
                    + projeto.getDataInicio() + "','"
                    + projeto.getDataTermino() + "',"
                    + projeto.getValorfinanciamento() + ",'"
                    + projeto.getDataFinanciamento() + "','"
                    + projeto.getPrograma() + "','"
                    + projeto.getAgenciaFomento() + "',"
                    + projeto.getQuantidadeBolsista() + ",'"
                    + projeto.getInstituicaoParceira() + "','"
                    + projeto.getProfessorParticipante() + "','"
                    + projeto.getGrupoPesquisaCNPq() + "'";

            if (projeto.getTipoBolsa() == null) {
                stringSQL = stringSQL + "," + null;
            } else {
                stringSQL = stringSQL + "," + projeto.getTipoBolsa().getCodigoTipoBolsa();

            }

            if (projeto.getEdital() == null) {
                stringSQL = stringSQL + ","  + null;
            } else {
                stringSQL = stringSQL + "," + projeto.getEdital().getCodigoEdital();

            }

            if (projeto.getCoordenador() == null) {
                stringSQL = stringSQL + ","  + null;
            } else {
                stringSQL = stringSQL + "," + projeto.getCoordenador().getMatricula();

            }
            if (projeto.getSubArea() == null) {
                stringSQL = stringSQL + ","  + null;
            } else {
                stringSQL = stringSQL + "," + projeto.getSubArea().getCodigoSubArea();

            }

            stringSQL = stringSQL + ")";
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void editar(Projeto projeto) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update projeto set "
                    + "codigoProjeto = " + projeto.getCodigoProjeto() + ","
                    + "nomeProjeto = '" + projeto.getNomeProjeto() + "',"
                    + "cargaHoraria = " + projeto.getCargaHoraria() + ","
                    + "palavraChave = '" + projeto.getPalavraChave() + "',"
                    + "duracaoProjeto = " + projeto.getDuracao() + ","
                    + "dataInicio = '" + projeto.getDataInicio() + "',"
                    + "dataTermino = '" + projeto.getDataTermino() + "',"
                    + "valorFinanciamento = " + projeto.getValorfinanciamento() + ","
                    + "dataFinanciamento = '" + projeto.getDataFinanciamento() + "',"
                    + "programa = '" + projeto.getPrograma() + "',"
                    + "agenciaFomento = '" + projeto.getAgenciaFomento() + "',"
                    + "quantidadeBolsa = " + projeto.getQuantidadeBolsista() + ","
                    + "instituicaoParceira = '" + projeto.getInstituicaoParceira() + "',"
                    + "coorientador = '" + projeto.getProfessorParticipante() + "',"
                    + "grupoPesquisaCNPq = '" + projeto.getGrupoPesquisaCNPq() + "'";

            if (projeto.getTipoBolsa() == null) {
                stringSQL = stringSQL + "," + null;
            } else {
                stringSQL = stringSQL + ", tipobolsa_codigo =" + projeto.getTipoBolsa().getCodigoTipoBolsa();

            }

            if (projeto.getEdital() == null) {
                stringSQL = stringSQL + ","  + null;
            } else {
                stringSQL = stringSQL + ", edital_codigo =" + projeto.getEdital().getCodigoEdital();

            }

            if (projeto.getCoordenador() == null) {
                stringSQL = stringSQL + "," + null;
            } else {
                stringSQL = stringSQL + ", orientador_codigo =" + projeto.getCoordenador().getMatricula();

            }
            if (projeto.getSubArea() == null) {
                stringSQL = stringSQL + ","  + null;
            } else {
                stringSQL = stringSQL + ", subareaconhecimento_codigo =" + projeto.getSubArea().getCodigoSubArea();

            }
            
            stringSQL = stringSQL + " where codigoProjeto = " + projeto.getCodigoProjeto();
            comando.execute(stringSQL);

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(Projeto projeto) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from projeto where codigoProjeto = "
                    + projeto.getCodigoProjeto();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }

    }

}