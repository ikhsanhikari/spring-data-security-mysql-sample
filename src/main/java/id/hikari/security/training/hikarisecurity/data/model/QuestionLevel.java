package id.hikari.security.training.hikarisecurity.data.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@Table(name = "question_level")
@Entity
public class QuestionLevel implements Serializable {
    private static final long serialVersionUID = -3470859003263290613L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "question_level")
    private String questionLevel;
}
