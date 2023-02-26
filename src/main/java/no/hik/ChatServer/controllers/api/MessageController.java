package no.hik.ChatServer.controllers.api;

import no.hik.ChatServer.db.models.MessageModel;
import no.hik.ChatServer.models.MessageThreadModel;
import no.hik.ChatServer.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MessageController {
    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "/api/messages/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MessageThreadModel>> getMessages(@PathVariable Integer userId) {

        List<MessageModel> messageModelsResponse = messageService.getAllByUserId(userId);

        List<MessageThreadModel> messageThreadModelModelList = new ArrayList<MessageThreadModel>();

        if (messageModelsResponse.size() > 0) {
            for (MessageModel messageModel : messageModelsResponse) {
                String messageModelThreadId = messageModel.getThreadId();
                var existingMessageThreadResponse = messageThreadModelModelList.stream()
                        .filter(mt -> messageModelThreadId.equals(mt.getThreadId()));

                var numberOfThreadResults = existingMessageThreadResponse.count();
                if (numberOfThreadResults > 0) {
                    List<MessageThreadModel> existingMessageThreadModelList = messageThreadModelModelList.stream().toList();
                    MessageThreadModel existingMessageThreadModel = existingMessageThreadModelList.stream().filter(mt -> messageModelThreadId.equals(mt.getThreadId())).findFirst().get();
                    var existingMessageThreadMessages = existingMessageThreadModel.getMessages();
                    existingMessageThreadMessages.add(messageModel);

                    for (var i = 0; i < existingMessageThreadModelList.size(); i++) {
                        var currentThread = existingMessageThreadModelList.get(i);
                        var currentThreadThreadId = currentThread.getThreadId();
                        if (messageModel.getThreadId().equals(currentThread.getThreadId())) {
                            currentThread.setMessages(existingMessageThreadMessages);
                        }
                    }
                } else {
                    MessageThreadModel newMessageThreadModel = new MessageThreadModel();
                    List<MessageModel> messages = new ArrayList<MessageModel>();
                    messages.add(messageModel);
                    newMessageThreadModel.setThreadId(messageModelThreadId);
                    newMessageThreadModel.setMessages(messages);

                    messageThreadModelModelList.add(newMessageThreadModel);
                }
            }
        }

        return ResponseEntity.ok(messageThreadModelModelList);
    }
}
