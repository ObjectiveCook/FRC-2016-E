package main.commands;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.WaitCommand;
import main.Robot;
import edu.wpi.first.wpilibj.command.CommandGroup;//Alex

/**
 *
 */
public class setSpaghetti extends CommandGroup {//Alex (used to be extends Command)

	
    public setSpaghetti(double speed){
    	if (speed != 0){
    		System.out.println("hey");
    	addSequential(new Spaghetti(speed));//Alex
    	addSequential(new WaitCommand(200));//Alex
    	addSequential(new Spaghetti(speed + 0.2));//Alex
    	addSequential(new WaitCommand(200));//Alex
    	addSequential(new Spaghetti(speed + 0.3));//Alex
    	end();
    	}
    	else
    		new Spaghetti(0);
    		end();
    }
}
