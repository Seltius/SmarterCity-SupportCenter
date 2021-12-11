package pt.iscte.smartercity.supportcenter.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import pt.iscte.smartercity.supportcenter.web.rest.TestUtil;

class RefundTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Refund.class);
        Refund refund1 = new Refund();
        refund1.setId(1L);
        Refund refund2 = new Refund();
        refund2.setId(refund1.getId());
        assertThat(refund1).isEqualTo(refund2);
        refund2.setId(2L);
        assertThat(refund1).isNotEqualTo(refund2);
        refund1.setId(null);
        assertThat(refund1).isNotEqualTo(refund2);
    }
}
