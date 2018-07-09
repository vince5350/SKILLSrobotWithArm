package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.Servo;

//import org.firstinspires.ftc.teamcode.main;

public class RobotArm {
    private Servo servoClaw, servoJoint = null;

    //static private final int ENCODER_DEGREE = (360/1680);
    //private main source = new main();


    public RobotArm(Servo servoClaw,
                    Servo servoJoint){
        this.servoClaw = servoClaw;
        this.servoJoint = servoJoint;

    }

    //Controls the claw
    public void claw(double clawAngle){
        this.servoClaw.setPosition(clawAngle);
    }

    public void joint(double jointAngle){
        this.servoJoint.setPosition(jointAngle);
    }
}