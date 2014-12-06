package javaSCP;

import dao.TipoBolsaDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Angelo
 */
public class TipoBolsa {

    private int codigoTipoBolsa;
    private String nomeTipoBolsa;

    public TipoBolsa(int codigoTipoBolsa, String nomeTipoBolsa) {
        this.codigoTipoBolsa = codigoTipoBolsa;
        this.nomeTipoBolsa = nomeTipoBolsa;
    }

    public int getCodigoTipoBolsa() {
        return codigoTipoBolsa;
    }

    public void setCodigoTipoBolsa(int codigoTipoBolsa) {
        this.codigoTipoBolsa = codigoTipoBolsa;
    }

    public String getNomeTipoBolsa() {
        return nomeTipoBolsa;
    }

    public void setNomeTipoBolsa(String nomeTipoBolsa) {
        this.nomeTipoBolsa = nomeTipoBolsa;
    }
    
    public void gravar() throws SQLException, ClassNotFoundException {
         TipoBolsaDAO.gravar(this);
     }
      public void alterar() throws SQLException, ClassNotFoundException {
         TipoBolsaDAO.editar(this);
     }
        public void excluir() throws SQLException, ClassNotFoundException {
         TipoBolsaDAO.excluir(this);
     }
        
    public static List<TipoBolsa> obterTipoBolsas()
            throws ClassNotFoundException, SQLException {
        return TipoBolsaDAO.obterTipoBolsas();

    }

    public static TipoBolsa obterTipoBolsa(int codigoTipoBolsa) throws ClassNotFoundException,
            SQLException {
        return TipoBolsaDAO.obterTipoBolsa(codigoTipoBolsa);
    }

}