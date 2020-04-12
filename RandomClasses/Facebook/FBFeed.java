import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class FBFeed  
{
    private List<FBPost> posts;
    
    public FBFeed clone(){
    return new FBFeed(this);    
        
    }
    
    public FBFeed(FBFeed e){
    setPosts(e.getPosts());
    }
    
    public FBFeed(List <FBPost> post){
    setPosts(post);     
    }
    
    
    
    public FBFeed()
    {
        this.posts = new ArrayList<>();
    }


    public List<FBPost> getPosts() {
        List<FBPost> aux = new ArrayList <>();
        for (FBPost p : this.posts)
            aux.add(p.clone());
        return aux;
    }

    public void setPosts(List<FBPost> pst) {
        this.posts = new ArrayList<>();
        for (FBPost p : pst)
            this.posts.add(p.clone());
    }

    public int nrPosts(String user){
        return (int) this.posts.stream() 
                         .filter(u -> u.getNome().equals(user))
                                                 .count(); 
    }   

    public List<FBPost> postsOf (String user){
    return this.posts.stream()
                     .filter(u -> u.getNome().equals(user)).collect(Collectors.toList());
    
    }

    public List<FBPost> postsOfData (String user, LocalDateTime inicio, LocalDateTime fim){
    return (List <FBPost>) this.posts.stream()
                           .filter(u -> u.getNome().equals(user))
                           .filter(u-> u.getDate().isAfter(inicio))
                           .filter(u-> u.getDate().isBefore(fim));
                     
    }
    
      

    public FBPost getPost (int id){
    return (FBPost) this.posts.stream().filter(u -> u.getId()==id);
    }

    
   
  public void comment(FBPost post, String comentario){
        Iterator<FBPost> it = this.posts.iterator();
        FBPost f;
        boolean found = false;
        while (it.hasNext() && !found){
            f = it.next();
            if (f.equals(post)){
                f.addComentario(comentario);
                found = true;
            }
        }
    }

    public void comment(int postid, String comentario){
        Iterator<FBPost> it = this.posts.iterator();
        FBPost f;
        boolean found = false;
        while (it.hasNext() && !found){
            f = it.next();
            if (f.getId() == postid){
                f.addComentario(comentario);
                found = true;
            }
        }
    }

    public void like(FBPost post){
        Iterator<FBPost> it = this.posts.iterator();
        FBPost f;
        boolean found = false;
        while (it.hasNext() && !found){
            f = it.next();
            if (f.equals(post)){
                f.setLikes(f.getLikes()+1);
                found = true;
            }
        }
    }

    public void like(int postid){
        Iterator<FBPost> it = this.posts.iterator();
        FBPost f;
        boolean found = false;
        while (it.hasNext() && !found){
            f = it.next();
            if (f.getId() == postid){
                f.setLikes(f.getLikes()+1);
                found = true;
            }
        }
    }

       

public List<Integer> top5Comments(){ 
return this.posts.stream().sorted((o1,o2)->o1.compareTo(o2))
                          .limit(5).map(FBPost::getId)
                          .collect(Collectors.toList());                               
}

public List<Integer> top5Comentarios(){
//ridiculamente precário
//lista auxiliar
List<FBPost> aux = new ArrayList<>();
//iterator percorre a lista de posts do fbfeed
        Iterator<FBPost> it = this.posts.iterator();
        FBPost f;
        //adiciona-se à lista auxiliar os posts do fbfeed (basicamente faz copia dela)
        while (it.hasNext()){
            f = it.next();
            aux.add(f);
        }
        //organiza os posts por tamanho da lista de comentarios
        aux.sort((o1,o2)->o1.compareTo(o2));
        //iterador que percorre a lista auxiliar
        Iterator<FBPost> it2 = aux.iterator();
        //criei esta variavel para se perceber melhor
        FBPost fb;
        //lista final
        List<Integer> fin = new ArrayList<>();
        int i=0;
        //quer se o top 5 de vendas logo
        while(i<5){
            //percorre se a estrutura auxiliar com o iterador2
            fb=it2.next();
            //adiciona se a lista final os ids das 5 com mais comentarios
            fin.add(fb.getId());
        }
return fin;            
}
}    



  

