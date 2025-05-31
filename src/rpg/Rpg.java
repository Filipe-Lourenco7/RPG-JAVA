package rpg;
public class Rpg {
    public static void main(String[] args) {
        String caminhoSave = "jogo.dat";

        // Criando jogador novo
        Player jogador = new Player("Hero", 1);
        jogador.getInventory().addItem("Espada", 3.5, 1);
        jogador.getInventory().addItem("Poção", 0.5, 5);
        jogador.getInventory().addItem("Escudo", 4.2, 1);

        System.out.println("🔹 Jogo atual:");
        exibirDadosJogador(jogador);

        // Salvando o jogo
        SaveLoad.salvarJogador(jogador, caminhoSave);

        System.out.println("\n--- Agora vamos carregar o jogo salvo ---\n");

        // Carregando jogador salvo
        Player jogadorCarregado = SaveLoad.carregarJogador(caminhoSave);

        if (jogadorCarregado != null) {
            System.out.println("🔸 Jogo carregado com sucesso!");
            exibirDadosJogador(jogadorCarregado);
        }
    }

    public static void exibirDadosJogador(Player jogador) {
        System.out.println("Nome: " + jogador.getName());
        System.out.println("Nível: " + jogador.getLevel());
        System.out.println("Itens no inventário:");
        jogador.getInventory().listItems();
        System.out.println("Peso total: " + jogador.getInventory().getTotalWeight() + "kg");
    }

}