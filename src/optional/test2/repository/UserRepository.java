package optional.test2.repository;

import optional.test2.domain.user.User;

import java.util.*;

public class UserRepository {
    /**
     * 유저 데이터 모음
     */
    private final Map<Integer, User> users;

    public UserRepository() {
        users = new HashMap<>();
        users.put(1,new User(1,10000));
        users.put(2,new User(2,10000));
        users.put(3,new User(3,10000));
        users.put(4,new User(4,10000));
        users.put(5,new User(5,10000));
        users.put(6,new User(6,10000));
        users.put(7,new User(7,10000));
    }

    public Optional<User> getUser(int userId) {
        return Optional.ofNullable(users.get(userId));
    }


    public List<User> findAll(){
        return new ArrayList<>(users.values());
    }

    public void addUser(int userId, User user){
        users.put(userId,user);
    }

    public void removeUser(int userId){
        users.remove(userId);
    }

}
