import java.util.Scanner;

public class Login { 
    //atributos
    private String username;
    private String password;

    public Login(String usernameB, String passwordB){
        this.username = usernameB;
        this.password = passwordB;
    }

    public boolean authenticate(String usernameB, String passwordB){
        return username.equals(usernameB) && password.equals(passwordB);
    }

    public static void main(String[] args){
        Login login = new Login("maria","1234");
        Scanner input = new Scanner(System.in);
        System.out.printf("Nome do usuário: ");
        String username = input.nextLine();
        System.out.printf("Senha: ");
        String password = input.nextLine();
        if(login.authenticate(username, password)){
            System.out.println("Login feito com sucesso!");
        }else{
            System.out.println("Erro no login.");
        }
    }
}
