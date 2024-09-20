package org.example.student;

public class Student implements Printable {
    private String studentName;
    private int recordBookNum;
    private int avgScore;

    public Student() {
    }

    public Student(String studentName, int recordBook, int avgScore){
        this.studentName = studentName;
        this.recordBookNum = recordBook;
        this.avgScore = avgScore;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getRecordBookNum() {
        return recordBookNum;
    }

    public void setRecordBookNum(int recordBookNum) {
        this.recordBookNum = recordBookNum;
    }

    public int getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(int avgScore) {
        this.avgScore = avgScore;
    }

    @Override
    public void print(){
        System.out.println("Student's name is " + this.studentName);
        System.out.println("Student's record book number: " + this.recordBookNum);
        System.out.println("Student's average score is " + this.avgScore);
    }

}
