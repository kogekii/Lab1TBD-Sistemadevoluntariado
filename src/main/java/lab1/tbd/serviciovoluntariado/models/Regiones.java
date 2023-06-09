package lab1.tbd.serviciovoluntariado.models;

public class Regiones {
    //Atributos
    private int gid;
    private String nom_reg;
    private String nom_prov ;
    private String cod_com;
    private String nom_com;
    private int cod_regi;
    private String superficie;
    private int poblac02;
    private int pobl2010;
    private String shape_leng;
    private String shape_area;
    private String geom;

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getNom_reg() {
        return nom_reg;
    }

    public void setNom_reg(String nom_reg) {
        this.nom_reg = nom_reg;
    }

    public String getNom_prov() {
        return nom_prov;
    }

    public void setNom_prov(String nom_prov) {
        this.nom_prov = nom_prov;
    }

    public String getCod_com() {
        return cod_com;
    }

    public void setCod_com(String cod_com) {
        this.cod_com = cod_com;
    }

    public String getNom_com() {
        return nom_com;
    }

    public void setNom_com(String nom_com) {
        this.nom_com = nom_com;
    }

    public int getCod_regi() {
        return cod_regi;
    }

    public void setCod_regi(int cod_regi) {
        this.cod_regi = cod_regi;
    }

    public String getSuperficie() {
        return superficie;
    }

    public void setSuperficie(String superficie) {
        this.superficie = superficie;
    }

    public int getPoblac02() {
        return poblac02;
    }

    public void setPoblac02(int poblac02) {
        this.poblac02 = poblac02;
    }

    public int getPobl2010() {
        return pobl2010;
    }

    public void setPobl2010(int pobl2010) {
        this.pobl2010 = pobl2010;
    }

    public String getShape_leng() {
        return shape_leng;
    }

    public void setShape_leng(String shape_leng) {
        this.shape_leng = shape_leng;
    }

    public String getShape_area() {
        return shape_area;
    }

    public void setShape_area(String shape_area) {
        this.shape_area = shape_area;
    }

    public String getGeom() {
        return geom;
    }

    public void setGeom(String geom) {
        this.geom = geom;
    }
}