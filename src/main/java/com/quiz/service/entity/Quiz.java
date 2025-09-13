package com.quiz.service.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
public class Quiz
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    @ElementCollection
    //annotation
    private List<Integer> questionsList;
}
