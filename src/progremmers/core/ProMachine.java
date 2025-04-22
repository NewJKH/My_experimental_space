package progremmers.core;

import progremmers.level2.RobotDanger;

public class ProMachine {
    public void boot(){
        bootDanger();
    }
    private void bootDanger(){
        new RobotDanger().start();
//        new RobotDanger2().start();
    }
}
