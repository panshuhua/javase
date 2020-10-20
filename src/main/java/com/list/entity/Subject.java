package com.list.entity;

public class Subject implements Cloneable{

    private String math;

    private String chinese;

    private Score score;

    public String getMath() {
        return math;
    }

    public void setMath(String math) {
        this.math = math;
    }

    public String getChinese() {
        return chinese;
    }

    public void setChinese(String chinese) {
        this.chinese = chinese;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Subject s=(Subject)super.clone();
        return s;
    }
}
