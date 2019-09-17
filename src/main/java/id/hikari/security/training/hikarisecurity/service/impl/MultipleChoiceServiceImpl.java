package id.hikari.security.training.hikarisecurity.service.impl;

import id.hikari.security.training.hikarisecurity.dao.AnswerDAO;
import id.hikari.security.training.hikarisecurity.dao.QuestionAnswerDAO;
import id.hikari.security.training.hikarisecurity.dao.QuestionDAO;
import id.hikari.security.training.hikarisecurity.data.dto.response.JsonWrapper;
import id.hikari.security.training.hikarisecurity.data.dto.response.ResponseAnswerDTO;
import id.hikari.security.training.hikarisecurity.data.dto.response.ResponseQuestionDTO;
import id.hikari.security.training.hikarisecurity.data.model.Answer;
import id.hikari.security.training.hikarisecurity.data.model.Question;
import id.hikari.security.training.hikarisecurity.service.MultipleChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MultipleChoiceServiceImpl implements MultipleChoiceService {

    @Autowired
    private QuestionDAO questionDAO;

    @Autowired
    private AnswerDAO answerDAO;

    @Autowired
    private QuestionAnswerDAO questionAnswerDAO;

    @Override
    public ResponseEntity selectAll() {
        List<ResponseQuestionDTO> result = new ArrayList<>();
        List<Question> questions = questionDAO.findAll();


        for (Question question: questions){

            List<ResponseAnswerDTO> answerDTOS = new ArrayList<>();
            ResponseQuestionDTO questionDTO = new ResponseQuestionDTO();
            questionDTO.setId(question.getId());
            questionDTO.setQuestionLevel(question.getQuestionLevel());
            questionDTO.setQuestionType(question.getQuestionType());
            questionDTO.setQuestion(question.getQuestion());
            List<Answer> answers  = answerDAO.findAnswerByQuestion(question.getId());

            for (Answer answer : answers) {
                ResponseAnswerDTO answerDTO = new ResponseAnswerDTO();
                answerDTO.setId(answer.getId());
                answerDTO.setAnswer(answer.getAnswer());
                answerDTO.setVariable(answer.getVariable());
                answerDTO.setStatus(answer.getStatus());
                answerDTOS.add(answerDTO);
            }
            questionDTO.setAnswers(answerDTOS);

            result.add(questionDTO);

        }


        return ResponseEntity.ok(new JsonWrapper(result.size(),"find all", HttpStatus.OK,result));
    }
}
