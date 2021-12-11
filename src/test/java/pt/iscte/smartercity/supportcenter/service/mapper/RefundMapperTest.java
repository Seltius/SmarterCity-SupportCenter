package pt.iscte.smartercity.supportcenter.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RefundMapperTest {

    private RefundMapper refundMapper;

    @BeforeEach
    public void setUp() {
        refundMapper = new RefundMapperImpl();
    }
}
