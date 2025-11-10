//Código Principal, onde ficará o Menu de inserção e atualização de perfis.
//Reparar a função de administrador, deixando ela disponível apenas para a equipe de TI responsável.

import java.util.Scanner;
import java.util.ArrayList;

public class SistemaPonto{
    private static ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    
    private static Usuario buscarId(int id){
        for (Usuario u : listaUsuarios){
            if(u.getId() == id){
                return u;
            }
        } return null;
    }
  
  //opções de administrador
	public static void main(String[] args){
	    int opcao = 0;
	    do {
	       exibirMenu();
	        try{
	            opcao = Integer.parseInt(scanner.nextLine());
	        } catch (NumberFormatException e) {
	            opcao = -1;
	        }
	     switch (opcao){
	        case 1:
	           cadastrarUsuario();
	           break;
	       case 2:
	           listarUsuarios();
	           break;
	       case 3:
	           atualizarUsuario();
	           break;
	       case 4:
	           removerUsuario();
	           break;
	       case 5:
	           System.out.println("Encerrando...");
	           break;
	       default:
	            System.out.println("Parâmetros inválidos");
	            break;
	    } 
	   } while (opcao != 0); 
	}  
	   
	   //Menu inicial, a interface onde o colaborador será remanejado.
	   //Interface do Administrador do sistema, onde apenas ele terá acesso.
	   private static void exibirMenu(){
	       System.out.println("\n===SISTEMA DE PONTO ELETRÔNICO===");
	       System.out.println("1- Adicionar Usuário");
	       System.out.println("2- Listar Usuarios");
	       System.out.println("3- Atualizar Usuário");
	       System.out.println("4- Remover Usuário");
	       System.out.println("5- Sair do Programa");
	   }
	   
	   
	   //Cadastro de usuários, onde será colocadas as informações como: Nome, cpf, cargo e Id.
	   //O Id deve ser um número inteiro e sem repetição. Cada colaborador terá seu Id próprio.
	    private static void cadastrarUsuario(){
	       System.out.println("===NOVO CADASTRO===");
	        try{
	            System.out.println("Insira seu ID (Número Inteiro): ");
	            int id = Integer.parseInt(scanner.nextLine());
	            
	                if (buscarId(id) != null){
	                    System.out.println("Usuário já Cadastrado");
	                    return;
	                }
	            System.out.println("Insira seu nome Completo: ");
	                String nome = scanner.nextLine();
	                
	           System.out.println("Insira seu email: ");
	                String email = scanner.nextLine();
	                
	           System.out.println("Insira seu CPF: ");
	                String cpf = scanner.nextLine();
	                
	           System.out.println("Insira seu Cargo: ");
	                String cargo = scanner.nextLine();
	                
	            Usuario novoUsuario = new Usuario(id, nome, email, cpf, cargo);
	                listaUsuarios.add(novoUsuario);
	                System.out.println("Usuário Cadastrado com Sucesso!");
	        } catch (NumberFormatException e) {
	            System.out.println("Erro: ID Inválido");
	     }
	   }
	   
	   
	   //Lista de usuarios, onde o administrador poderá ter controle dos dados.
	   //Ele poderá analisar colaboradores que estão ativos e inativos.
	   private static void listarUsuarios(){
	       System.out.println("===LISTA DE USUÁRIOS===");
	            if (listaUsuarios.isEmpty()){
	                System.out.println("Nenhum Usuário Cadastrado");
	            } else {
	                for (Usuario u : listaUsuarios) {
	                    System.out.println(u);
	           }
	       }       
	   }
	   
	   private static void atualizarUsuario(){
	       System.out.println("===ATUALIZAR USUÁRIO===");
	       System.out.println("Informe o ID do usuário: ");
	        try{
	            int id = Integer.parseInt(scanner.nextLine());
	            Usuario usuario = buscarId(id);
	            
	                if (usuario != null){
	                    System.out.println("Usuario encontrado: " + usuario.getNome());
	                    System.out.print("Novo Nome (Deixe em vazio caso não altere): ");
	                    String novoNome = scanner.nextLine();
	                    if (!novoNome.isEmpty()) usuario.setNome();
	                    
	                    System.out.println("Novo Email: ");
	                    String novoEmail = scanner.nextLine();
	                    if (!novoEmail.isEmpty()) usuario.setEmail();
	                    
	                    System.out.println("Novo Cargo: ");
	                    String novoCargo = scanner.nextLine();
	                    if (!novoCargo.isEmpty()) usuario.setCargo();
	                    
	                    System.out.println("CADASTRO ATUALIZADO COM SUCESSO!");
	                } else{
	                    System.out.println("Erro! ID" + id + "Não encontrado");
	                }
	            }catch (NumberFormatException e){
	                System.out.println("Erro: ID inválido");   
	         }
	   }
	   
	   
	   private static void removerUsuario(){
	       System.out.println("===REMOVER USUÁRIO===");
	       System.out.println("Insira o ID do usuário: ");
	        try{
	            int id = Integer.parseInt(scanner.nextLine());
	            Usuario usuario = buscarId(id);
	            
	                if (usuario != null){
	                    listaUsuarios.remove(usuario);
	                    System.out.println("USUARIO REMOVIDO DO SISTEMA!");
	                }else {
	                    System.out.println("Erro! ID" + id + "Não encontrado");
	                }
	                }catch (NumberFormatException e){
	                    System.out.println("ID inválido!");
	             }
	        }    
}
