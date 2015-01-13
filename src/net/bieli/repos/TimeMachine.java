package net.bieli.repos;

public interface TimeMachine {
    public Integer getSecondsToEnd();
    public void tick();
    public void start();
}
