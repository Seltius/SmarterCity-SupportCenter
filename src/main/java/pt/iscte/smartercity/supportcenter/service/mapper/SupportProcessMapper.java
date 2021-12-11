package pt.iscte.smartercity.supportcenter.service.mapper;

import org.akip.service.mapper.ProcessInstanceMapper;
import org.mapstruct.*;
import pt.iscte.smartercity.supportcenter.domain.*;
import pt.iscte.smartercity.supportcenter.service.dto.SupportProcessDTO;

/**
 * Mapper for the entity {@link SupportProcess} and its DTO {@link SupportProcessDTO}.
 */
@Mapper(componentModel = "spring", uses = { ProcessInstanceMapper.class, SupportMapper.class })
public interface SupportProcessMapper extends EntityMapper<SupportProcessDTO, SupportProcess> {
    @Mapping(target = "processInstance", source = "processInstance")
    @Mapping(target = "support", source = "support")
    SupportProcessDTO toDto(SupportProcess s);
}
