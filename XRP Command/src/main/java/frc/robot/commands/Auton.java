package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.XRPDrivetrain;

public class Auton extends Command{
  private final XRPDrivetrain m_XRPDrivetrain;

  public Auton(XRPDrivetrain XRPDrivetrain) {
    m_XRPDrivetrain = XRPDrivetrain;
    addRequirements(XRPDrivetrain);
  }

    public void initialize() {
      System.out.println("Auton start");
      Commands.waitSeconds(5).schedule();
      

      Commands.sequence(
        Commands.race(
          Commands.run(() -> m_XRPDrivetrain.arcadeDrive(1, 0.5), m_XRPDrivetrain),
          Commands.waitSeconds(3)
        )
        ).schedule();;
    }
}