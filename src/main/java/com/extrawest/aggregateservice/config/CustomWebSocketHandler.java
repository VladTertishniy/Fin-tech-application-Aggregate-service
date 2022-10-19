package com.extrawest.aggregateservice.config;

import com.extrawest.aggregateservice.CustomLocalDateTimeDeserializer;
import com.extrawest.aggregateservice.exception.ApiRequestException;
import com.extrawest.aggregateservice.model.AggregationSendingOperation;
import com.extrawest.aggregateservice.model.Operator;
import com.extrawest.aggregateservice.model.SellPoint;
import com.extrawest.aggregateservice.repository.OperatorRepository;
import com.extrawest.aggregateservice.repository.SellPointRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class CustomWebSocketHandler extends AbstractWebSocketHandler {

    private final SellPointRepository sellPointRepository;
    private final OperatorRepository operatorRepository;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {

    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        JSONObject messageJsonObject = new JSONObject(message.getPayload().toString());
        AggregationSendingOperation aggregationSendingOperation = messageJsonObject.getEnum(
                AggregationSendingOperation.class, "aggregationSendingOperation"
        );
        if (AggregationSendingOperation.SELL_POINT_CREATED.equals(aggregationSendingOperation)
                || AggregationSendingOperation.SELL_POINT_UPDATED.equals(aggregationSendingOperation)) {
            SellPoint sellPoint = getSellPointFromJson(messageJsonObject);
            sellPointRepository.save(sellPoint);
        } else if (AggregationSendingOperation.SELL_POINT_DELETED.equals(aggregationSendingOperation)) {
            SellPoint sellPoint = getSellPointFromJson(messageJsonObject);
            sellPointRepository.deleteSellPoint(sellPoint.getId());
        } else if (AggregationSendingOperation.OPERATOR_CREATED.equals(aggregationSendingOperation) ||
                AggregationSendingOperation.OPERATOR_UPDATED.equals(aggregationSendingOperation)) {
            Operator operator = getOperatorFromJson(messageJsonObject);
            operatorRepository.save(operator);
        } else if (AggregationSendingOperation.OPERATOR_DELETED.equals(aggregationSendingOperation)) {
            Operator operator = getOperatorFromJson(messageJsonObject);
            operatorRepository.deleteOperator(operator.getId());
        } else throw new ApiRequestException("Incorrect AggregationSendingOperation value: " + aggregationSendingOperation);
    }

    private SellPoint getSellPointFromJson(JSONObject messageJsonObject) {
        Gson gson = new Gson();
//        SellPoint sellPoint = gson.fromJson(gson.toJson(aggregationSendingContainer.getObject()), SellPoint.class);
        return gson.fromJson(messageJsonObject.getJSONObject("object").toString(), SellPoint.class);
    }

    private Operator getOperatorFromJson(JSONObject messageJsonObject) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new CustomLocalDateTimeDeserializer());

        Gson gson = gsonBuilder.setPrettyPrinting().create();
        return gson.fromJson(messageJsonObject.getJSONObject("object").toString(), Operator.class);
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {

    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {

    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
