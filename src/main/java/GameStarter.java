public class GameStarter {
    public static void main(String[] args) {

        MessageManager messageManager = new MessageManager();
        messageManager.showStartMessage();
        int level = messageManager.askLevel();

        WordLength wordLength;

        int roundNumber = 1;
        Round round;
        do {
            switch (level) {
                case 2 -> wordLength = WordLength.MIDDLE;
                case 3 -> wordLength = WordLength.LARGE;
                default -> wordLength = WordLength.SMALL;
            }

            round = new Round(wordLength);

            messageManager.showRoundNumber(roundNumber);
            round.start();

            if (round.isWinner()) {
                roundNumber++;
                if (round.getWordLength().equals(WordLength.LARGE)) break;
                level++;
            } else {
                boolean repeat = messageManager.askRepeatRound();
                if (!repeat) break;
            }
        }
        while (true);

        if (round.isWinner()) messageManager.showGameVictoryMessage();
        else messageManager.showGameOverMessage();

    }
}
