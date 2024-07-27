package org.game.view.io;

public class ConsoleMessageSender implements MessageSender {
    private final OutputWriter writer;

    public ConsoleMessageSender(OutputWriter writer) {
        this.writer = writer;
    }

    @Override
    public void sendMessage(String message) {
        writer.writeLine(message);
    }

    @Override
    public void sendMessage(String message, int num) {
        writer.writeString(String.format("%s %d\n", message, num));
    }
}
