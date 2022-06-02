package edu.school21.chat.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message {

    private Integer     messageId;
    private User    messageAuthor;
    private Room    messageRoom;
    private String  text;
    private LocalDate date;

    public Message(Integer messageId, User messageAuthor, Room massageRoom, String text, LocalDate date) {
        this.messageId = messageId;
        this.messageAuthor = messageAuthor;
        this.messageRoom = massageRoom;
        this.text = text;
        this.date = date;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public User getMessageAuthor() {
        return messageAuthor;
    }

    public void setMessageAuthor(User messageAuthor) {
        this.messageAuthor = messageAuthor;
    }

    public Room getMessageRoom() {
        return messageRoom;
    }

    public void setMessageRoom(Room messageRoom) {
        this.messageRoom = messageRoom;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", messageAuthor=" + messageAuthor +
                ", massageRoom=" + messageRoom +
                ", text='" + text + '\'' +
                ", date=" + date + date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))
                + '}';
    }
}
