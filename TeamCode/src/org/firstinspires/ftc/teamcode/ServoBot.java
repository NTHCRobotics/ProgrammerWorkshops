package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

//USE ARMBOT FOR THIS PROGRAM; NOT MECANUMBOT!!!
@TeleOp(name="ServoBot", group="Roboxolotls")
public class ServoBot extends OpMode {

    //Declare your Servo; this is the same as declaring a DcMotor(Ex)!
    private Servo clawServo;

    @Override
    public void init(){
        //Give your variable a corresponding servo to interact with!
        clawServo = hardwareMap.get(Servo.class, "hand_servo");

        //YOU CAN ALSO DO IT AS SHOWN BELOW!!! THERE'S, LIKE, 1000000000 WAYS...
        // This one just declares both the variable and the device at once in init!
        Servo otherClawServo = hardwareMap.get(Servo.class, "hand_servo");

        //This one does the same as the one above, but uses a different hardwareMap format
        Servo otherOtherClawServo = hardwareMap.servo.get("hand_servo");
        //This is applicable to DcMotors too! Find whichever way is most intuitive for you to understand
    }
    @Override
    public void loop(){

        //When the right bumper is pressed, set the servo position to 1
        if (gamepad1.right_bumper){
            clawServo.setPosition(1);
        }

        //if (gamepad1.right_bumper) clawServo.setPosition(1);

        //When the left bumper is pressed, set the servo position to 0
        else if (gamepad1.left_bumper){
            clawServo.setPosition(0);
        }

        //else if (gamepad1.left_bumper) clawServo.setPosition(0);

    }

}
