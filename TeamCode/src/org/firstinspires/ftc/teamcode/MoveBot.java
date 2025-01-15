package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name="MoveBot", group="Roboxolotls")
public class MoveBot extends OpMode{
    //Declare motors for wheels
    private DcMotorEx wheelFL;
    private DcMotorEx wheelFR;
    private DcMotorEx wheelBL;
    private DcMotorEx wheelBR;

    // Speed constant, this will hold out speed modifier ([0, 1])
    private double SPEED;

    @Override
    public void init() {
        //Add init status to telemetry
        telemetry.addData("Status", "init() started");

        //Set up wheels
        wheelFL = hardwareMap.get(DcMotorEx.class, "front_left_motor");
        wheelFR = hardwareMap.get(DcMotorEx.class, "front_right_motor");
        wheelBL = hardwareMap.get(DcMotorEx.class, "back_left_motor");
        wheelBR = hardwareMap.get(DcMotorEx.class, "back_right_motor");

        wheelFL.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        wheelFR.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        wheelBL.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        wheelBR.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);

        // Right side reverse direction to gave all wheels the same +y direction
        wheelFR.setDirection(DcMotorSimple.Direction.REVERSE);
        wheelBR.setDirection(DcMotorSimple.Direction.REVERSE);

        // Set speed modifier (value will be the MAX power)
        SPEED = 1.0;

    }

    //Runs constantly while OpMode
    @Override
    public void loop() {
        control();
        telemetry.update(); // Technically works fine without this, it's just safer to use it
    }

    public void control() {
        //Get x, y, and rotational input
        double x = gamepad1.left_stick_x;
        double y = gamepad1.left_stick_y;
        double rotation = gamepad1.right_stick_x;

        //Set power to each wheel depending on x, y, and rotation
        wheelFL.setPower((y - rotation - x) * SPEED);
        wheelFR.setPower((y + rotation + x) * SPEED);
        wheelBL.setPower((y - rotation + x) * SPEED);
        wheelBR.setPower((y + rotation - x) * SPEED);

        //Add data to telemetry
        telemetry.addData("X Movement", x);
        telemetry.addData("Y Movement", y);
        telemetry.addData("Rotational Movement", rotation);

    }


}