/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaSCP;

/**
 *
 * @author Angelo
 */
public class Parametro {
    private int codigoParametro;
    private String subaArea;
    private String tipoBolsa;
    private String tipoCurso;
    private String setor;
    private String instituicao;

    public Parametro(int codigoParametro, String subaArea, String tipoBolsa, String tipoCurso, String setor, String instituicao) {
        this.codigoParametro = codigoParametro;
        this.subaArea = subaArea;
        this.tipoBolsa = tipoBolsa;
        this.tipoCurso = tipoCurso;
        this.setor = setor;
        this.instituicao = instituicao;
    }

    public int getCodigoParametro() {
        return codigoParametro;
    }

    public void setCodigoParametro(int codigoParametro) {
        this.codigoParametro = codigoParametro;
    }

    public String getSubaArea() {
        return subaArea;
    }

    public void setSubaArea(String subaArea) {
        this.subaArea = subaArea;
    }

    public String getTipoBolsa() {
        return tipoBolsa;
    }

    public void setTipoBolsa(String tipoBolsa) {
        this.tipoBolsa = tipoBolsa;
    }

    public String getTipoCurso() {
        return tipoCurso;
    }

    public void setTipoCurso(String tipoCurso) {
        this.tipoCurso = tipoCurso;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }
    
    
}
