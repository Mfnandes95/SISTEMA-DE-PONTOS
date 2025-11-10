public class Usuario{
    private int id; 
    private String nome;
    private String email;
    private String cpf;
    private String cargo;
    
    public Usuario(int id, String nome, String email, String cpf, String cargo){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.cargo = cargo;
    }
    
    public int getId(){
        return this.id;
    }
    public String getNome(){
        return this.nome;
    }
    public String getEmail(){
        return this.email;
    }
    public String getCpf(){
        return this.cpf;
    }
    public String getCargo(){
        return this.cargo;
    }
    
    public String setNome(){
        return nome;
    }
    
    public String setCargo(){
        return cargo;
    }
    public String setEmail(){
        return email;
    }
    @Override
    public String toString(){
        return "Id:" + id + "|Cargo: " + cargo + "|Nome: " + nome + "|cpf: " + cpf + "|email: " + email;
    }
}
