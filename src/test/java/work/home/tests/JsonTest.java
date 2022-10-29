package work.home.tests;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import work.home.model.GetProfile;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonTest{
    static ClassLoader cl = JsonTest.class.getClassLoader();

    @Test
    void jsonTest(){
        InputStream is = cl.getResourceAsStream("getProfile.json");
        Gson gson = new Gson();
        GetProfile getProfile = gson.fromJson(new InputStreamReader(is), GetProfile.class);
        assertThat(getProfile.id).isEqualTo(1434654546);
        assertThat(getProfile.userInfo.name).isEqualTo("Тест");
        assertThat(getProfile.isError).isEqualTo(false);
    }
}
