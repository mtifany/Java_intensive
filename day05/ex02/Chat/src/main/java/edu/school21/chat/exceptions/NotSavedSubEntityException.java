package edu.school21.chat.exceptions;

public class NotSavedSubEntityException extends Exception {

    @Override
    public void printStackTrace() {
        System.err.println("Cannot save Message");
    }

}
