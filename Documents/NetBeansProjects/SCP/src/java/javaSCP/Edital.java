
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaSCP;

import dao.CampusDAO;
import dao.EditalDAO;
import dao.SubAreaDAO;
import dao.TipoBolsaDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Angelo
 */
public class Edital {

    private int codigoEdital;
    private int numeroEdital;
    private int anoEdital;
    private int quantidadeBolsas;
    private int validadeBolsa;
    private float valorBolsa;
    private int validadeEdital;
    private TipoBolsa tipoBolsa;
    private Campus campus;
    private SubArea subArea;
    private int codigoTipoBolsa;
    private int codigoCampus;
    private int codigoSubArea;

    public Edital(int codigoEdital, int numeroEdital, int anoEdital, int quantidadeBolsas, int validadeBolsa, float valorBolsa, int validadeEdital, TipoBolsa tipoBolsa, Campus campus, SubArea subArea) {

        this.codigoEdital = codigoEdital;
        this.numeroEdital = numeroEdital;
        this.anoEdital = anoEdital;
        this.quantidadeBolsas = quantidadeBolsas;
        this.validadeBolsa = validadeBolsa;
        this.valorBolsa = valorBolsa;
        this.validadeEdital = validadeEdital;
        this.tipoBolsa = tipoBolsa;
        this.campus = campus;
        this.subArea = subArea;
    }

    public int getNumeroEdital() {
        return numeroEdital;
    }

    public void setNumeroEdital(int numeroEdital) {
        this.numeroEdital = numeroEdital;
    }

    public int getAnoEdital() {
        return anoEdital;
    }

    public void setAnoEdital(int anoEdital) {
        this.anoEdital = anoEdital;
    }

    public int getQuantidadeBolsas() {
        return quantidadeBolsas;
    }

    public void setQuantidadeBolsas(int quantidadeBolsas) {
        this.quantidadeBolsas = quantidadeBolsas;
    }

    public int getValidadeBolsa() {
        return validadeBolsa;
    }

    public void setValidadeBolsa(int validadeBolsa) {
        this.validadeBolsa = validadeBolsa;
    }

    public float getValorBolsa() {
        return valorBolsa;
    }

    public void setValorBolsa(float valorBolsa) {
        this.valorBolsa = valorBolsa;
    }

    public int getValidadeEdital() {
        return validadeEdital;
    }

    public void setValidadeEdital(int validadeEdital) {
        this.validadeEdital = validadeEdital;
    }

    public int getCodigoEdital() {
        return codigoEdital;
    }

    public void setCodigoEdital(int codigoEdital) {
        this.codigoEdital = codigoEdital;
    }

    public int getCodigoTipoBolsa() {
        return codigoTipoBolsa;
    }

    public void setCodigoTipoBolsa(int codigoTipoBolsa) {
        this.codigoTipoBolsa = codigoTipoBolsa;
    }

    public int getCodigoCampus() {
        return codigoCampus;
    }

    public void setCodigoCampus(int codigoCampus) {
        this.codigoCampus = codigoCampus;
    }

    public int getCodigoSubArea() {
        return codigoSubArea;
    }

    public void setCodigoSubArea(int codigoSubArea) {
        this.codigoSubArea = codigoSubArea;
    }

    public TipoBolsa getTipoBolsa() throws ClassNotFoundException, SQLException {
        if (tipoBolsa == null && codigoTipoBolsa != 0) {
            tipoBolsa = TipoBolsaDAO.obterTipoBolsa(codigoTipoBolsa);
        }
        return tipoBolsa;
    }

    public void setTipoBolsa(TipoBolsa tipoBolsa) {
        this.tipoBolsa = tipoBolsa;
    }

    public Campus getCampus() throws ClassNotFoundException, SQLException {
        if (campus == null && codigoCampus != 0) {
            campus = CampusDAO.obterCampus(codigoCampus);
        }
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    public SubArea getSubArea() throws ClassNotFoundException, SQLException {
        if (subArea == null && codigoSubArea != 0) {
            subArea = SubAreaDAO.obterSubArea(codigoSubArea);
        }
        return subArea;
    }

    public void setSubArea(SubArea subArea) {
        this.subArea = subArea;
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        EditalDAO.gravar(this);
    }

    public void editar() throws SQLException, ClassNotFoundException {
        EditalDAO.editar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        EditalDAO.excluir(this);
    }

    public static List<Edital> obterEditais()
            throws ClassNotFoundException, SQLException {
        return EditalDAO.obterEditais();
    }

    public static Edital obterEdital(int codigoEdital)
            throws ClassNotFoundException, SQLException {
        return EditalDAO.obterEdital(codigoEdital);
    }

}
