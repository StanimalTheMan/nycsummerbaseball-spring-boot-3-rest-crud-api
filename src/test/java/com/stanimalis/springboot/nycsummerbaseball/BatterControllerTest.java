package com.stanimalis.springboot.nycsummerbaseball;

import com.stanimalis.springboot.nycsummerbaseball.entity.Batter;
import com.stanimalis.springboot.nycsummerbaseball.rest.BatterRestController;
import com.stanimalis.springboot.nycsummerbaseball.service.BatterService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = BatterRestController.class)
@WithMockUser
public class BatterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BatterService batterService;

    Batter mockBatter = new Batter("Pablo", "Sanchez", 0.500, (short) 73, (short) 150, 2.154);

    @Test
    public void retrieveDetailsForBatter() throws Exception {
        Mockito.when(batterService.findById(Mockito.anyInt())).thenReturn(mockBatter);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/api/batters/1"
        );

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());
        String expected = "{\"firstName\":\"Pablo\",\"lastName\":\"Sanchez\",\"avg\":0.5}";

        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }
}
