import java.util.Objects;


//Duarte Oliveira miei
public class Veiculo {
    private String codigo;
    private String marca;
    private String modelo;
    private int ano;
    private double media;
    private double base;
    private int classificacao;
    private int users;
    private double kms;

    public Veiculo(String codigo, String marca, String modelo, int ano, double media, double base, int classificacao, int users, double kms) {
        this.codigo = codigo;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.media = media;
        this.base = base;
        this.classificacao = classificacao;
        this.users = users;
        this.kms = kms;
    }

    public Veiculo() {
        this.codigo = " ";
        this.marca = " ";
        this.modelo = " ";
        this.ano = 0;
        this.media = 0;
        this.base = 0;
        this.classificacao = 0;
        this.users = 0;
        this.kms = 0;
    }

    public Veiculo(Veiculo v) {
        this.codigo = v.getCodigo();
        this.marca = v.getMarca();
        this.modelo = v.getModelo();
        this.ano = v.getAno();
        this.media = v.getMedia();
        this.base = v.getBase();
        this.classificacao = v.getClassificacao();
        this.users = v.getUsers();
        this.kms = this.getKms();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public int getUsers() {
        return users;
    }

    public void setUsers(int users) {
        this.users = users;
    }

    public double getKms() {
        return kms;
    }

    public void setKms(double kms) {
        this.kms = kms;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return ano == veiculo.ano &&
                Double.compare(veiculo.media, media) == 0 &&
                Double.compare(veiculo.base, base) == 0 &&
                classificacao == veiculo.classificacao &&
                users == veiculo.users &&
                Double.compare(veiculo.kms, kms) == 0 &&
                Objects.equals(codigo, veiculo.codigo) &&
                Objects.equals(marca, veiculo.marca) &&
                Objects.equals(modelo, veiculo.modelo);
    }

    public int hashCode() {
        return Objects.hash(codigo, marca, modelo, ano, media, base, classificacao, users, kms);
    }

    public Veiculo clone() {
        return new Veiculo(this);
    }
}
