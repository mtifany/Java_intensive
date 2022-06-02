package edu.school21.chat.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Message {

    private Long     messageId;
    private User    messageAuthor;
    private Room    messageRoom;
    private String  text;
    private LocalDateTime date;

    public Message(Long messageId, User messageAuthor, Room massageRoom, String text, LocalDateTime date) {
        this.messageId = messageId;
        this.messageAuthor = messageAuthor;
        this.messageRoom = massageRoom;
        this.text = text;
        this.date = date;
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public User getMessageAuthor() {
        return messageAuthor;
    }

    public void setMessageAuthor(User messageAuthor) {
        this.messageAuthor = messageAuthor;
    }

    public Room getMassageRoom() {
        return messageRoom;
    }

    public void setMassageRoom(Room massageRoom) {
        this.messageRoom = massageRoom;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
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
