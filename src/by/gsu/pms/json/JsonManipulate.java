package by.gsu.pms.json;

import by.gsu.pms.entities.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

class JsonManipulate {
    private static UserMap userList = UserMap.getInstance();

    static void serialize(List<User> users) {
        try (Writer writer = new FileWriter("src/by/gsu/pms/json/data/user.json")) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(users, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void deserialize() {
        try (FileReader userReader = new FileReader("src/by/gsu/pms/json/data/user.json")){
            userList.setUsers(new Gson().fromJson(userReader,
                    new TypeToken<ArrayList<User>>() {
                    }.getType()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
