package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class User {

    private Integer userID;
    private String name;
    private String password;
    private List<Room> createdRooms;
    private List<Room> rooms;

    public User(Integer userID, String name, String password, List<Room> userCreatedList, List<Room> rooms) {
        this.userID = userID;
        this.name = name;
        this.password = password;
        this.createdRooms = userCreatedList;
        this.rooms = rooms;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Room> getCreatedRooms() {
        return createdRooms;
    }

    public void setCreatedRooms(List<Room> createdRooms) {
        this.createdRooms = createdRooms;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userID == user.userID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, name, password, createdRooms, rooms);
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", createdRooms=" + createdRooms +
                ", rooms=" + rooms +
                '}';
    }
}
