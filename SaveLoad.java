package rpg;

import java.io.*;

public class SaveLoad {

    public static void salvarJogador(Player jogador, String caminho) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(caminho))) {
            out.writeObject(jogador);
            System.out.println("Jogo salvo com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar o jogo: " + e.getMessage());
        }
    }

    public static Player carregarJogador(String caminho) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(caminho))) {
            Player jogador = (Player) in.readObject();
            System.out.println("Jogo carregado com sucesso!");
            return jogador;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar o jogo: " + e.getMessage());
            return null;
        }
    }
}
