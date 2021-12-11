package pt.iscte.smartercity.supportcenter.service.mapper;

import org.akip.service.mapper.ProcessInstanceMapper;
import org.mapstruct.*;
import pt.iscte.smartercity.supportcenter.domain.*;
import pt.iscte.smartercity.supportcenter.service.dto.RefundProcessDTO;

/**
 * Mapper for the entity {@link RefundProcess} and its DTO {@link RefundProcessDTO}.
 */
@Mapper(componentModel = "spring", uses = { ProcessInstanceMapper.class, RefundMapper.class })
public interface RefundProcessMapper extends EntityMapper<RefundProcessDTO, RefundProcess> {
    @Mapping(target = "processInstance", source = "processInstance")
    @Mapping(target = "refund", source = "refund")
    RefundProcessDTO toDto(RefundProcess s);
}
