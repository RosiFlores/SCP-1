package javaSCP;
import dao.CampusDAO;
import dao.NucleoDAO;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author Mayara Amanda
 */
public class Nucleo {
 
    private int codigoNucleo;
    private String nomeNucleo;   
    private Campus campus;
    private int chaveCampus;
    
     public Nucleo(int codigoNucleo, String nomeNucleo, Campus campus) {
        this.codigoNucleo = codigoNucleo;
        this.nomeNucleo = nomeNucleo;
        this.campus = campus;
        
    }
    
    public int getCodigoNucleo() {
        return codigoNucleo;
    }
    public void setCodigoNucleo(int codigoNucleo) {
        this.codigoNucleo = codigoNucleo;
    }
    public String getNomeNucleo() {
        return nomeNucleo;
    }
    public void setNomeNucleo(String nomeNucleo) {
        this.nomeNucleo = nomeNucleo;
    }
    
    public Campus getCampus() throws ClassNotFoundException, SQLException {
        if (campus == null && chaveCampus!= 0) {
            campus = CampusDAO.obterCampus(chaveCampus);
        }
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    public int getChaveCampus() {
        return chaveCampus;
    }

    public void setChaveCampus(int chaveCampus) {
        this.chaveCampus = chaveCampus;
    }
    
    public void gravar() throws SQLException, ClassNotFoundException {
         NucleoDAO.gravar(this);
     }
      public void editar() throws SQLException, ClassNotFoundException {
         NucleoDAO.editar(this);
     }
        public void excluir() throws SQLException, ClassNotFoundException {
         NucleoDAO.excluir(this);
     }
    
    public static List<Nucleo> obterNucleos()
            throws ClassNotFoundException, SQLException {
        return NucleoDAO.obterNucleos();
    }
    
    public static Nucleo obterNucleo(int codigoNucleo) throws ClassNotFoundException,
            SQLException {
        return NucleoDAO.obterNucleo(codigoNucleo);
    }

   

    }