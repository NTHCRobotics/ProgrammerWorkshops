package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


//Intended purpose: Teach programmers to create, change, and delete telemetry... in a fun way
/* Prompt: [name] has 100 braincells. For every second of runtime, they lose 0.7 braincells
 * Display braincells left in telemetry during init
 */
@TeleOp(name="BraincellBot", group="Roboxolotls") //IMPORTANT! Add this to the top, or it will not display in the virtual robot selector list
public class BraincellBot extends OpMode {

    @Override //Delete this if it throws an error
    public void init(){}
        // Here is where you will put telemetry you want to be added ONCE when 'init' is pressed.
        // Because we have code in init_loop, which will erase our init telemetry almost immediately, we leave this blank
        // For telemetry, use this if you have only non-changing values that must be set once
    @Override //Delete this if it throws an error
    public void init_loop(){
        double time = getRuntime(); //Set time to variable for convenience
        double braincells = 100 - (getRuntime()*0.7); //Calculate braincells remaining, 100 to start, 0.7 decreases every 1 second of runtime
        //OPTIONAL!!! IF YOU HAVE NOT READ JAVA FOR FTC, YOU DON'T NEED TO DO THIS! SKIP TO THE [PROCEED]
        if (braincells < 0.0){
            braincells = 0;
        }
        //[PROCEED]
        telemetry.addData("Braincells Remaining", braincells); //Put number of braincells into telemetry
    }

    @Override //Delete this if it throws an error
    public void start(){
        telemetry.clearAll(); //Optional, erase telemetry when exiting init and bot is started.
        // You will rarely put direct telemetry in start, as most important things you would want to see tend to change over time, which would be handled by loop
    }

    @Override //Delete this if it throws an error
    public void loop(){}
        // Nothing's in here yet, but usually you will have your position, encoder ticks, heading, etc.
}