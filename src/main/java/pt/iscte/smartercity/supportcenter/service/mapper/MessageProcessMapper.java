package pt.iscte.smartercity.supportcenter.service.mapper;

import org.akip.service.mapper.ProcessInstanceMapper;
import org.mapstruct.*;
import pt.iscte.smartercity.supportcenter.domain.*;
import pt.iscte.smartercity.supportcenter.service.dto.MessageProcessDTO;

/**
 * Mapper for the entity {@link MessageProcess} and its DTO {@link MessageProcessDTO}.
 */
@Mapper(componentModel = "spring", uses = { ProcessInstanceMapper.class, MessageMapper.class })
public interface MessageProcessMapper extends EntityMapper<MessageProcessDTO, MessageProcess> {
    @Mapping(target = "processInstance", source = "processInstance")
    @Mapping(target = "message", source = "message")
    MessageProcessDTO toDto(MessageProcess s);
}
