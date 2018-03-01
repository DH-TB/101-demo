package com.example;

import com.example.entity.Category;
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
public class CategoryBase {

    @Autowired
    WebApplicationContext wac;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private FlywayServiceTest flywayServiceTest;
    private static boolean initialized = false;

    @Before
    public void setup() throws Exception {
        if (!initialized) {
            flywayServiceTest.migrateDatabase();
            initCategory();
            initialized = true;
        }
        RestAssuredMockMvc.webAppContextSetup(wac);
    }
    private void initCategory() {
        categoryRepository.save(new Category((long) 1, "饮料"));
        categoryRepository.save(new Category((long) 2, "饮料"));
    }
}
