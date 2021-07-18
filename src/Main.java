public class Main {
    public static void main(String[] args) {
        Connect4 game1 = new Connect4();
        Players p1 = new Players(game1);
        Players p2 = new Players(game1);
        game1.dispBoard();
        for(int i = 0; i < 21; i++){
            p1.p1();
            if (game1.endGame)
                break;
            p2.p2();
            if (game1.endGame)
                break;
        }
        if (!game1.endGame)
            System.out.println("DRAW");
    }
}
