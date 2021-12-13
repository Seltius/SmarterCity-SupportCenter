package pt.iscte.smartercity.supportcenter.process.refundProcess;

import org.akip.service.mapper.ProcessInstanceMapper;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pt.iscte.smartercity.supportcenter.domain.Refund;
import pt.iscte.smartercity.supportcenter.domain.RefundProcess;
import pt.iscte.smartercity.supportcenter.service.dto.RefundDTO;
import pt.iscte.smartercity.supportcenter.service.dto.RefundProcessDTO;

@Mapper(componentModel = "spring", uses = { ProcessInstanceMapper.class })
public interface FillRefundFormMapper {
    @Mapping(target = "processInstance", source = "processInstance", qualifiedByName = "loadTaskContext")
    RefundProcessDTO toRefundProcessDTO(RefundProcess refundProcess);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "amount", source = "amount")
    @Mapping(target = "method", source = "method")
    RefundDTO toRefundDTO(Refund refund);
}
