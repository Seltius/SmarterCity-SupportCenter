package pt.iscte.smartercity.supportcenter.service.mapper;

import org.mapstruct.*;
import pt.iscte.smartercity.supportcenter.domain.*;
import pt.iscte.smartercity.supportcenter.service.dto.RefundDTO;

/**
 * Mapper for the entity {@link Refund} and its DTO {@link RefundDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface RefundMapper extends EntityMapper<RefundDTO, Refund> {}
