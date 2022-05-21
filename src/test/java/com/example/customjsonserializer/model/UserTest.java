package com.example.customjsonserializer.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class UserTest {

  @Test
  void setOtherAttributes() throws JsonProcessingException {
    /*
     * Added two additional properties city and name to user Object,
     * And added additional property location to the team object,
     * and added an unknown object activity
     *
     * They are retained during serialization and deserialization
     */

    String jsonOne =
        "{\"userObjectID\":\"sdgshgdfh\",\"team\":{\"id\":\"5456\",\"teamName\":\"team_one\",\"location\":\"germany\"},\"activity\":{\"activityId\":1,\"activittyType\":\"Running\"},\"consent\":true,\"name\":\"naveen\",\"city\":\"halifax\"}";
    ObjectMapper mapper =
        new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
    User expectedUser = mapper.readValue(jsonOne, User.class);

    String jsonTwo = mapper.writeValueAsString(expectedUser);

    User actualUser = mapper.readValue(jsonTwo, User.class);
    // Not asserting whether the jsonOne and jsonTwo are equal, as the order of the attributes is
    // different after serialization and deserialization.
    Assertions.assertThat(actualUser).isEqualTo(expectedUser);
  }
}
