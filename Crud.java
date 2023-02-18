import java.util.Scanner;

public class Crud {
    
    private static String[] nomes;
    private static int[] idades;
    private static int numRegistros;

    public Crud(){
        nomes = new String[100];
        idades = new int[100];
        numRegistros = 0;
    }
    
    public static void Cadastrar(){
        Scanner input = new Scanner(System.in);
        System.out.printf("Insira o nome: ");
        String nome = input.nextLine();
        System.out.printf("Insira a idade: ");
        int idade = input.nextInt();
        nomes[numRegistros] = nome;
        idades[numRegistros] = idade;
        numRegistros++;
        System.out.println("Registro cadastrado!");
        Listar();
    }

    public static void Listar(){
        if(numRegistros == 0){
            System.out.println("Não há registros cadastrados.");
            return;
        }
        for(int i=0; i<numRegistros; i++){
            System.out.println("Nomes: "+nomes[i]+" Idades: "+idades[i]);
        }
    }

    public static void Alterar(){
        if(numRegistros == 0){
            System.out.println("Não há registros cadastrados.");
            return;
        }
        Scanner input = new Scanner(System.in);
        System.out.printf("Insira o nome: ");
        String nomeBusca = input.nextLine();
        int index = -1;
        for(int i=0; i<numRegistros; i++){
            if(nomes[i].equals(nomeBusca)){
                index = i;
                break;
            }
        }
        if(index == -1){
            System.out.println("Registro não encontrado.");
            return;
        }
        System.out.printf("Novo nome: ");
        String novoNome = input.nextLine();
        System.out.printf("Nova idade: ");
        int novaIdade = input.nextInt();
        nomes[index] = novoNome;
        idades[index] = novaIdade;
        System.out.println("Registros alterados.");
    }

    public static void Excluir(){
        if(numRegistros == 0){
            System.out.println("Não há registros cadastrados.");
            return;
        }
        Scanner input = new Scanner(System.in);
        System.out.printf("Informe o nome que deseja excluir: ");
        String nomeBusca = input.nextLine();
        int index = -1;
        for(int i=0; i<numRegistros; i++){
            if(nomes[i].equals(nomeBusca)){
                index = i;
                break;
            }
        }
        if(index == -1){
            System.out.println("Registro não encontrado.");
            return;
        }
        for(int i=index; i<numRegistros-1; i++){
            nomes[i] = nomes[i+1];
            idades[i] = idades[i+1];
        }
        numRegistros--;
        System.out.println("Registro excluído com sucesso!");
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Crud crud = new Crud();
        while(true){
            System.out.println("Selecione uma opção:");
            System.out.println("0 - Sair");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Alterar");
            System.out.println("4 - Excluir");
            int opcao = input.nextInt();
            switch(opcao){
                case 0:
                break;
                case 1:
                Cadastrar();
                break;
                case 2:
                Listar();
                break;
                case 3:
                Alterar();
                break;
                case 4:
                Excluir();
                break;
            }
        }
    }
}
