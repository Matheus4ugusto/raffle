package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

@Getter
@Setter
public class Application {
    private Scanner scan;
    private List<String> lista;
    public Application(Scanner scanner){
        this.scan = scanner;
        this.lista = new ArrayList<>();
    }

    private void renderMenu(){
        System.out.println("Sorteio do Pandinhah Top Pro Max");
        System.out.println("Qtd. Nomes para sorteio: ".concat(String.valueOf(this.lista.size())));
        System.out.println("1- Cadastrar nomes;");
        System.out.println("2- Listar nomes;");
        System.out.println("3- Sortear;");
        System.out.println("0- Sair.");
        System.out.print("Escolha uma opção: ");
    }

    public void exec(){
        boolean sair = false;
        while (!sair){
            this.renderMenu();
            int opcao = this.scan.nextInt();
            this.scan.nextLine();
            sair = this.processOption(opcao);
        }

    }

    private boolean processOption(int option){
        switch (option){
            case 0:
                System.out.println("Saindo...");
                return true;
            case 1:
                this.cadastraNome();
                return false;
            case 2:
                this.listarNomes();
                return false;
            case 3:
                this.sortearNome();
                return false;
            default:
                System.out.println("Opção inválida");
                return false;
        }
    }
    private void cadastraNome(){
        System.out.print("Informe um nome: ");
        String nome = this.scan.nextLine();
        this.lista.add(nome.trim());
    }

    private void listarNomes(){
        for (String nome : this.lista){
            System.out.println(nome.toUpperCase());
        }
    }
   private void sortearNome(){
        if (this.lista.isEmpty()){
            System.out.println("Não há nomes para sorteio...");
            return;
        }
       Random random = new Random();
        int index = random.nextInt(this.lista.size());
       System.out.println("Sorteio efetuado");
       System.out.println(this.lista.get(index).toUpperCase());
       System.out.println("1- Realizar novo sorteio");
       System.out.println("2- Limpar lista");
       System.out.println("Escolha uma opção: ");

       int option = this.scan.nextInt();
       if (option == 1){
            this.lista.remove(index);
            this.sortearNome();
       }
       if(option == 2){
           this.lista.clear();
           return;
       }
   }
}
