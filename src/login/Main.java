package login;

import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    UsuarioDAO dao = new UsuarioDAO();
	    
	    System.out.print("Usuário: ");
        String usuario = sc.nextLine();
        System.out.print("Senha: ");
        String pass = sc.nextLine();
        
        if (dao.autenticar(usuario, pass)) {
            System.out.println("Login cadastrado com sucesso!");
        } else {
            System.out.println("Usuário ou senha inválidos.");
        }
        sc.close();
    }
}
