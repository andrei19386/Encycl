package ru.skillbox.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.skillbox.model.Dialog;
import ru.skillbox.model.Message;
import ru.skillbox.response.data.DialogDto;
import ru.skillbox.response.data.MessageDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-09T10:28:01+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19 (Oracle Corporation)"
)
@Component
public class DialogMapperImpl implements DialogMapper {

    @Override
    public DialogDto DialogToDto(Dialog dialog) {
        if ( dialog == null ) {
            return null;
        }

        DialogDto.DialogDtoBuilder dialogDto = DialogDto.builder();

        dialogDto.conversationPartner( account( dialog.getConversationPartner() ) );
        dialogDto.id( dialog.getId() );
        dialogDto.unreadCount( dialog.getUnreadCount() );
        dialogDto.lastMessage( MessageToDto( dialog.getLastMessage() ) );

        return dialogDto.build();
    }

    @Override
    public MessageDto MessageToDto(Message message) {
        if ( message == null ) {
            return null;
        }

        MessageDto messageDto = new MessageDto();

        messageDto.setAuthorId( personToAccount( message.getAuthorId() ) );
        messageDto.setRecipientId( personToAccount( message.getRecipientId() ) );
        messageDto.setTime( timeToString( message.getTime() ) );
        messageDto.setId( message.getId() );
        messageDto.setStatus( message.getStatus() );
        messageDto.setMessageText( message.getMessageText() );

        return messageDto;
    }

    @Override
    public Message DtoToMessage(MessageDto messageDto) {
        if ( messageDto == null ) {
            return null;
        }

        Message message = new Message();

        message.setAuthorId( idToPerson( messageDto.getAuthorId() ) );
        message.setRecipientId( idToPerson( messageDto.getRecipientId() ) );
        message.setTime( stringToTime( messageDto.getTime() ) );
        message.setId( messageDto.getId() );
        message.setStatus( messageDto.getStatus() );
        message.setMessageText( messageDto.getMessageText() );

        return message;
    }

    @Override
    public List<DialogDto> listDialogToDto(List<Dialog> dialogs) {
        if ( dialogs == null ) {
            return null;
        }

        List<DialogDto> list = new ArrayList<DialogDto>( dialogs.size() );
        for ( Dialog dialog : dialogs ) {
            list.add( DialogToDto( dialog ) );
        }

        return list;
    }

    @Override
    public List<MessageDto> listMessageToDto(List<Message> messages) {
        if ( messages == null ) {
            return null;
        }

        List<MessageDto> list = new ArrayList<MessageDto>( messages.size() );
        for ( Message message : messages ) {
            list.add( MessageToDto( message ) );
        }

        return list;
    }
}
