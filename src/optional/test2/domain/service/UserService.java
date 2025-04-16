package optional.test2.domain.service;

import optional.test2.repository.UserRepository;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addMoneyByUserId(int userId, double amount){
        userRepository.getUser(userId)
                .ifPresentOrElse(
                        user -> user.setAccount(user.getAccount()+amount),
                        ()->System.out.println(" 존재하지 않는 회원입니다. ")
                );
    }

    public void removeMoneyByUserId(int userId, double amount){
        userRepository.getUser(userId)
                .ifPresentOrElse(
                        user -> {
                            if ( user.getAccount()>= amount){
                                user.setAccount(user.getAccount()-amount);
                                System.out.println("계좌에서 출금되었습니다: "+amount);
                            }else{
                                System.out.println("잔액이 부족합니다.");
                            }
                        },
                        ()->System.out.println(" 존재하지 않는 회원입니다. ")
                );
    }

    public void setMoneyByUserId(int userId, double amount){
        userRepository.getUser(userId)
                .ifPresentOrElse(
                        user -> user.setAccount(amount),
                        ()->System.out.println(" 존재하지 않는 회원입니다. ")
                );
    }

    public void printMoney(int userId){
        userRepository.getUser(userId)
                .ifPresentOrElse(
                        user-> System.out.println(" 현재잔액 : "+user.getAccount()),
                        ()->System.out.println(" 존재하지 않는 회원입니다.")
                );
    }
}
