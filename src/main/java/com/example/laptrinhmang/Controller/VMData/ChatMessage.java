package com.example.laptrinhmang.Controller.VMData;

public class ChatMessage {

    private int index;
    private String content;
    private String sender;

    public ChatMessage() {
    }

    public ChatMessage(String content ) {
        this.content = content;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

}