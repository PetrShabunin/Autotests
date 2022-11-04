package work.home.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import work.home.model.GetProfile;
import work.home.model.GetProfileJsonReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonTest {
    static ClassLoader cl = JsonTest.class.getClassLoader();
    //Jackson библиотека
    @Test
    void jsonTestWithJackson() throws Exception {
        InputStream inputStream = cl.getResourceAsStream("getProfile.json");
        ObjectMapper objectMapper = new ObjectMapper();
        //objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        GetProfileJsonReader.GetProfileBody getProfileBody = objectMapper.readValue(inputStream, GetProfileJsonReader.GetProfileBody.class);
        assertThat(GetProfileJsonReader.GetProfileBody.getId()).isEqualTo(4212314);
        assertThat(GetProfileJsonReader.GetProfileBody.getLogin()).isEqualTo("test");
        assertThat(GetProfileJsonReader.UserInfo.getName()).isEqualTo("Тест");
    }
}

