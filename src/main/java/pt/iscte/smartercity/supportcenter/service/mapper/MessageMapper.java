package pt.iscte.smartercity.supportcenter.service.mapper;

import org.mapstruct.*;
import pt.iscte.smartercity.supportcenter.domain.*;
import pt.iscte.smartercity.supportcenter.service.dto.MessageDTO;

/**
 * Mapper for the entity {@link Message} and its DTO {@link MessageDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface MessageMapper extends EntityMapper<MessageDTO, Message> {}
