package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class Room {

    private Long roomID;
    private String roomName;
    private User roomCreator;
    private List<Message> list;

    public Room(Long roomID, String roomName, User roomCreator, List<Message> list) {
        this.roomID = roomID;
        this.roomName = roomName;
        this.roomCreator = roomCreator;
        this.list = list;
    }

    public Long getRoomID() {
        return roomID;
    }

    public void setRoomID(Long roomID) {
        this.roomID = roomID;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public User getRoomCreator() {
        return roomCreator;
    }

    public void setRoomCreator(User roomCreator) {
        this.roomCreator = roomCreator;
    }

    public List<Message> getList() {
        return list;
    }

    public void setList(List<Message> list) {
        this.list = list;
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
        return "Room{" +
                "roomID=" + roomID +
                ", roomName='" + roomName + '\'' +
                ", roomCreator=" + roomCreator +
                ", list=" + list +
                '}';
    }
}
