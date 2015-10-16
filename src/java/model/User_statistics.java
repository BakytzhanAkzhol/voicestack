/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;



import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 *
 * @author bako
 */
@Entity
@Table(name="user_statistics")
public class User_statistics {
    @Column(name="user_id")
    int user_id;
    
    @Column(name="question_id")
    int question_id;
    
    @Column(name="answer")
    int answer;
    
    @Column(name="score")
    int score;
    
    @Column(name="visit_time")
    int visit_time;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getVisit_time() {
        return visit_time;
    }

    public void setVisit_time(int visit_time) {
        this.visit_time = visit_time;
    }
    
    
}
