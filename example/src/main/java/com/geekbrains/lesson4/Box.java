package com.geekbrains.lesson4;

public class Box {
    private Integer ballsCounter;

    public Box() {
        this.ballsCounter = 0;
    }

    public Integer getBallsCounter() {
        return ballsCounter;
    }

    public void setBallsCounter(Integer ballsCounter) {
        this.ballsCounter = ballsCounter;
    }
    public void shuffleBalls() throws BoxIsEmptyException {
        if (ballsCounter > 2) {
            System.out.println("Мячи перемешаны");
        } else {
            throw new BoxIsEmptyException();
        }
    }
    public void addBall() {
        ballsCounter++;
    }
    public void removeBall() {
        if (ballsCounter == 0) {
            throw new NullPointerException();
        }
        ballsCounter--;
    }
}
