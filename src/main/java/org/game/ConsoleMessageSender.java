package org.game;

public class ConsoleMessageSender extends MessageSender {
    @Override
    public void sendMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void sendMessage(String message, int num) {
        System.out.printf("%s %d\n", message, num);
    }
}
