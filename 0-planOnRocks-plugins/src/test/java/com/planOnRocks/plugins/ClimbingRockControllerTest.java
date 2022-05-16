package com.planOnRocks.plugins;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.planOnRocks.adapters.climbingRock.ClimbingRockDTO;
import com.planOnRocks.application.climbingRock.ClimbingRockService;
import com.planOnRocks.domain.climbingRock.ClimbingRock;
import com.planOnRocks.domain.climbingRock.enums.Bolting;
import com.planOnRocks.domain.climbingRock.enums.Difficulty;
import com.planOnRocks.domain.climbingRock.valueObjects.Location;
import com.planOnRocks.plugins.climbingRock.rest.ClimbingRockController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = com.planOnRocks.plugins.PlanOnRocksApplication.class)
@AutoConfigureMockMvc
public class ClimbingRockControllerTest {

    private static final String LOCATION = "48.68984755044936, 8.362811253038053";
    private static final String NAME = "Gausbach";

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ClimbingRockController climbingRockController;

    @MockBean
    ClimbingRockService climbingRockService;

    @Autowired
    private ObjectMapper objectMapper;

    private ClimbingRockDTO climbingRockDTO;

    @BeforeEach
    void init() {
        this.climbingRockDTO = new ClimbingRockDTO(LOCATION, NAME, Difficulty.EASY, Bolting.VERY_GOOD);
    }

    @Test
    void createClimbingRock() throws Exception {
        doReturn(climbingRockDTO).when(climbingRockController).createClimbingRock(climbingRockDTO);
        MvcResult mvcResult = this.mockMvc.perform(post("/climbingRock/")
                                           .content(this.objectMapper.writeValueAsString(climbingRockDTO))
                                           .contentType(MediaType.APPLICATION_JSON))
                                            .andExpect(status().isOk()).andReturn();
        String responseBody = mvcResult.getResponse().getContentAsString();
        ClimbingRock responseClimbingRock = this.objectMapper.reader().forType(ClimbingRock.class).readValue(responseBody);
        assertEquals(climbingRockDTO.getName(), responseClimbingRock.getName());
    }
}
