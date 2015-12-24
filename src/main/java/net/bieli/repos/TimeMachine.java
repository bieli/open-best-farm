package net.bieli.repos;

public interface TimeMachine {
    public Integer getSecondsToEnd();
    public Integer tick();
    public void start();
}
