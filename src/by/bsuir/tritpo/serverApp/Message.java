package by.bsuir.tritpo.serverApp;

public class Message {
    private String login;
    private String content;

    public Message(String login, String content) {
        this.login = login;
        this.content = content;
    }

    @Override
    public String toString() {
        return login + ':' + content;
    }
}
