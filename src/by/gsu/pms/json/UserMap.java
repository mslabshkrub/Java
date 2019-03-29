package by.gsu.pms.json;

import by.gsu.pms.entities.User;

import java.util.*;

public class UserMap {
    private static UserMap ourInstance = new UserMap();

    private static Map<Long, User> usersMap = new HashMap<>();

    private List<User> users;

    private static long id = 0;

    public static UserMap getInstance() {
        return ourInstance;
    }

    private UserMap() {
    }

    void setUsers(ArrayList<User> users) {
        this.users = users;
        for (User user : users) {
            usersMap.put(++id, user);
        }
    }

    public void addUser(User user) {
        usersMap.put(++id, user);
        users.add(user);
        JsonManipulate.serialize(users);
    }

    public void printAll() {
        if(users == null){
            JsonManipulate.deserialize();
        }
        Set<Map.Entry<Long, User>> entries = usersMap.entrySet();
        for (Map.Entry<Long, User> entry : entries){
            System.out.println(entry.getKey() + ") " + entry.getValue().getLastName() + " " + entry.getValue().getFirstName());
        }
    }

    public void deleteUser(Long id){
        User user = usersMap.get(id);
        usersMap.remove(id);
        users.remove(user);
        JsonManipulate.serialize(users);
    }

    public User getUser(long id){
        return usersMap.get(id);
    }
}
