import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;
import java.time.LocalDateTime;


public class FBPost implements Comparable <FBPost> 
{
    private int id;
    private String nome;
    private LocalDateTime date;
    private String conteudo;
    private int likes;
    private List<String> comentarios;

    public FBPost clone(){
        return new FBPost(this); }
    
    public FBPost(int id, String nome, LocalDateTime date, String conteudo, int likes, ArrayList<String> c) {
        this.id = id;
        this.nome = nome;
        this.date = date;
        this.conteudo = conteudo;
        this.likes = likes;
        setComentarios(c);
    }

    public FBPost() {
        this.id = 0;
        this.nome = " ";
        this.date = LocalDateTime.now();
        this.conteudo = " ";
        this.likes = 0;
        this.comentarios = new ArrayList<>();
    }

    public FBPost (FBPost p) {
        this.id = p.getId();
        this.nome = p.getNome();
        this.date = p.getDate();
        this.conteudo = p.getConteudo();
        this.likes = p.getLikes();
        setComentarios(p.getComentarios());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public ArrayList <String> getComentarios(){
        ArrayList <String> aux = new ArrayList <>();
        for( String l : this.comentarios)
            aux.add(l);
        return aux;
    }

    public void setComentarios(ArrayList <String> comentarios){
        this.comentarios = new ArrayList<>();
        for(String c: comentarios)
            this.comentarios.add(c);
    }
     public void addComentario(String comentario){
        this.comentarios.add(comentario);
    }
    
        public String toString() {
        return "FBPost{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", date=" + date +
                ", conteudo='" + conteudo + '\'' +
                ", likes=" + likes +
                ", cometarios=" + comentarios +
                '}';
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;

        FBPost fbPost = (FBPost) object;

        if (id != fbPost.id) return false;
        if (likes != fbPost.likes) return false;
        if (nome != null ? !nome.equals(fbPost.nome) : fbPost.nome != null) return false;
        if (date != null ? !date.equals(fbPost.date) : fbPost.date != null) return false;
        if (conteudo != null ? !conteudo.equals(fbPost.conteudo) : fbPost.conteudo != null) return false;
        if (comentarios != null ? !comentarios.equals(fbPost.comentarios) : fbPost.comentarios != null) return false;

        return true;
    }
  
 public int compareTo(FBPost f){
   return Integer.compare(this.comentarios.size(),f.comentarios.size());
 }

}
