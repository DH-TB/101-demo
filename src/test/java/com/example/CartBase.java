package com.example;

import com.example.entity.Cart;
import com.example.repository.CartRepository;
import com.example.repository.CategoryRepository;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ActiveProfiles("test")
public class CartBase {

    @Autowired
    WebApplicationContext wac;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private FlywayServiceTest flywayServiceTest;
    private static boolean initialized = false;

    @Before
    public void setup() throws Exception {
        if (!initialized) {
            flywayServiceTest.migrateDatabase();
            initCart();
            initialized = true;
        }
        RestAssuredMockMvc.webAppContextSetup(wac);
    }

    private void initCart(){
        cartRepository.save(new Cart((long)1,"cart1"));
        cartRepository.save(new Cart((long)2,"cart2"));
    }
}
