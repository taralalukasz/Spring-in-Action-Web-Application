package spitter.web;

import org.junit.Ignore;
import org.junit.Test;
import static   org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static   org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static   org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;

public class HomeControllerTest {

    @Test
    public void home() throws Exception {
        HomeController testSubject = new HomeController();

        /** This is the way of mocking  MVC services */
        MockMvc mockMvc = standaloneSetup(testSubject).build();
        mockMvc.perform(get("/homepage")).andExpect(view().name("home"));
    }
}