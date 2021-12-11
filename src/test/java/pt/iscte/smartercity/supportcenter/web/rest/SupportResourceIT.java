package pt.iscte.smartercity.supportcenter.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import pt.iscte.smartercity.supportcenter.IntegrationTest;
import pt.iscte.smartercity.supportcenter.domain.Support;
import pt.iscte.smartercity.supportcenter.repository.SupportRepository;
import pt.iscte.smartercity.supportcenter.service.dto.SupportDTO;
import pt.iscte.smartercity.supportcenter.service.mapper.SupportMapper;

/**
 * Integration tests for the {@link SupportResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class SupportResourceIT {

    private static final Integer DEFAULT_SUPPORT_ID = 1;
    private static final Integer UPDATED_SUPPORT_ID = 2;

    private static final LocalDate DEFAULT_START_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_START_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_END_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_END_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_USER_NAME = "AAAAAAAAAA";
    private static final String UPDATED_USER_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_EMAIL = "AAAAAAAAAA";
    private static final String UPDATED_EMAIL = "BBBBBBBBBB";

    private static final String DEFAULT_MESSAGE = "AAAAAAAAAA";
    private static final String UPDATED_MESSAGE = "BBBBBBBBBB";

    private static final Boolean DEFAULT_IS_REFUND = false;
    private static final Boolean UPDATED_IS_REFUND = true;

    private static final Boolean DEFAULT_IS_VALID = false;
    private static final Boolean UPDATED_IS_VALID = true;

    private static final Integer DEFAULT_REFUND_ID = 1;
    private static final Integer UPDATED_REFUND_ID = 2;

    private static final Boolean DEFAULT_IS_RESOLVED = false;
    private static final Boolean UPDATED_IS_RESOLVED = true;

    private static final String DEFAULT_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_STATUS = "BBBBBBBBBB";

    private static final String DEFAULT_SUPPORT_MESSAGE = "AAAAAAAAAA";
    private static final String UPDATED_SUPPORT_MESSAGE = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/supports";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private SupportRepository supportRepository;

    @Autowired
    private SupportMapper supportMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restSupportMockMvc;

    private Support support;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Support createEntity(EntityManager em) {
        Support support = new Support()
            .supportId(DEFAULT_SUPPORT_ID)
            .startDate(DEFAULT_START_DATE)
            .endDate(DEFAULT_END_DATE)
            .userName(DEFAULT_USER_NAME)
            .email(DEFAULT_EMAIL)
            .message(DEFAULT_MESSAGE)
            .isRefund(DEFAULT_IS_REFUND)
            .isValid(DEFAULT_IS_VALID)
            .refundId(DEFAULT_REFUND_ID)
            .isResolved(DEFAULT_IS_RESOLVED)
            .status(DEFAULT_STATUS)
            .supportMessage(DEFAULT_SUPPORT_MESSAGE);
        return support;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Support createUpdatedEntity(EntityManager em) {
        Support support = new Support()
            .supportId(UPDATED_SUPPORT_ID)
            .startDate(UPDATED_START_DATE)
            .endDate(UPDATED_END_DATE)
            .userName(UPDATED_USER_NAME)
            .email(UPDATED_EMAIL)
            .message(UPDATED_MESSAGE)
            .isRefund(UPDATED_IS_REFUND)
            .isValid(UPDATED_IS_VALID)
            .refundId(UPDATED_REFUND_ID)
            .isResolved(UPDATED_IS_RESOLVED)
            .status(UPDATED_STATUS)
            .supportMessage(UPDATED_SUPPORT_MESSAGE);
        return support;
    }

    @BeforeEach
    public void initTest() {
        support = createEntity(em);
    }

    @Test
    @Transactional
    void getAllSupports() throws Exception {
        // Initialize the database
        supportRepository.saveAndFlush(support);

        // Get all the supportList
        restSupportMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(support.getId().intValue())))
            .andExpect(jsonPath("$.[*].supportId").value(hasItem(DEFAULT_SUPPORT_ID)))
            .andExpect(jsonPath("$.[*].startDate").value(hasItem(DEFAULT_START_DATE.toString())))
            .andExpect(jsonPath("$.[*].endDate").value(hasItem(DEFAULT_END_DATE.toString())))
            .andExpect(jsonPath("$.[*].userName").value(hasItem(DEFAULT_USER_NAME)))
            .andExpect(jsonPath("$.[*].email").value(hasItem(DEFAULT_EMAIL)))
            .andExpect(jsonPath("$.[*].message").value(hasItem(DEFAULT_MESSAGE)))
            .andExpect(jsonPath("$.[*].isRefund").value(hasItem(DEFAULT_IS_REFUND.booleanValue())))
            .andExpect(jsonPath("$.[*].isValid").value(hasItem(DEFAULT_IS_VALID.booleanValue())))
            .andExpect(jsonPath("$.[*].refundId").value(hasItem(DEFAULT_REFUND_ID)))
            .andExpect(jsonPath("$.[*].isResolved").value(hasItem(DEFAULT_IS_RESOLVED.booleanValue())))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS)))
            .andExpect(jsonPath("$.[*].supportMessage").value(hasItem(DEFAULT_SUPPORT_MESSAGE)));
    }

    @Test
    @Transactional
    void getSupport() throws Exception {
        // Initialize the database
        supportRepository.saveAndFlush(support);

        // Get the support
        restSupportMockMvc
            .perform(get(ENTITY_API_URL_ID, support.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(support.getId().intValue()))
            .andExpect(jsonPath("$.supportId").value(DEFAULT_SUPPORT_ID))
            .andExpect(jsonPath("$.startDate").value(DEFAULT_START_DATE.toString()))
            .andExpect(jsonPath("$.endDate").value(DEFAULT_END_DATE.toString()))
            .andExpect(jsonPath("$.userName").value(DEFAULT_USER_NAME))
            .andExpect(jsonPath("$.email").value(DEFAULT_EMAIL))
            .andExpect(jsonPath("$.message").value(DEFAULT_MESSAGE))
            .andExpect(jsonPath("$.isRefund").value(DEFAULT_IS_REFUND.booleanValue()))
            .andExpect(jsonPath("$.isValid").value(DEFAULT_IS_VALID.booleanValue()))
            .andExpect(jsonPath("$.refundId").value(DEFAULT_REFUND_ID))
            .andExpect(jsonPath("$.isResolved").value(DEFAULT_IS_RESOLVED.booleanValue()))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS))
            .andExpect(jsonPath("$.supportMessage").value(DEFAULT_SUPPORT_MESSAGE));
    }

    @Test
    @Transactional
    void getNonExistingSupport() throws Exception {
        // Get the support
        restSupportMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }
}
