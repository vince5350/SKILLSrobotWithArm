package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class RobotMap {
    //Motors
    public DcMotor frontLftWheel = null;
    public DcMotor frontRhtWheel = null;
    public DcMotor backLftWheel  = null;
    public DcMotor backRhtWheel  = null;

    //Arm
    public Servo   armJointServo = null;
    public Servo   servoClaw          = null;


    public RobotMap(){}

    public void init(HardwareMap hwMap){

        //Define Motors for phone config file
        frontLftWheel = hwMap.dcMotor.get("Front left");
        frontRhtWheel = hwMap.dcMotor.get("Front right");
        backLftWheel  = hwMap.dcMotor.get("Back left");
        backRhtWheel  = hwMap.dcMotor.get("Back right");

        //Tell motors to run with encoders
        frontLftWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRhtWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRhtWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLftWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        //Arm
        armJointServo = hwMap.servo.get("Arm Joint");
        servoClaw = hwMap.servo.get("Claw");
        servoClaw.setDirection(Servo.Direction.REVERSE);


        //Set ZeroPowerBehavior
        frontLftWheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRhtWheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLftWheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRhtWheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }
}