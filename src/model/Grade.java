package model;

public class Grade {
    private String subject;
    private double score;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Grade(String subject, double score) {
        this.subject = subject;
        this.score = score;
    }
}
