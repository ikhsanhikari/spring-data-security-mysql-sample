package id.hikari.security.training.hikarisecurity.mapper;

import id.hikari.security.training.hikarisecurity.data.dto.request.RequestShortAnswerDTO;
import id.hikari.security.training.hikarisecurity.data.dto.response.ResponseShortAnswerDTO;
import id.hikari.security.training.hikarisecurity.data.model.ShortAnswer;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ShortAnswerMapper extends BaseMapper<ShortAnswer,RequestShortAnswerDTO> {

    @Override
    public ShortAnswer convert(RequestShortAnswerDTO source){
        ShortAnswer result = new ShortAnswer();
        result.setQuestion(source.getQuestion());
        result.setQuestionLevel(source.getQuestionLevel());
        result.setShortAnswer(source.getShortAnswer());
        result.setStatus(1);
        result.setCreatedAt(new Date());
        result.setUpdatedAt(new Date());
        result.setCreatedBy("hikari29");
        result.setUpdatedBy("hikariikhsan");
        return result;
    }


    public ResponseShortAnswerDTO reverse(ShortAnswer source) {
        ResponseShortAnswerDTO result = new ResponseShortAnswerDTO();
        result.setId(source.getId());
        result.setQuestion(source.getQuestion());
        result.setQuestionLevel(source.getQuestionLevel());
        result.setShortAnswer(source.getShortAnswer());
        result.setCreatedAt(source.getCreatedAt());
        result.setCreatedBy(source.getCreatedBy());
        result.setStatus(source.getStatus());
        result.setUpdatedAt(source.getCreatedAt());
        result.setUpdatedBy(source.getUpdatedBy());
        return result;
    }
}
