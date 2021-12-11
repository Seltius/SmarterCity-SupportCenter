package pt.iscte.smartercity.supportcenter.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SupportMapperTest {

    private SupportMapper supportMapper;

    @BeforeEach
    public void setUp() {
        supportMapper = new SupportMapperImpl();
    }
}
