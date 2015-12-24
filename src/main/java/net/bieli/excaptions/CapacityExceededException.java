package net.bieli.excaptions;

public class CapacityExceededException extends Exception {
    public CapacityExceededException(String message) {
        super(message);
    }
}
